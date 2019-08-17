package com.example.ordernow.Usuarios;

import android.content.Intent;
import android.graphics.Typeface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ordernow.Activitys.Inicio;
import com.example.ordernow.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registro extends AppCompatActivity {


    ProgressBar progressbar;
    EditText email;
    EditText password;
    EditText Editcell;
    EditText Edituser;
    EditText Editddd;
    Button signup;
    Typeface tf1, tf2;

    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registro);


        progressbar = findViewById(R.id.progressBar);
        Editddd = findViewById(R.id.Editddd);
        Edituser = findViewById(R.id.Edituser);
        Editcell = findViewById(R.id.Editcell);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        signup = findViewById(R.id.btnsignup);

        tf1 = Typeface.createFromAsset(getAssets(), "Lena.ttf");
        tf2 = Typeface.createFromAsset(getAssets(), "Scaramella-Regular.otf");

        firebaseAuth = firebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressbar.setVisibility(View.VISIBLE);
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressbar.setVisibility(View.GONE);
                        if(task.isSuccessful()){
                            Toast.makeText(Registro.this, "Registro Realizado com Sucesso", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(Registro.this, Inicio.class));
                        }else{
                            Toast.makeText(Registro.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });




    }
}
