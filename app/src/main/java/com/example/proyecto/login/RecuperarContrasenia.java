package com.example.proyecto.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto.R;

public class RecuperarContrasenia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contrasenia);

        Button btnRecover = findViewById(R.id.btnRecuperar);
        btnRecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ((EditText) findViewById(R.id.txtCorreo)).getText().toString();
                Toast.makeText(RecuperarContrasenia.this, "Solicitud de recuperación enviada para: " + email, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void retroceder(View view) {
        finish();
    }
}