package edu.cmu.mutuelle.mutuelle;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import edu.cmu.mutuelle.mutuelle.R;
import edu.cmu.mutuelle.mutuelle.fragment.ViewCustomerImageFragment;

public class CheckInActivity extends AppCompatActivity {

    ImageView QRCodeImage;
    ImageButton viewCustomerImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        QRCodeImage = (ImageView) findViewById(R.id.QRCodeImage);
        viewCustomerImageButton = (ImageButton) findViewById(R.id.customerImageViewButton);


        viewCustomerImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CheckInActivity.this, CustomerImageViewActivity.class));
            }
        });


        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        String textToEncode = "Text to convert";
        try{
            BitMatrix bitmatrix = multiFormatWriter.encode(textToEncode, BarcodeFormat.QR_CODE, 200, 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitmatrix);
            QRCodeImage.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
