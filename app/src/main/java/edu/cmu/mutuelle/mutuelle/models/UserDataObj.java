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
 * Created by bmunyoki on 12/8/16.
 */

public class UserDataObj {
    public static final String TAG = "User data object";
    private Context context;

    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private String[] allColumns = {dbHelper.userKey,dbHelper.firstName, dbHelper.lastName, DBHelper.nationalID,
            dbHelper.dob, dbHelper.cardPicture, dbHelper.signupTime
    };

    public UserDataObj(Context context) {
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

    //Create a user
    public User createUser(String firstName, String lastName, int nationalID, String DOB, String cardPic, String pass){
        ContentValues values = new ContentValues();
        String currentSignUpTime = String.valueOf(new Date());
        values.put(dbHelper.firstName, firstName);
        values.put(dbHelper.lastName, lastName);
        values.put(dbHelper.nationalID, nationalID);
        values.put(dbHelper.dob, DOB);
        values.put(dbHelper.cardPicture, cardPic);
        values.put(dbHelper.signupTime, currentSignUpTime);
        values.put(dbHelper.password, pass);

        long insertId = db.insert(dbHelper.usersTable, null, values);
        Cursor cursor = db.query(dbHelper.usersTable, allColumns, dbHelper.userKey + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        User createdUser = cursorToUser(cursor);
        cursor.close();
        return createdUser;
    }

    //Create a user without card pic
    public User createUser(String firstName, String lastName, int nationalID, String DOB, String pass){
        ContentValues values = new ContentValues();
        String currentSignUpTime = String.valueOf(new Date());
        values.put(dbHelper.firstName, firstName);
        values.put(dbHelper.lastName, lastName);
        values.put(dbHelper.nationalID, nationalID);
        values.put(dbHelper.dob, DOB);
        values.put(dbHelper.signupTime, currentSignUpTime);
        values.put(dbHelper.password, pass);

        long insertId = db.insert(dbHelper.usersTable, null, values);
        Cursor cursor = db.query(dbHelper.usersTable, allColumns, dbHelper.userKey + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        User createdUser = cursorToUser(cursor);
        cursor.close();
        return createdUser;
    }

    //Delete a user
    public void deleteUser(User user) {
        long id = user.getUserId();

        db.delete(dbHelper.usersTable, dbHelper.userKey + " = " + id, null);
    }

    //Get all users
    public List<User> getAllUsers() {
        List<User> listUsers = new ArrayList<User>();

        Cursor cursor = db.query(DBHelper.usersTable, allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            User retrievedUser = cursorToUser(cursor);
            listUsers.add(retrievedUser);
            cursor.moveToNext();
        }

        cursor.close();
        return listUsers;
    }

    //Select user password
    public String getUserPassword(User user){
        String nationalID = user.getNationalId();
        Cursor cursor = db.query(dbHelper.usersTable, allColumns, dbHelper.nationalID + " = ?",
                new String[] { String.valueOf(nationalID) }, null, null, null);
        User newUser = cursorToUser(cursor);
        String password = newUser.getPassword();
        cursor.close();
        return password;
    }


    //Select user password - takes national D
    public String getUserPassword(String nationalID){
        Cursor cursor = db.query(dbHelper.usersTable, allColumns, dbHelper.nationalID + " = ?",
                new String[] { String.valueOf(nationalID) }, null, null, null);
        User newUser = cursorToUser(cursor);
        String password = newUser.getPassword();
        cursor.close();
        return password;
    }

    //Get user representation of user database object
    private User cursorToUser(Cursor cursor){
        User user = new User();
        user.setid(cursor.getLong(0));
        user.setFirstName(cursor.getString(1));
        user.setLastName(cursor.getString(2));
        user.setNationalId(cursor.getString(3));
        user.setDOB(cursor.getString(4));
        user.setCardPicturePath(cursor.getString(5));

        return user;
    }

    //Close database
    public void close() {
        dbHelper.close();
    }
}
