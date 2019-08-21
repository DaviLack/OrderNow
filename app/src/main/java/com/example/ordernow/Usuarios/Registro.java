package com.example.ordernow.Usuarios;

import android.content.Intent;
import android.graphics.Typeface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ordernow.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;

public class Registro extends AppCompatActivity {


    ProgressBar progressbar;
    MaterialEditText Editddd, username, Editcell, email, password;
    Button signup;
    Typeface tf1, tf2;

    FirebaseAuth firebaseAuth;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registro);


        password = findViewById(R.id.etPassword);
        progressbar = findViewById(R.id.progressBar);
        Editddd = findViewById(R.id.Editddd);
        username = findViewById(R.id.Edituser);
        Editcell = findViewById(R.id.Editcell);
        email = findViewById(R.id.etEmail);
        signup = findViewById(R.id.btnsignup);

        tf1 = Typeface.createFromAsset(getAssets(), "Lena.ttf");
        tf2 = Typeface.createFromAsset(getAssets(), "Scaramella-Regular.otf");

        firebaseAuth = firebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_uername = username.getText().toString();
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();
                String txt_ddd = Editddd.getText().toString();
                String txt_cell = Editcell.getText().toString();

                if(TextUtils.isEmpty(txt_uername) || TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_ddd) || TextUtils.isEmpty(txt_cell)){
                    Toast.makeText(Registro.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();

                }else if (txt_password.length() < 6){
                    Toast.makeText(Registro.this, "Digite uma senha com mais de 6 digitos", Toast.LENGTH_SHORT).show();
                }else if (txt_ddd.length() != 2){
                    Toast.makeText(Registro.this, "DDD inválido", Toast.LENGTH_SHORT).show();
                }else if (txt_cell.length() < 8 || txt_cell.length() > 9){
                    Toast.makeText(Registro.this, "Número de celular inválido", Toast.LENGTH_SHORT).show();
                } else {
                    register(txt_uername, txt_email, txt_password, txt_ddd, txt_cell);
                }

            }
        });



    }


    private void register(final String username, String email, String passowrd, final String Editddd, final String Editcell){

        firebaseAuth.createUserWithEmailAndPassword(email,passowrd)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                            assert firebaseUser != null;

                            String userid = firebaseUser.getUid();
                            reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);

                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("id", userid);
                            hashMap.put("username", username);
                            hashMap.put("imageURL", "default");
                            hashMap.put("ddd", Editddd);
                            hashMap.put("cell", Editcell);

                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()){
                                        Intent intent = new Intent(Registro.this, Validar.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();

                                    }
                                }
                            });

                        } else{
                            Toast.makeText(Registro.this, "Falha no registro", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
    }


}
