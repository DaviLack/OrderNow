package com.example.ordernow.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ordernow.R;

public class Payment extends AppCompatActivity {

    ImageView payment_image, payment_image2, imagem_seta, imagem_seta2;
    TextView textao_separar, text_payment, textao_separar2, text_payment2, payment_text;
    Button btn_clicar, btn_clicar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        btn_clicar = findViewById(R.id.btn_clicar);
        btn_clicar2 = findViewById(R.id.btn_clicar2);
        payment_image = findViewById(R.id.payment_image);
        payment_image2 = findViewById(R.id.payment_image2);
        imagem_seta = findViewById(R.id.imagem_seta);
        imagem_seta2 = findViewById(R.id.imagem_seta2);
        textao_separar = findViewById(R.id.textao_separar);
        text_payment = findViewById(R.id.text_payment);
        textao_separar2 = findViewById(R.id.textao_separar2);
        payment_text = findViewById(R.id.payment_text);

        btn_clicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CartaoActivity.class));
            }
        });

        btn_clicar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
