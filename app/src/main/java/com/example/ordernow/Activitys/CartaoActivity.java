package com.example.ordernow.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ordernow.Carrinho.Carrinho;
import com.example.ordernow.R;

public class CartaoActivity extends AppCompatActivity {

    Button btn_pay;
    EditText card_number, validade_card, cvv_card, nome_card, cpf_user;
    ImageView cartao_image;
    TextView titulo_activity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartao);

        btn_pay = findViewById(R.id.btn_pay);
        card_number = findViewById(R.id.card_number);
        validade_card = findViewById(R.id.validade_card);
        cvv_card = findViewById(R.id.cvv_card);
        nome_card = findViewById(R.id.nome_card);
        cpf_user = findViewById(R.id.cpf_user);
        cartao_image = findViewById(R.id.cartao_image);
        titulo_activity = findViewById(R.id.titulo_activity);

        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Carrinho.class));
            }
        });

    }
}
