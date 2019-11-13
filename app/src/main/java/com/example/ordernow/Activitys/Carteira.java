package com.example.ordernow.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ordernow.R;
import com.example.ordernow.Usuarios.Validar;

public class Carteira extends AppCompatActivity {

    ImageView fundo_wallet, back_wallet, img_mais, perf_carteira;
    TextView txt_cartao, txt_linha, txt_historico, txt_dispo, txt_dinheiro_carteira, txt_carteira, welcome_carteira, name_carteira ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carteira);

        fundo_wallet = findViewById(R.id.fundo_wallet);
        back_wallet = findViewById(R.id.back_wallet);
        img_mais = findViewById(R.id.img_mais);
        perf_carteira = findViewById(R.id.perf_carteira);
        welcome_carteira = findViewById(R.id.welcome_carteira);
        name_carteira = findViewById(R.id.name_carteira);
        txt_cartao = findViewById(R.id.txt_cartao);
        txt_linha = findViewById(R.id.txt_linha);
        txt_historico = findViewById(R.id.txt_historico);
        txt_dispo = findViewById(R.id.txt_dispo);
        txt_dinheiro_carteira = findViewById(R.id.txt_dinheiro_carteira);
        txt_carteira = findViewById(R.id.txt_carteira);

        name_carteira.setText(Validar.ToolbarUser);

    }
}
