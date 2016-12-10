package edu.cmu.mutuelle.mutuelle.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bmunyoki on 12/9/16.
 */

public class DependantDataObj {
    public static final String TAG = "Dependant data object";
    private Context context;

    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private String[] allColumns = {dbHelper.depedantKey,dbHelper.depedantFirstName, dbHelper.depedantLastName,
            DBHelper.depedantDOB, dbHelper.userNationalID, dbHelper.depedantNationalID, dbHelper.cardPicture,
            dbHelper.inTime };

    public DependantDataObj(Context context) {
        dbHelper = new DBHelper(context);
        this.context = context;
        // open the database
        try {
            open();
        } catch (SQLException e) {
            Log.e(TAG, "SQLException on openning database " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    //Create a dependant
    public Dependant createDependant(String fName, String lName, String dob, String uNatId, String depNatId, String cardPic){
        ContentValues values = new ContentValues();
        String inTime = String.valueOf(new Date());

        values.put(dbHelper.firstName, fName);
        values.put(dbHelper.lastName, lName);
        values.put(dbHelper.depedantDOB, dob);
        values.put(dbHelper.userNationalID, uNatId);
        values.put(dbHelper.depedantNationalID, depNatId);
        values.put(dbHelper.cardPicture, uNatId);
        values.put(dbHelper.inTime, inTime);

        long insertId = db.insert(dbHelper.depedantsTable, null, values);
        Cursor cursor = db.query(dbHelper.depedantsTable, allColumns, dbHelper.depedantKey + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Dependant createdDependant = cursorToDependant(cursor);
        cursor.close();
        return createdDependant;
    }

    //Create a dependant - Overide. No dependant national Id
    public Dependant createDependant(String fName, String lName, String dob, String uNatId, String cardPic){
        ContentValues values = new ContentValues();
        String inTime = String.valueOf(new Date());

        values.put(dbHelper.firstName, fName);
        values.put(dbHelper.lastName, lName);
        values.put(dbHelper.depedantDOB, dob);
        values.put(dbHelper.userNationalID, uNatId);
        values.put(dbHelper.cardPicture, uNatId);
        values.put(dbHelper.inTime, inTime);

        long insertId = db.insert(dbHelper.depedantsTable, null, values);
        Cursor cursor = db.query(dbHelper.depedantsTable, allColumns, dbHelper.depedantKey + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Dependant createdDependant = cursorToDependant(cursor);
        cursor.close();
        return createdDependant;
    }


    //Delete a dependant
    public void deleteDependant(Dependant dependant) {
        long id = dependant.getDependantKey();

        db.delete(dbHelper.depedantsTable, dbHelper.depedantKey + " = " + id, null);
    }

    //Get dependants per user
    public List<Dependant> getDependantsPerUser(User user) {
        List<Dependant> listDependants = new ArrayList<Dependant>();

        String userNationalId = user.getNationalId();
        Cursor cursor = db.query(dbHelper.depedantsTable, allColumns, dbHelper.userNationalID + " = " + userNationalId, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Dependant retrievedDependant = cursorToDependant(cursor);
            listDependants.add(retrievedDependant);
            cursor.moveToNext();
        }

        cursor.close();
        return listDependants;
    }

    //Get Dependant representation of dependant database object
    private Dependant cursorToDependant(Cursor cursor){
        Dependant dependant = new Dependant();
        if (cursor.moveToFirst()) {
            dependant.setDependantKey(cursor.getLong(0));
            dependant.setDependantFirstName(cursor.getString(1));
            dependant.setDependantLastName(cursor.getString(2));
            dependant.setDependantDOB(cursor.getString(3));
            dependant.setUserNationalId(cursor.getString(4));
            dependant.setDependantNationalId(cursor.getString(4));
            dependant.setDependantCardPic(cursor.getString(4));
            dependant.setDependantAddTime(cursor.getString(4));
        }

        return dependant;
    }

    //Close database
    public void close() {
        dbHelper.close();
    }
}
