package com.example.ordernow.Activitys;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ordernow.R;
import com.example.ordernow.Usuarios.Validar;

import java.util.Timer;
import java.util.TimerTask;

public class Welcome extends AppCompatActivity {


    TextView username;
    TextView txt_ola, txt_bem, txt_name;
    Typeface tf1, tf2, tf3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        Timer Timer = new Timer();
        TimerTask Task = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(Welcome.this, MainActivity.class));
            }
        };

        Timer.schedule(Task, 3000);

        txt_bem = findViewById(R.id.txt_bem);
        txt_ola = findViewById(R.id.txt_ola);
        txt_name = findViewById(R.id.txt_name);

        username = findViewById(R.id.txt_name);
        username.setText(Validar.ToolbarUser);


        tf1 = Typeface.createFromAsset(getAssets(), "Lena.ttf");
        tf2 = Typeface.createFromAsset(getAssets(), "pala.ttf");
        tf3 = Typeface.createFromAsset(getAssets(), "Scaramella-Regular.otf");


        txt_ola.setTypeface(tf2);
        username.setTypeface(tf2);





    }
}
