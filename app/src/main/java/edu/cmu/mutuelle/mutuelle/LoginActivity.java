package edu.cmu.mutuelle.mutuelle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameTxt, passwordTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        usernameTxt = (EditText) findViewById(R.id.username);
        passwordTxt = (EditText) findViewById(R.id.password);

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
    private void validateUserDetails(){
        String username = usernameTxt.getText().toString();
        String password = passwordTxt.getText().toString();

        // check if user exists in the database. if true, login, else show a toast message
        startActivity(new Intent(LoginActivity.this, OverViewActivity.class));
    }
}
