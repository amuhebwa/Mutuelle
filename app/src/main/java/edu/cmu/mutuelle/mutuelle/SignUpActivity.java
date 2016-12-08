package edu.cmu.mutuelle.mutuelle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SignUpActivity extends AppCompatActivity {
    private EditText firstName, lastName, password, nationalID, dateOfBirth;
    private ImageButton takePicture;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        firstName = (EditText) findViewById(R.id.firstname);
        lastName = (EditText) findViewById(R.id.lastname);
        dateOfBirth = (EditText) findViewById(R.id.dateOfBirth);
        password = (EditText) findViewById(R.id.password);
        nationalID = (EditText) findViewById(R.id.nationalId);
        takePicture = (ImageButton) findViewById(R.id.takePicture);
        signupButton = (Button) findViewById(R.id.signupButton);
    }
}
