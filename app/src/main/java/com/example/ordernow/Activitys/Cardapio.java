package com.example.ordernow.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ordernow.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Cardapio extends AppCompatActivity {

    ImageButton btn_add;


    private static final String TAG = "Cardapio";

    public static String QrMenu;

    private DatabaseReference reference;
    private StorageReference mStorageRef;


    private Context mContext = Cardapio.this;
    private RecyclerView recyclerView;

    private ArrayList<Images> imageList;
    private RecyclerAdapter recyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        Log.d(TAG, "onCreate: started");


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        reference = FirebaseDatabase.getInstance().getReference();

        mStorageRef = FirebaseStorage.getInstance().getReference();

        imageList = new ArrayList<>();

        init();


     }

    private void init(){

        clearAll();

        Query query = reference.child("Images");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    if(snapshot.child("QrMenu").getValue().toString().equals(QrMenu)) {

                        Images images = new Images();

                        images.setUrl(snapshot.child("url").getValue().toString());
                        images.setDescription(snapshot.child("description").getValue().toString());
                        images.setNome(snapshot.child("nome").getValue().toString());
                        images.setPreco(snapshot.child("preco").getValue().toString());

                        imageList.add(images);
                    }

                }

                recyclerAdapter = new RecyclerAdapter(mContext, imageList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void clearAll(){

        if(imageList != null){

            imageList.clear();

            if(recyclerAdapter != null){

                recyclerAdapter.notifyDataSetChanged();

            }

        }

        imageList = new ArrayList<>();

    }

    public void onBackPressed() {
        // super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

}
