package com.example.ordernow.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ordernow.R;
import com.example.ordernow.Usuarios.Validar;

public class MostrarProfile extends AppCompatActivity {

ImageView img_fundo_mostrar, perf_mostrar;
ImageButton back_mostrar;
TextView dados_pessoais, nome_mostrar,Email_mostrar,cpf_mostrar,telefone_mostrar, edit_informacoes, separar_mostrar, separar_mostrar2, separar_mostrar3, separar_mostrar4,nome_place, cpf_place, telefone_place, email_place,name_mostrar, welcome_mostrar;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_profile);

        img_fundo_mostrar = findViewById(R.id.img_fundo_mostrar);
        back_mostrar = findViewById(R.id.back_mostrar);
        nome_mostrar = findViewById(R.id.nome_mostrar);
        name_mostrar = findViewById(R.id.name_mostrar);
        welcome_mostrar = findViewById(R.id.welcome_mostrar);
        perf_mostrar = findViewById(R.id.perf_mostrar);
        dados_pessoais = findViewById(R.id.dados_pessoais);
        Email_mostrar = findViewById(R.id.Email_mostrar);
        cpf_mostrar = findViewById(R.id.cpf_mostrar);
        telefone_mostrar = findViewById(R.id.telefone_mostrar);
        edit_informacoes = findViewById(R.id.edit_informacoes);
        separar_mostrar = findViewById(R.id.separar_mostrar);
        separar_mostrar2 = findViewById(R.id.separar_mostrar2);
        separar_mostrar3 = findViewById(R.id.separar_mostrar3);
        separar_mostrar4 = findViewById(R.id.separar_mostrar4);
        nome_place = findViewById(R.id.nome_place);
        cpf_place = findViewById(R.id.cpf_place);
        telefone_place = findViewById(R.id.telefone_place);
        email_place = findViewById(R.id.email_place);


        nome_place.setText(Validar.ToolbarUser);
        telefone_place.setText(Validar.telefone_id);
        email_place.setText(Validar.email_id);

        back_mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            }
        });



    }
}
