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
 * Created by bmunyoki on 12/11/16.
 */

public class ReportDataObj {
    public static final String TAG = "Report data object";
    private Context context;

    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private String[] allColumns = {dbHelper.userKey,dbHelper.firstName, dbHelper.lastName, DBHelper.nationalID,
            dbHelper.dob, dbHelper.cardPicture, dbHelper.signupTime
    };

    public ReportDataObj(Context context) {
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

    //Get all user treatments
    public List<Treatment> getAllTreatments(long checkinKey) {
        List<Treatment> listTreatments = new ArrayList<Treatment>();

        Cursor cursor = db.query(dbHelper.treatmentsTable, allColumns, dbHelper.checkinKey + " = " + checkinKey, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Treatment retrievedTreatment = cursorToTreatment(cursor);
            listTreatments.add(retrievedTreatment);
            cursor.moveToNext();
        }

        cursor.close();
        return listTreatments;
    }

    //Get Treatment representation of treatment database object
    private Treatment cursorToTreatment(Cursor cursor){
        Treatment treatment = new Treatment();
        if (cursor.moveToFirst()) {
            treatment.setTreatmentKey(cursor.getLong(0));
            treatment.setCheckinId(Long.parseLong(cursor.getString(1)));
            treatment.setServiceId(cursor.getString(2));
            treatment.setTimeStamp(cursor.getString(3));
            treatment.setAudioPath(cursor.getString(4));
        }

        return treatment;
    }

    //Close database
    public void close() {
        dbHelper.close();
    }
}
