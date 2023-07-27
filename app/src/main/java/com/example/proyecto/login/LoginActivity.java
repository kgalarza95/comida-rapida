package com.example.proyecto.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.proyecto.R;

public class LoginActivity extends AppCompatActivity {

    Button btnRegistrarse;
    Button btnLogin;
    TextView recuperarPass;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        int nightModeFlags = this.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        if (nightModeFlags == Configuration.UI_MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        }
        btnRegistrarse= findViewById(R.id.btnRegistro);
        btnLogin= findViewById(R.id.btnLogin);
        recuperarPass= findViewById(R.id.lblRecPass);


        progressDialog = new ProgressDialog(this);


        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Cargando...");
                progressDialog.setCancelable(false);
                progressDialog.show();
                startActivity(new Intent(v.getContext(), Registrarse.class));
                progressDialog.dismiss();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Cargando...");
                progressDialog.setCancelable(false);
                progressDialog.show();
                retrocederLogin(v);
                progressDialog.dismiss();
            }
        });

        recuperarPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Cargando...");
                progressDialog.setCancelable(false);
                progressDialog.show();
                startActivity(new Intent(v.getContext(), RecuperarContrasenia.class));
                progressDialog.dismiss();
            }
        });

    }

    public void retrocederLogin(View view) {
        finish();
    }
}