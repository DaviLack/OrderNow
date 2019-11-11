package com.example.ordernow.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ordernow.Carrinho.Carrinho;
import com.example.ordernow.R;
import com.example.ordernow.Usuarios.Validar;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {

    ImageView image_fundo, image_perfil, wallet_image, image_seta, information_image, image_seta2, img_fav, image_seta3;
    TextView text_nome, text_separar, text_carteira, text_carteirinha, text_information, text_informacaozinha, text_separar2,text_fav, text_favinha, text_separar3;
    Button botao_clicar, botao_clicar2, botao_clicar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        image_fundo = findViewById(R.id.image_fundo);
        image_perfil = findViewById(R.id.image_perfil);
        wallet_image = findViewById(R.id.wallet_image);
        image_seta = findViewById(R.id.image_seta);
        information_image = findViewById(R.id.information_image);
        image_seta2 = findViewById(R.id.image_seta2);
        img_fav = findViewById(R.id.img_fav);
        image_seta3 = findViewById(R.id.image_seta3);
        text_nome = findViewById(R.id.text_nome);
        text_separar = findViewById(R.id.text_separar);
        text_carteira = findViewById(R.id.text_carteira);
        text_carteirinha = findViewById(R.id.text_carteirinha);
        text_information = findViewById(R.id.text_information);
        text_informacaozinha = findViewById(R.id.text_informacaozinha);
        text_separar2 = findViewById(R.id.text_separar2);
        text_fav = findViewById(R.id.text_fav);
        text_favinha = findViewById(R.id.text_favinha);
        text_separar3 = findViewById(R.id.text_separar3);
        botao_clicar = findViewById(R.id.botao_clicar);
        botao_clicar2 = findViewById(R.id.botao_clicar2);
        botao_clicar3 = findViewById(R.id.botao_clicar3);

        text_nome.setText(Validar.ToolbarUser);


        botao_clicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Carteira.class));
            }
        });

        botao_clicar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MostrarProfile.class));
            }
        });


    }
}
