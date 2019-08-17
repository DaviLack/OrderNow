package com.example.ordernow.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ordernow.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Cardapio extends AppCompatActivity {

    private static final String TAG = "Cardapio";


    private DatabaseReference reference;
    private StorageReference mStorageRef;


    private Context mContext = Cardapio.this;
    private RecyclerView recyclerView;

    private ArrayList<Images> imageList;


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


    }

    private void clearAll(){

        if(imageList != null){

            imageList.clear();
        }

        imageList = new ArrayList<>();

    }

}
