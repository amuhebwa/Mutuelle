package edu.cmu.mutuelle.mutuelle.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by bmunyoki on 12/7/16.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String TAG = "DBHelper";

    //Database variables
    private static final String DATABASE_NAME = "mutuelle.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Users table
    public static final String usersTable = "users";
    public static final String userKey = "user_key";
    public static final String firstName = "first_name";
    public static final String lastName = "last_name";
    public static final String nationalID = "national_id";
    public static final String password = "password";
    public static final String dob = "dob";
    public static final String cardPicture = "card_picture";
    public static final String signupTime = "signup_time";

    private static final String createUsersTable = "CREATE TABLE " + usersTable + "("
            + userKey + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + firstName + " TEXT NOT NULL, "
            + lastName + " TEXT NOT NULL, "
            + nationalID + " TEXT NOT NULL, "
            + dob + " TEXT NOT NULL, "
            + cardPicture + " TEXT, "
            + signupTime + " TEXT, "
            + password + " TEXT NOT NULL "
            +");";

    //Plans table
    public static final String plansTable = "plans";
    public static final String planKey = "plan_key";
    public static final String planID = "plan_id";
    public static final String planName = "plan_name";
    public static final String planCost = "plan_cost";
    public static final String description = "description";

    private static final String createPlansTable = "CREATE TABLE " + plansTable + "("
            + planKey + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + planID + " TEXT NOT NULL, "
            + planName + " TEXT NOT NULL, "
            + planCost + " REAL NOT NULL, "
            + description + " TEXT "
            +");";

    //Subscriptions table
    public static final String subscriptionsTable = "subscriptions";
    public static final String subscriptionKey = "subscription_key";
    public static final String userNationalID = "user_national_id";
    public static final String startDate = "start_date";
    public static final String endDate = "end_date";
    public static final String status = "status";

    private static final String createSubscriptionsTable = "CREATE TABLE " + subscriptionsTable + "("
            + subscriptionKey + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + userNationalID + " TEXT NOT NULL, "
            + planID + " TEXT NOT NULL, "
            + startDate + " TEXT NOT NULL, "
            + endDate + " TEXT NOT NULL, "
            + status + " INTEGER "
            +");";

    //Dependants table
    public static final String depedantsTable = "depedants";
    public static final String depedantKey = "depedant_key";
    public static final String depedantFirstName = "first_name";
    public static final String depedantLastName = "last_name";
    public static final String depedantDOB = "dob";
    public static final String depedantNationalID = "depedant_national_id";
    public static final String inTime = "in_time";

    private static final String createDepedantsTable = "CREATE TABLE " + depedantsTable + "("
            + depedantKey + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + depedantFirstName + " TEXT NOT NULL, "
            + depedantLastName + " TEXT NOT NULL, "
            + depedantDOB + " TEXT, "
            + userNationalID + " TEXT, "
            + depedantNationalID + " TEXT, "
            + cardPicture + " TEXT, "
            + inTime + " TEXT "
            +");";

    //Hospitals table
    public static final String hospitalsTable = "hospitals";
    public static final String hospitalKey = "hospital_key";
    public static final String hospitalID = "hospital_id";
    public static final String hospitalName = "name";
    public static final String tillNumber = "till_number";
    public static final String latitude = "latitude";
    public static final String logitude = "logitude";

    private static final String createHospitalsTable = "CREATE TABLE " + hospitalsTable + "("
            + hospitalKey + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + hospitalID + " TEXT NOT NULL, "
            + hospitalName + " TEXT, "
            + tillNumber + " TEXT, "
            + latitude + " TEXT, "
            + logitude + " TEXT "
            +");";

    //Checkins table
    public static final String checkinsTable = "checkins";
    public static final String checkinKey = "checkin_key";
    public static final String secondaryUser = "secondary_user";
    public static final String outTime = "out_time";

    private static final String createCheckinsTable = "CREATE TABLE " + checkinsTable + "("
            + checkinKey + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + userNationalID + " TEXT NOT NULL, "
            + secondaryUser + " TEXT, "
            + hospitalID + " TEXT, "
            + inTime + " TEXT, "
            + outTime + " TEXT "
            +");";

    //Services table
    public static final String servicesTable = "services";
    public static final String serviceKey = "service_key";
    public static final String serviceID = "service_id";
    public static final String serviceCost = "service_cost";

    private static final String createServicesTable = "CREATE TABLE " + servicesTable + "("
            + serviceKey + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + serviceID + " TEXT NOT NULL, "
            + hospitalID + " TEXT NOT NULL, "
            + description + " TEXT, "
            + serviceCost + " REAL "
            +");";

    //Treatments table
    public static final String treatmentsTable = "treatments";
    public static final String treatmentKey = "treatment_key";
    public static final String pathToRecording = "path_to_recording";

    private static final String createTreatmentsTable = "CREATE TABLE " + treatmentsTable + "("
            + treatmentKey + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + checkinKey + " INTEGER NOT NULL, "
            + serviceID + " TEXT, "
            + inTime + " TEXT, "
            + pathToRecording + " TEXT "
            +");";

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(createUsersTable);
        database.execSQL(createPlansTable);
        database.execSQL(createSubscriptionsTable);
        database.execSQL(createDepedantsTable);
        database.execSQL(createHospitalsTable);
        database.execSQL(createCheckinsTable);
        database.execSQL(createServicesTable);
        database.execSQL(createTreatmentsTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "Upgrading the database from version " + oldVersion + " to "+ newVersion);

        //Drop all the tables
        db.execSQL("DROP TABLE IF EXISTS " + usersTable);
        db.execSQL("DROP TABLE IF EXISTS " + plansTable);
        db.execSQL("DROP TABLE IF EXISTS " + subscriptionsTable);
        db.execSQL("DROP TABLE IF EXISTS " + depedantsTable);
        db.execSQL("DROP TABLE IF EXISTS " + hospitalsTable);
        db.execSQL("DROP TABLE IF EXISTS " + checkinsTable);
        db.execSQL("DROP TABLE IF EXISTS " + servicesTable);
        db.execSQL("DROP TABLE IF EXISTS " + treatmentsTable);

        //Recreate all the tables
        onCreate(db);
    }

}
