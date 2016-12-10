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
 * Created by nmunyoki on 12/9/16.
 */

public class CheckinDataObj {
    public static final String TAG = "Checkin data object";
    private Context context;

    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private String[] allColumns = {dbHelper.checkinKey,dbHelper.userNationalID, dbHelper.secondaryUser, DBHelper.hospitalID,
            dbHelper.inTime, dbHelper.outTime };

    public CheckinDataObj(Context context) {
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

    //Check if there is active checkin - Out time is null
    public boolean isCheckinActive(User user){
        boolean active = false;
        String userNationalId = user.getNationalId();

        String rawQuery = "SELECT  * FROM " + dbHelper.checkinsTable+" WHERE "+dbHelper.userNationalID+" = "+userNationalId+" AND "+dbHelper.outTime+" IS NULL";
        Cursor cursor = db.rawQuery(rawQuery, null);

        if (cursor.getCount() >= 1){
            active = true;
        }

        return active;
    }

    //Get active checkin
    public Checkin getActiveCheckin(User user){
        String userNationalId = user.getNationalId();

        String rawQuery = "SELECT  * FROM " + dbHelper.checkinsTable+" WHERE "+dbHelper.userNationalID+" = "+userNationalId+" AND "+dbHelper.outTime+" IS NULL";
        Cursor cursor = db.rawQuery(rawQuery, null);

        Checkin checkin = cursorToCheckin(cursor);
        return checkin;
    }

    //Update checkin out time
    public int updateCheckoutTime(long checkinKey){
        ContentValues values = new ContentValues();
        values.put(dbHelper.outTime, String.valueOf(new Date()));

        return db.update(dbHelper.checkinsTable, values, dbHelper.checkinKey + " = ?", new String[] { String.valueOf(checkinKey) });
    }

    //Create a Checkin
    public Checkin createCheckin(String userNatId, String secUser, String hosId){
        ContentValues values = new ContentValues();

        String inTime = String.valueOf(new Date());
        values.put(dbHelper.userNationalID, userNatId);
        values.put(dbHelper.secondaryUser, secUser);
        values.put(dbHelper.hospitalID, hosId);
        values.put(dbHelper.inTime, inTime);

        long insertId = db.insert(dbHelper.checkinsTable, null, values);
        Cursor cursor = db.query(dbHelper.checkinsTable, allColumns, dbHelper.checkinKey + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Checkin createdCheckin = cursorToCheckin(cursor);
        cursor.close();
        return createdCheckin;
    }

    //Get user Checkins
    public List<Checkin> getAllCheckins(User user) {
        List<Checkin> listCheckins = new ArrayList<Checkin>();

        String nationalId = user.getNationalId();
        Cursor cursor = db.query(dbHelper.checkinsTable, allColumns, dbHelper.userNationalID + " = " + nationalId, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Checkin retrievedCheckin = cursorToCheckin(cursor);
            listCheckins.add(retrievedCheckin);
            cursor.moveToNext();
        }

        cursor.close();
        return listCheckins;
    }

    //Get Checkin representation of checkin database object
    private Checkin cursorToCheckin(Cursor cursor){
        Checkin checkin = new Checkin();
        if (cursor.moveToFirst()) {
            checkin.setCheckinKey(cursor.getLong(0));
            checkin.setUserNationalID(cursor.getString(1));
            checkin.setSecondaryUser(cursor.getString(2));
            checkin.setHospitalId(cursor.getString(3));
            checkin.setCheckInTime(cursor.getString(4));
        }

        return checkin;
    }

    //Close database
    public void close() {
        dbHelper.close();
    }
}
