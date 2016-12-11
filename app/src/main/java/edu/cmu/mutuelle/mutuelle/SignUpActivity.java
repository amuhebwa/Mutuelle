package edu.cmu.mutuelle.mutuelle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import edu.cmu.mutuelle.mutuelle.models.UserDataObj;

public class SignUpActivity extends AppCompatActivity {

    private EditText firstNameTxt, lastNameTxt, passwordTxt, nationalIDTxt;

    private EditText firstName, lastName, password, nationalID, dateOfBirth;
    private ImageButton takePicture;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        firstNameTxt = (EditText) findViewById(R.id.firstname);
        lastNameTxt = (EditText) findViewById(R.id.lastname);
        passwordTxt = (EditText) findViewById(R.id.password);
        nationalIDTxt = (EditText) findViewById(R.id.nationalId);
        firstName = (EditText) findViewById(R.id.firstname);
        lastName = (EditText) findViewById(R.id.lastname);
        dateOfBirth = (EditText) findViewById(R.id.dateOfBirth);
        password = (EditText) findViewById(R.id.password);
        nationalID = (EditText) findViewById(R.id.nationalId);
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
        String firstname = firstNameTxt.getText().toString().trim();
        String lastname = lastNameTxt.getText().toString().trim();
        String password = passwordTxt.getText().toString().trim();
        String nationalId = nationalIDTxt.getText().toString().trim();
        String date_of_birth = dateOfBirth.getText().toString().trim();
        String imagePath = getStringPath();
        if (imagePath == null) {
            Toast.makeText(getApplicationContext(), "Please Take a picture of your Mutuelle Card", Toast.LENGTH_SHORT).show();

        } else {
            UserDataObj user = new UserDataObj(this);
            if (!firstname.isEmpty() || !lastname.isEmpty() || !password.isEmpty() || !date_of_birth.isEmpty() || !nationalId.isEmpty()) {
                user.createUser(firstname, lastname, Integer.parseInt(nationalId), date_of_birth, imagePath, password);
                if (user != null) {
                    startActivity(new Intent(SignUpActivity.this, OverViewActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Mutuelle Account Created", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    public String getStringPath() {
        String imagePath = null;
        imagePath = getIntent().getStringExtra("ImagePath");
        return imagePath;
    }

    private void takePicture() {
        startActivity(new Intent(SignUpActivity.this, CameraActivity.class));
    }
}
