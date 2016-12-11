package edu.cmu.mutuelle.mutuelle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class CustomerImageViewActivity extends AppCompatActivity {

    //view to hold the image of the customer
    private ImageView customerImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_image_view);

        customerImageView = (ImageView) findViewById(R.id.customerImageView);
    }
}
