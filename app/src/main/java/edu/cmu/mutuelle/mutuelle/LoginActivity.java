package edu.cmu.mutuelle.mutuelle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

import edu.cmu.mutuelle.mutuelle.models.DBHelper;
import edu.cmu.mutuelle.mutuelle.models.HospitalDataObj;
import edu.cmu.mutuelle.mutuelle.models.PlanDataObj;
import edu.cmu.mutuelle.mutuelle.models.ServiceDataObj;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameTxt, passwordTxt;
    DBHelper dbHelper;
    HospitalDataObj hospital;
    ServiceDataObj service;
    PlanDataObj plan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        usernameTxt = (EditText) findViewById(R.id.username);
        passwordTxt = (EditText) findViewById(R.id.password);

        //Check if database exists. If not, create one.
        File database = getApplicationContext().getDatabasePath("mutuelle.db");
        if (!database.exists()) {
            // Database does not exist, create one
            dbHelper = new DBHelper(getApplicationContext());
            Log.i("Database", "Not Found ... created");
        } else {
            Log.i("Database", "Found");
        }

        //Check if there are hospitals. If not, add
        hospital = new HospitalDataObj(getApplicationContext());
        int hospitalCount = hospital.getHospitalCount();
        if (hospitalCount == 0){
            addHospitals();
        }

        //Check if there are services. If not, add
        service = new ServiceDataObj(getApplicationContext());
        int serviceCount = service.getServicesCount();
        if (serviceCount == 0){
            addServices();
        }

        //Check if there are plans. If not, create
        plan = new PlanDataObj(getApplicationContext());
        int planCount = plan.getPlansCount();
        if (planCount == 0){
            addPlans();
        }


        Button signUpButton = (Button) findViewById(R.id.signupButton);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateUserDetails();
            }
        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
    }
    // validate user details
    private void validateUserDetails() {
        String username = usernameTxt.getText().toString();
        String password = passwordTxt.getText().toString();

        // check if user exists in the database. if true, login, else show a toast message
        startActivity(new Intent(LoginActivity.this, OverViewActivity.class));
    }
    //Add hospitals to DB
    public void addHospitals(){
        hospital.createHospital("KAC001", "Kacyiru District Hospital", 1111, -1.9336289, 30.073016);
        hospital.createHospital("KFS001", "King Faisal Hospital", 2222, -1.9439093, 30.093036);
        hospital.createHospital("KBB001", "Kibagabaga Hospital", 3333, -1.9307927, 30.1097703);
        hospital.createHospital("DRK001", "Dr. Kanimba Hospital", 4444, -1.9448824, 30.0623381);
        hospital.createHospital("LAC001", "Hospital La Croix", 5555, -1.958238, 30.1039546);
    }

    //Add Plans
    public void addPlans(){
        plan.createPlan("MUTIND001", "Mutuelle Individual", 8000.00, "Individual plan. Caters for only one person. No dependants");
        plan.createPlan("MUTFAM001", "Mutuelle Family", 15000.00, "Family plan. Caters for family. Max of 5 dependants");
    }

    //Add services to DB
    public void addServices(){
        //King Faisal
        service.createService("KFSCON01", "KFS001", "Consultation", 8000.00);
        service.createService("KFSLAB01", "KFS001", "Lab - Test 1", 16000.00);
        service.createService("KFSLAB02", "KFS001", "Lab - Test 2", 12000.00);
        service.createService("KFSLAB03", "KFS001", "Lab - Test 3", 2400.00);
        service.createService("KFSMED01", "KFS001", "Medication 1", 24000.00);
        service.createService("KFSMED02", "KFS001", "Medication 2", 4800.00);
        service.createService("KFSMED03", "KFS001", "Medication 3", 700.00);

        //Kacyiru district hospital
        service.createService("KACCON01", "KAC001", "Consultation", 1000.00);
        service.createService("KACLAB01", "KAC001", "Lab - Test 1", 400.00);
        service.createService("KACLAB02", "KAC001", "Lab - Test 2", 4000.00);
        service.createService("KACLAB03", "KAC001", "Lab - Test 3", 300.00);
        service.createService("KACMED01", "KAC001", "Medication 1", 100.00);
        service.createService("KACMED02", "KAC001", "Medication 2", 1000.00);
        service.createService("KACMED03", "KAC001", "Medication 3", 700.00);

        //Kibagabaga hospital
        service.createService("KBBCON01", "KBB001", "Consultation", 5000.00);
        service.createService("KBBLAB01", "KBB001", "Lab - Test 1", 2000.00);
        service.createService("KBBLAB02", "KBB001", "Lab - Test 2", 8000.00);
        service.createService("KBBLAB03", "KBB001", "Lab - Test 3", 2400.00);
        service.createService("KBBMED01", "KBB001", "Medication 1", 1500.00);
        service.createService("KBBMED02", "KBB001", "Medication 2", 8000.00);
        service.createService("KBBMED03", "KBB001", "Medication 3", 5000.00);

        //Dr. Kanimba
        service.createService("DRKCON01", "DRK001", "Consultation", 5000.00);
        service.createService("DRKLAB01", "DRK001", "Lab - Test 1", 2000.00);
        service.createService("DRKLAB02", "DRK001", "Lab - Test 2", 8000.00);
        service.createService("DRKLAB03", "DRK001", "Lab - Test 3", 2400.00);
        service.createService("DRKMED01", "DRK001", "Medication 1", 1500.00);
        service.createService("DRKMED02", "DRK001", "Medication 2", 8000.00);
        service.createService("DRKMED03", "DRK001", "Medication 3", 5000.00);

        //Hospital La Croix
        service.createService("DRKCON01", "LAC001", "Consultation", 7000.00);
        service.createService("DRKLAB01", "LAC001", "Lab - Test 1", 1500.00);
        service.createService("DRKLAB02", "LAC001", "Lab - Test 2", 6000.00);
        service.createService("DRKLAB03", "LAC001", "Lab - Test 3", 2500.00);
        service.createService("DRKMED01", "LAC001", "Medication 1", 4500.00);
        service.createService("DRKMED02", "LAC001", "Medication 2", 5000.00);
        service.createService("DRKMED03", "LAC001", "Medication 3", 8000.00);
    }
}
