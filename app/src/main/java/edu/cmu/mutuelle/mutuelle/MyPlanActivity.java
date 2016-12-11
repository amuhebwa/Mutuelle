package edu.cmu.mutuelle.mutuelle;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MyPlanActivity extends AppCompatActivity {

    TextView currentPlanViewHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plan);

        currentPlanViewHolder = (TextView) findViewById(R.id.currentPlanViewHolder);

        //Display the current plan
        currentPlanViewHolder.setText(getCurrentPlan());
    }
    private StringBuilder getCurrentPlan() {
        String plan = "Individual Plan";
        String validUntil = "December 2017";

        StringBuilder string = new StringBuilder();
        string.append("Your current plan is: "+plan);
        string.append("\nValid until: "+validUntil);
        return string;
    }
}
