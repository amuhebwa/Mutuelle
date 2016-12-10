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

public class PlanDataObj {
    public static final String TAG = "Plan data object";
    private Context context;

    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private String[] allColumns = {dbHelper.planKey,dbHelper.planID, dbHelper.planName, DBHelper.planCost, dbHelper.description };

    public PlanDataObj(Context context) {
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

    //Get count of all plans
    public int getPlansCount(){
        String countQuery = "SELECT  * FROM " + dbHelper.plansTable;
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    //Create a plan
    public Plan createPlan(String planID, String planName, double cost, String desc){
        ContentValues values = new ContentValues();

        values.put(dbHelper.planID, planID);
        values.put(dbHelper.planName, planName);
        values.put(dbHelper.planCost, cost);
        values.put(dbHelper.description, desc);

        long insertId = db.insert(dbHelper.plansTable, null, values);
        Cursor cursor = db.query(dbHelper.plansTable, allColumns, dbHelper.planKey + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Plan createdPlan = cursorToPlan(cursor);
        cursor.close();
        return createdPlan;
    }

    //Delete a plan
    public void deletePlan(Plan plan) {
        long id = plan.getPlanKey();

        db.delete(dbHelper.plansTable, dbHelper.planKey + " = " + id, null);
    }

    //Get all Plans
    public List<Plan> getAllPlans() {
        List<Plan> listPlans = new ArrayList<Plan>();

        Cursor cursor = db.query(DBHelper.plansTable, allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Plan retrievedPlan = cursorToPlan(cursor);
            listPlans.add(retrievedPlan);
            cursor.moveToNext();
        }

        cursor.close();
        return listPlans;
    }

    //Get plan representation of plan database object
    private Plan cursorToPlan(Cursor cursor){
        Plan plan = new Plan();
        if (cursor.moveToFirst()) {
            plan.setPlanKey(cursor.getLong(0));
            plan.setPlanId(cursor.getString(1));
            plan.setPlanName(cursor.getString(2));
            plan.setPlanCost(Double.parseDouble(cursor.getString(3)));
            plan.setDescription(cursor.getString(4));
        }

        return plan;
    }

    //Close database
    public void close() {
        dbHelper.close();
    }
}
