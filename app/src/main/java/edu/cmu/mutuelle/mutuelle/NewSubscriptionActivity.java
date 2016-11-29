package edu.cmu.mutuelle.mutuelle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class NewSubscriptionActivity extends AppCompatActivity {
    private Spinner insurancePlanSpinner;
    private Button subscribeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_subscription);

        //initiate the views
        insurancePlanSpinner = (Spinner) findViewById(R.id.subscriptionPlanList);
        subscribeButton = (Button) findViewById(R.id.subscribeButton);
        subscribeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent payments = new Intent(NewSubscriptionActivity.this, PaymentActivity.class);
                //Transfer the selected insurance plan
                //String selectedPlan = insurancePlanSpinner.getSelectedItem().toString();
                startActivity(payments);
            }
        });
    }
}
