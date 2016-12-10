package edu.cmu.mutuelle.mutuelle.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bmunyoki on 12/9/16.
 */

public class ServiceDataObj {
    public static final String TAG = "Service data object";
    private Context context;

    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private String[] allColumns = {dbHelper.serviceKey,dbHelper.serviceID, dbHelper.hospitalID, DBHelper.description,
            dbHelper.serviceCost
    };

    public ServiceDataObj(Context context) {
        dbHelper = new DBHelper(context);
        this.context = context;
        // open the database
        try {
            open();
        } catch (SQLException e) {
            Log.e(TAG, "SQLException on opening database " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    //Get count of all services
    public int getServicesCount(){
        String countQuery = "SELECT  * FROM " + dbHelper.servicesTable;
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    //Create a service using hospital object
    public Service createService(String servID, Hospital hospital, String desc, double cost){
        ContentValues values = new ContentValues();
        String hosID = hospital.getHospitalId();

        values.put(dbHelper.serviceID, servID);
        values.put(dbHelper.hospitalID, hosID);
        values.put(dbHelper.description, desc);
        values.put(dbHelper.serviceCost, cost);

        long insertId = db.insert(dbHelper.servicesTable, null, values);
        Cursor cursor = db.query(dbHelper.servicesTable, allColumns, dbHelper.serviceKey + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Service createdService = cursorToService(cursor);
        cursor.close();
        return createdService;
    }

    //Create a service using hospital ID
    public Service createService(String servID, String hosID, String desc, double cost){
        ContentValues values = new ContentValues();

        values.put(dbHelper.serviceID, servID);
        values.put(dbHelper.hospitalID, hosID);
        values.put(dbHelper.description, desc);
        values.put(dbHelper.serviceCost, cost);

        long insertId = db.insert(dbHelper.servicesTable, null, values);
        Cursor cursor = db.query(dbHelper.servicesTable, allColumns, dbHelper.serviceKey + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Service createdService = cursorToService(cursor);
        cursor.close();
        return createdService;
    }

    //Delete a service
    public void deleteService(Service service) {
        long id = service.getServiceKey();

        db.delete(dbHelper.servicesTable, dbHelper.serviceKey + " = " + id, null);
    }

    //Get all services
    public List<Service> getAllServices() {
        List<Service> listServices = new ArrayList<Service>();

        Cursor cursor = db.query(DBHelper.servicesTable, allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Service retrievedService = cursorToService(cursor);
            listServices.add(retrievedService);
            cursor.moveToNext();
        }

        cursor.close();
        return listServices;
    }

    //Get all services per hospital
    public List<Service> getAllServicesByHospital(Hospital hospital) {
        List<Service> listServices = new ArrayList<Service>();

        String hospitalID = hospital.getHospitalId();
        Cursor cursor = db.query(dbHelper.servicesTable, allColumns, dbHelper.hospitalID + " = " + hospitalID, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Service retrievedService = cursorToService(cursor);
            listServices.add(retrievedService);
            cursor.moveToNext();
        }

        cursor.close();
        return listServices;
    }

    //Get Service representation of user database object
    private Service cursorToService(Cursor cursor){
        Service service = new Service();
        if (cursor.moveToFirst()) {
            service.setServiceKey(cursor.getLong(0));
            service.setServiceId(cursor.getString(1));
            service.setHospitalId(cursor.getString(2));
            service.setDescription(cursor.getString(3));
            service.setCost(Double.parseDouble(cursor.getString(4)));
        }

        return service;
    }

    //Close database
    public void close() {
        dbHelper.close();
    }
}
