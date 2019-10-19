package com.example.ordernow.Activitys;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.annotation.NonNull;

import com.example.ordernow.Carrinho.Carrinho;
import com.example.ordernow.Database.Database;
import com.example.ordernow.Usuarios.Validar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.ordernow.QrCode.ScanCodeActivity;
import com.example.ordernow.R;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ViewFlipper v_flipper;
    TextView tv_carteira;
    TextView saldo;
    Typeface tf1, tf2, tf3;
    Button btn_carrinho;


    private int CAMERA_PERMISSION_CODE = 1;

    public static TextView ToolbarUser;


    ImageView profile_image;
    FloatingActionButton scan_btn;
    Button logout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int image[] = {R.drawable.foratras, R.drawable.habibs, R.drawable.hamburguer};


        v_flipper = findViewById(R.id.v_flipper);
        tv_carteira = findViewById(R.id.tv_carteira);
        saldo = findViewById(R.id.tv_saldo);
        btn_carrinho = findViewById(R.id.btn_carrinho);

        tf1 = Typeface.createFromAsset(getAssets(), "Lena.ttf");
        tf2 = Typeface.createFromAsset(getAssets(), "pala.ttf");
        tf3 = Typeface.createFromAsset(getAssets(), "Scaramella-Regular.otf");


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

        btn_carrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), Carrinho.class));

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
