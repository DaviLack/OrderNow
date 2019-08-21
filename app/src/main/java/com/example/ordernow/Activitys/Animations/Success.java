package com.example.ordernow.Activitys.Animations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.example.ordernow.Activitys.Inicio;
import com.example.ordernow.QrCode.ScanCodeActivity;
import com.example.ordernow.R;
import com.example.ordernow.Usuarios.Registro;

public class Success extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);


        startActivity(new Intent(getApplicationContext(), Inicio.class));
    }
}
