package com.example.ordernow.Activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ordernow.Carrinho.Requests;
import com.example.ordernow.Carrinho.Carrinho;
import com.example.ordernow.R;
import com.example.ordernow.Usuarios.Validar;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Button btn_carteira;

        btn_carteira = findViewById(R.id.btn_carteira);

        btn_carteira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });



    }

    private void showAlertDialog() {
        AlertDialog.Builder

    }
}
