package com.example.ordernow.Usuarios;

import android.content.Intent;
import android.graphics.Typeface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.ordernow.Activitys.MainActivity;
import com.example.ordernow.Activitys.Welcome;
import com.example.ordernow.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Validar extends AppCompatActivity {

    public static String profile_image;
    public static String ToolbarUser;
    public static String saldo;


    FirebaseUser firebaseUser;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();



        if(firebaseUser != null){

            Intent intent = new Intent (Validar.this, Welcome.class);
            startActivity(intent);
            finish();
        }
        else{
            startActivity(new Intent(Validar.this, Login.class));
        }

        reference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                ToolbarUser = user.getUsername();
                saldo = user.getSaldo();

                if(user.getImageURL().equals("default")){
                    profile_image = user.getImageURL();
                }

                else{
                    profile_image = user.getImageURL();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



}
