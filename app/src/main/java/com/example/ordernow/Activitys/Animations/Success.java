package com.example.ordernow.Activitys.Animations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.example.ordernow.Activitys.Inicio;
import com.example.ordernow.QrCode.ScanCodeActivity;
import com.example.ordernow.R;
import com.example.ordernow.Usuarios.Registro;
import com.example.ordernow.Usuarios.Validar;

import java.util.Timer;
import java.util.TimerTask;

public class Success extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        Timer Timer = new Timer();
        TimerTask Task = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(Success.this, Validar.class));
            }
        };

        Timer.schedule(Task, 2000);
    }
}
