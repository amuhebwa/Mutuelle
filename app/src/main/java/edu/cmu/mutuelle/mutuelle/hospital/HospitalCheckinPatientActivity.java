package edu.cmu.mutuelle.mutuelle.hospital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.Result;

import edu.cmu.mutuelle.mutuelle.R;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class HospitalCheckinPatientActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private Button scanButton;
    private TextView scanResultView;
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_checkin_patient);

        scanButton = (Button) findViewById(R.id.scannerButton);
        scanResultView = (TextView) findViewById(R.id.scanResultView);

        mScannerView = new ZXingScannerView(this);
        mScannerView.setResultHandler(this);

        //Start scanning
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(mScannerView);
                mScannerView.startCamera();
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        scanResultView.setText(result.getText());
    }
}

