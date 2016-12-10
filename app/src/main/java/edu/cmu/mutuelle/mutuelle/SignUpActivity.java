package edu.cmu.mutuelle.mutuelle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SignUpActivity extends AppCompatActivity {
<<<<<<< HEAD
    private EditText firstNameTxt, lastNameTxt, passwordTxt, nationalIDTxt;
=======
    private EditText firstName, lastName, password, nationalID, dateOfBirth;
>>>>>>> 90b3904798dcb9a8253b8cb5c355f997bcc39e10
    private ImageButton takePicture;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
<<<<<<< HEAD
        firstNameTxt = (EditText) findViewById(R.id.firstname);
        lastNameTxt = (EditText) findViewById(R.id.lastname);
        passwordTxt = (EditText) findViewById(R.id.password);
        nationalIDTxt = (EditText) findViewById(R.id.nationalId);
=======
        firstName = (EditText) findViewById(R.id.firstname);
        lastName = (EditText) findViewById(R.id.lastname);
        dateOfBirth = (EditText) findViewById(R.id.dateOfBirth);
        password = (EditText) findViewById(R.id.password);
        nationalID = (EditText) findViewById(R.id.nationalId);
>>>>>>> 90b3904798dcb9a8253b8cb5c355f997bcc39e10
        takePicture = (ImageButton) findViewById(R.id.takePicture);
        signupButton = (Button) findViewById(R.id.signupButton);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserDetails();
            }
        });
        takePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture();
            }
        });
    }

    private void saveUserDetails() {
        String firstname = firstNameTxt.getText().toString();
        String lastname = lastNameTxt.getText().toString();
        String password = passwordTxt.getText().toString();
        String nationalId = nationalIDTxt.getText().toString();

    }

    private void takePicture(){
        startActivity(new Intent(SignUpActivity.this, CameraActivity.class));
    }
}
