package com.example.ordernow.Activitys;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.ordernow.Usuarios.Login;
import com.example.ordernow.Usuarios.User;
import com.example.ordernow.Usuarios.Validar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ordernow.QrCode.ScanCodeActivity;
import com.example.ordernow.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private int CAMERA_PERMISSION_CODE = 1;
    
    public static TextView ToolbarUser;
    ImageView profile_image;
    FloatingActionButton scan_btn;
    Button logout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.logout);
        profile_image = findViewById(R.id.profile_image);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Picasso.get().load(Validar.profile_image).into(profile_image);


        ToolbarUser = findViewById(R.id.ToolbarUser);

        ToolbarUser.setText(Validar.ToolbarUser);


            FloatingActionButton btn_scan = findViewById(R.id.btn_scan);
            btn_scan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                        startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class));
                    } else {
                        requestCameraPermission();
                    }
                }
            });



            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(MainActivity.this, Login.class));
                    finish();
                }
            });
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
