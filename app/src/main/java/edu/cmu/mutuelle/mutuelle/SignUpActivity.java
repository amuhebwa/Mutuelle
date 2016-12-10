package edu.cmu.mutuelle.mutuelle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SignUpActivity extends AppCompatActivity {
    private EditText firstNameTxt, lastNameTxt, passwordTxt, nationalIDTxt;
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
