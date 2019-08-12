package com.example.ordernow.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ordernow.R;

public class Cardapio extends AppCompatActivity {

    public static int codigo;
    TextView textoteste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        textoteste = findViewById(R.id.textoteste);

        textoteste.setText("O código do cardapio é: " + codigo);


    }
}
