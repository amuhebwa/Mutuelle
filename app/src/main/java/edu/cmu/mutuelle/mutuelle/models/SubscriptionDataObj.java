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

public class SubscriptionDataObj {
    public static final String TAG = "Subscription";
    private Context context;

    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private String[] allColumns = {dbHelper.subscriptionKey,dbHelper.userNationalID, dbHelper.planID, DBHelper.startDate,
            dbHelper.endDate, dbHelper.status
    };

    public SubscriptionDataObj(Context context) {
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

    //Update subscription status
    public int updateSubscriptionStatus(User user){
        String userNationalId = user.getNationalId();
        int status = 1;

        ContentValues values = new ContentValues();
        values.put(dbHelper.status, status);

        return db.update(dbHelper.subscriptionsTable, values, dbHelper.userNationalID + " = ?", new String[] { String.valueOf(userNationalId) });

    }

    //Check if user has an active subscription
    public boolean checkActiveSubscription(User user){
        boolean subscribed = false;
        String userNationalId = user.getNationalId();

        Cursor cursor = db.query(dbHelper.subscriptionsTable, allColumns, dbHelper.userNationalID + " = " + userNationalId, null, null, null, null);
        int count = cursor.getCount();

        if(count >= 1){
            subscribed = true;
        }

        return subscribed;
    }

    //Create a Subscription
    public Subscription createSubscription(String uId, String pId, String sDate, String eDate){
        ContentValues values = new ContentValues();
        int status = 0;

        values.put(dbHelper.userNationalID, uId);
        values.put(dbHelper.planID, pId);
        values.put(dbHelper.startDate, sDate);
        values.put(dbHelper.endDate, eDate);
        values.put(dbHelper.status, status);

        long insertId = db.insert(dbHelper.subscriptionsTable, null, values);
        Cursor cursor = db.query(dbHelper.subscriptionsTable, allColumns, dbHelper.subscriptionKey + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Subscription createdSubscription = cursorToSubscription(cursor);
        cursor.close();
        return createdSubscription;
    }

    //Create a Subscription - From User and Plan Object
    public Subscription createSubscription(User user, Plan plan, String sDate, String eDate){
        ContentValues values = new ContentValues();
        int status = 0;
        String uId = user.getNationalId();
        String pId = plan.getPlanId();

        values.put(dbHelper.userNationalID, uId);
        values.put(dbHelper.planID, pId);
        values.put(dbHelper.startDate, sDate);
        values.put(dbHelper.endDate, eDate);
        values.put(dbHelper.status, status);

        long insertId = db.insert(dbHelper.subscriptionsTable, null, values);
        Cursor cursor = db.query(dbHelper.subscriptionsTable, allColumns, dbHelper.subscriptionKey + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Subscription createdSubscription = cursorToSubscription(cursor);
        cursor.close();
        return createdSubscription;
    }

    //Delete a subscriber
    public void deleteSubscriber(Subscription subscription) {
        long id = subscription.getSubsriptionKey();

        db.delete(dbHelper.subscriptionsTable, dbHelper.subscriptionKey + " = " + id, null);
    }

    //Get my Subscriptions
    public List<Subscription> getAllMySubscriptions(User user) {
        List<Subscription> listSubscriptions = new ArrayList<Subscription>();

        String nationalId = user.getNationalId();
        Cursor cursor = db.query(dbHelper.subscriptionsTable, allColumns, dbHelper.subscriptionKey + " = " + nationalId, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Subscription retrievedSubscription = cursorToSubscription(cursor);
            listSubscriptions.add(retrievedSubscription);
            cursor.moveToNext();
        }

        cursor.close();
        return listSubscriptions;
    }

    //Get Subscription representation of subscription database object
    private Subscription cursorToSubscription(Cursor cursor){
        Subscription subscription = new Subscription();
        if (cursor.moveToFirst()) {
            subscription.setSubsciptionKey(cursor.getLong(0));
            subscription.setUserNationalId(cursor.getString(2));
            subscription.setPlanId(cursor.getString(1));
            subscription.setStartDate(cursor.getString(3));
            subscription.setEndDate(cursor.getString(4));
            subscription.setStatus(Integer.parseInt(cursor.getString(4)));
        }

        return subscription;
    }

    //Close database
    public void close() {
        dbHelper.close();
    }
}
