package com.example.ordernow.Activitys;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.annotation.NonNull;

import com.example.ordernow.Adapters.RecyclerAdapter2;
import com.example.ordernow.Adapters.Restaurants;
import com.example.ordernow.Carrinho.Carrinho;
import com.example.ordernow.Database.Database;
import com.example.ordernow.Usuarios.Validar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.ordernow.QrCode.ScanCodeActivity;
import com.example.ordernow.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewFlipper v_flipper;
    TextView tv_carteira, recomendacao_main;
    TextView saldo;
    Typeface tf1, tf2, tf3;
    Button btn_carrinho;
    ImageButton wallet_principal;



    private DatabaseReference reference;
    private StorageReference mStorageRef;

    public static Restaurants currentrest;
    private Context mContext = MainActivity.this;

    private RecyclerView recyclerView2;

    private ArrayList<Restaurants> restList;
    private RecyclerAdapter2 recyclerAdapter2;

    private int CAMERA_PERMISSION_CODE = 1;

    public static TextView ToolbarUser;


    ImageButton profile_image;
    FloatingActionButton scan_btn;
    Button logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        int image[] = {R.drawable.slider_bk, R.drawable.slider_kfc, R.drawable.slider_mc, R.drawable.slider_ob, R.drawable.slider_ph};




        v_flipper = findViewById(R.id.v_flipper);
        wallet_principal = findViewById(R.id.wallet_principal);
        tv_carteira = findViewById(R.id.tv_carteira);
        recomendacao_main = findViewById(R.id.recomendacao_main);
        saldo = findViewById(R.id.tv_saldo);
        btn_carrinho = findViewById(R.id.btn_carrinho);



        tf1 = Typeface.createFromAsset(getAssets(), "Lena.ttf");
        tf2 = Typeface.createFromAsset(getAssets(), "pala.ttf");
        tf3 = Typeface.createFromAsset(getAssets(), "Scaramella-Regular.otf");

        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(layoutManager);
        recyclerView2.setHasFixedSize(true);

        reference = FirebaseDatabase.getInstance().getReference();

        mStorageRef = FirebaseStorage.getInstance().getReference();

        restList = new ArrayList<>();

        init();


        for (int images: image){
            flipperImages(images);
        }


        logout = findViewById(R.id.logout);
        profile_image = findViewById(R.id.profile_image);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Picasso.get().load(Validar.profile_image).into(profile_image);


        ToolbarUser = findViewById(R.id.ToolbarUser);
        ToolbarUser.setText(Validar.ToolbarUser);

        saldo = findViewById(R.id.tv_saldo);
        saldo.setText("R$ " + Validar.saldo);


            FloatingActionButton btn_scan = findViewById(R.id.btn_scan);
            btn_scan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                        new Database(getBaseContext()).cleanCart();
                        startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class));
                    } else {
                        requestCameraPermission();
                    }
                }
            });


        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            }
        });


/*
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(MainActivity.this, Login.class));
                    finish();
                }
            }); */





    }



    private void init(){

        clearAll();

        Query query = reference.child("Restaurants");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        currentrest = dataSnapshot.getValue(Restaurants.class);

                        Restaurants restaurants = new Restaurants();

                        restaurants.setImgrest(snapshot.child("imgrest").getValue().toString());
                        restaurants.setEspecialidade(snapshot.child("especialidade").getValue().toString());
                        restaurants.setNomer(snapshot.child("nomer").getValue().toString());
                        restaurants.setNota(snapshot.child("nota").getValue().toString());

                        restList.add(restaurants);
                    }

                recyclerAdapter2 = new RecyclerAdapter2(mContext, restList);
                recyclerView2.setAdapter(recyclerAdapter2);
                recyclerAdapter2.notifyDataSetChanged();
                }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void clearAll(){

        if(restList != null){

            restList.clear();

            if(recyclerAdapter2 != null){

                recyclerAdapter2.notifyDataSetChanged();

            }

        }

        restList = new ArrayList<>();

    }

    public void flipperImages(int image){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(image);

            v_flipper.addView(imageView);
            v_flipper.setFlipInterval(3000);
            v_flipper.setAutoStart(true);

            v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
            v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);

        }

     private void requestCameraPermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)){
            new AlertDialog.Builder(this)
            .setTitle("Permissão necessária")
            .setMessage("Está permissão precisa ser concedida para que seja possivel ler o QR-Code")
            .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA},CAMERA_PERMISSION_CODE);
                }
            })
            .setNegativeButton("Recusar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            })
                    .create().show();

        } else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},CAMERA_PERMISSION_CODE);
        }
     }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == CAMERA_PERMISSION_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permissão concedida", Toast.LENGTH_SHORT);
            }
            else{
                Toast.makeText(this,"Permissão recusada", Toast.LENGTH_SHORT);
            }
        }
    }




    public void onBackPressed() {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
