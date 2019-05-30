package com.example.ordernow.QrCode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ordernow.Activitys.MainActivity;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanCodeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

        ZXingScannerView ScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScannerView = new ZXingScannerView(this);
        setContentView(ScannerView);



    }

    @Override
    public void handleResult(Result result) {

            MainActivity.resultTextView.setText(result.getText());
            onBackPressed();

    }

    @Override
    protected void onPause() {
        super.onPause();

        ScannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ScannerView.setResultHandler(this);
        ScannerView.startCamera();

    }
}
