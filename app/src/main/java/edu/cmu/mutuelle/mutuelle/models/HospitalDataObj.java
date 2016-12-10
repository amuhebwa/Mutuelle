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

public class HospitalDataObj {
    public static final String TAG = "Hospital data object";
    private Context context;

    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private String[] allColumns = {dbHelper.hospitalKey,dbHelper.hospitalID, dbHelper.hospitalName, DBHelper.tillNumber,
            dbHelper.latitude, dbHelper.logitude
    };

    public HospitalDataObj(Context context) {
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

    //Get count of all hospitals
    public int getHospitalCount(){
        String countQuery = "SELECT  * FROM " + dbHelper.hospitalsTable;
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    //Create a hospital
    public Hospital createHospital(String hosID, String hosName, int tillNum, double lat, double log){
        ContentValues values = new ContentValues();

        values.put(dbHelper.hospitalID, hosID);
        values.put(dbHelper.hospitalName, hosName);
        values.put(dbHelper.tillNumber, tillNum);
        values.put(dbHelper.latitude, lat);
        values.put(dbHelper.logitude, log);

        long insertId = db.insert(dbHelper.hospitalsTable, null, values);
        Cursor cursor = db.query(dbHelper.hospitalsTable, allColumns, dbHelper.hospitalKey + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Hospital createdHospital = cursorToHospital(cursor);
        cursor.close();
        return createdHospital;
    }

    //Delete a hospital
    public void deleteHospital(Hospital hospital) {
        long id = hospital.getHospitalKey();

        db.delete(dbHelper.hospitalsTable, dbHelper.hospitalKey + " = " + id, null);
    }

    //Get all hospitals
    public List<Hospital> getAllHospitals() {
        List<Hospital> listHospitals = new ArrayList<Hospital>();

        Cursor cursor = db.query(DBHelper.hospitalsTable, allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Hospital retrievedHospital = cursorToHospital(cursor);
            listHospitals.add(retrievedHospital);
            cursor.moveToNext();
        }

        cursor.close();
        return listHospitals;
    }

    //Get hospital representation of hospital database object
    private Hospital cursorToHospital(Cursor cursor){
        Hospital hospital = new Hospital();
        if (cursor.moveToFirst()) {
            hospital.setHospitalKey(cursor.getLong(0));
            hospital.setHospitalId(cursor.getString(1));
            hospital.setHospitalName(cursor.getString(2));
            hospital.setTinNumber(cursor.getString(3));
            hospital.setLatitude(cursor.getString(4));
            hospital.setLongitude(cursor.getString(5));
        }

        return hospital;
    }

    //Close database
    public void close() {
        dbHelper.close();
    }
}
