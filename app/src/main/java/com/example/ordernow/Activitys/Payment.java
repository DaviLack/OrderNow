package com.example.ordernow.Activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ordernow.Carrinho.Carrinho;
import com.example.ordernow.Carrinho.Request;
import com.example.ordernow.Database.Database;
import com.example.ordernow.R;
import com.example.ordernow.Usuarios.Validar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Payment extends AppCompatActivity {

    ImageView payment_image, payment_image2, imagem_seta, imagem_seta2, payment_metod, img_fundo_mostrar1;
    TextView textao_separar, text_payment, textao_separar2, text_payment2, payment_text;
    Button btn_clicar, btn_clicar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        btn_clicar = findViewById(R.id.btn_clicar);
        text_payment2 = findViewById(R.id.text_payment2);
        payment_metod = findViewById(R.id.payment_metod);
        img_fundo_mostrar1 = findViewById(R.id.img_fundo_mostrar1);
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
                showAlertDialog();
            }
        });

    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(com.example.ordernow.Activitys.Payment.this);
        alertDialog.setTitle("Quase lá!");
        alertDialog.setMessage("Digite o número da sua mesa");

        final EditText edtMesa = new EditText(com.example.ordernow.Activitys.Payment.this);
        LinearLayout.LayoutParams p1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        edtMesa.setLayoutParams(p1);
        alertDialog.setView(edtMesa);
        alertDialog.setIcon(R.drawable.cart);

        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Request request = new Request(
                        Validar.ToolbarUser,
                        Carrinho.txtTotalPrice.getText().toString(),
                        "codigo",
                        Validar.telefone_id,
                        edtMesa.getText().toString(),
                        Carrinho.cart
                );

                Validar.saldo = String.valueOf(Integer.parseInt(Validar.saldo) - Carrinho.total);

                FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("saldo").setValue(Validar.saldo);

                Carrinho.requests.child(String.valueOf(System.currentTimeMillis()))
                        .setValue(request);
                new Database(getBaseContext()).cleanCart();
                Toast.makeText(Payment.this, "Aguarde seu pedido ficar pronto", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), FinalActivity.class));
                finish();
            }
        });

        alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        alertDialog.show();
    }

}
