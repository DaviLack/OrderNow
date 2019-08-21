package com.example.ordernow.Usuarios;

import android.content.Intent;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ordernow.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.rengwuxian.materialedittext.MaterialEditText;

public class Login extends AppCompatActivity {

    Button userLogin;
    ProgressBar progressBar;
    MaterialEditText userEmail, userPass;
    ImageView plateOrder;
    TextView Regtxt;
    TextView EsquePass;
    Typeface tf1, tf2, tf3;


    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progressBar);
        userEmail = findViewById(R.id.etUserEmail);
        Regtxt = findViewById(R.id.Regtxt);
        userPass = findViewById(R.id.etUserPass);
        userLogin = findViewById(R.id.userLogin);
        EsquePass = findViewById(R.id.EsquePass);
        plateOrder = findViewById(R.id.plateOrder);



        tf1 = Typeface.createFromAsset(getAssets(), "Lena.ttf");
        tf2 = Typeface.createFromAsset(getAssets(), "pala.ttf");
        tf3 = Typeface.createFromAsset(getAssets(), "Scaramella-Regular.otf");


        EsquePass.setTypeface(tf1);
        Regtxt.setTypeface(tf1);
        userEmail.setTypeface(tf1);
        userPass.setTypeface(tf1);



        firebaseAuth = firebaseAuth.getInstance();


        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email = userEmail.getText().toString();
                String txt_password = userPass.getText().toString();

                if(TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)){
                    Toast.makeText(Login.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    firebaseAuth.signInWithEmailAndPassword(txt_email, txt_password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Intent intent = new Intent(Login.this, Validar.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(Login.this, "Falha na autenticação", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }

            }
        });

    }

    public void text_action(View view){
        startActivity(new Intent(getApplicationContext(), Registro.class));
    }
}
