package com.example.ordernow.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ordernow.Carrinho.Carrinho;
import com.example.ordernow.QrCode.ScanCodeActivity;
import com.example.ordernow.R;

public class CartaoActivity extends AppCompatActivity {

    Button btn_pay;
    EditText card_number, validade_card, cvv_card, nome_card, cpf_user;
    ImageView perf_cartao;
    TextView titulo_activity, name_cartao, welcome_cartao;



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
        perf_cartao = findViewById(R.id.perf_cartao);
        name_cartao = findViewById(R.id.name_cartao);
        welcome_cartao = findViewById(R.id.welcome_cartao);
        titulo_activity = findViewById(R.id.titulo_activity);

        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_card = card_number.getText().toString();
                String txt_cvv = cvv_card.getText().toString();
                String txt_nomecard = nome_card.getText().toString();
                String txt_cpf = cpf_user.getText().toString();
                String txt_validade = validade_card.getText().toString();

                if(TextUtils.isEmpty(txt_card) || TextUtils.isEmpty(txt_cvv) || TextUtils.isEmpty(txt_nomecard) || TextUtils.isEmpty(txt_cpf) || TextUtils.isEmpty(txt_validade)){
                    Toast.makeText(CartaoActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }else if (txt_card.length() != 16){
                    Toast.makeText(CartaoActivity.this, "Número do cartao esta incorreto", Toast.LENGTH_SHORT).show();
                }else if (txt_cpf.length() != 11){
                    Toast.makeText(CartaoActivity.this, "CPF invalido", Toast.LENGTH_SHORT).show();
                }else if (txt_cvv.length() != 3){
                    Toast.makeText(CartaoActivity.this, "CVV incorreto", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class));
                }

            }
        });

    }
}
