package com.example.ordernow.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ordernow.R;
import com.example.ordernow.Usuarios.Validar;

public class Carteira extends AppCompatActivity {

    ImageView fundo_wallet, img_mais, perf_carteira;
    ImageButton back_wallet;
    TextView txt_cartao, txt_linha, txt_historico, txt_dispo, txt_dinheiro_carteira, txt_carteira, welcome_carteira, name_carteira ;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carteira);

        fundo_wallet = findViewById(R.id.fundo_wallet);
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
        txt_dinheiro_carteira.setText("R$ " + Validar.saldo);

    }
}
