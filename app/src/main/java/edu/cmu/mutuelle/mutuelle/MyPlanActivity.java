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
    }
}
