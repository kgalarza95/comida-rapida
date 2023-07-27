package com.example.proyecto.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proyecto.R;

import java.util.Calendar;

public class Registrarse extends AppCompatActivity {

    Button btnRegistrar;
    private Spinner spRol;
    private ArrayAdapter<String> spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        EditText txtNombres = findViewById(R.id.txtNombres);
        EditText txtApellidos = findViewById(R.id.txtApellidos);
        EditText txtUsuario = findViewById(R.id.txtUsuario);
        EditText txtContrasenia = findViewById(R.id.txtContrasenia);
        DatePicker dpFechaNacimiento = findViewById(R.id.dpFechaNacimineto);
        spRol = findViewById(R.id.spRol);
        Button btnRegistrar = findViewById(R.id.btnRegistrar);

        String[] opciones = {"Cliente", "Kiosko"};
        spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spRol.setAdapter(spinnerAdapter);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombres = txtNombres.getText().toString();
                String apellidos = txtApellidos.getText().toString();
                String usuario = txtUsuario.getText().toString();
                String contrasenia = txtContrasenia.getText().toString();
                int dia = dpFechaNacimiento.getDayOfMonth();
                int mes = dpFechaNacimiento.getMonth() + 1; // Los meses en DatePicker comienzan desde 0
                int anio = dpFechaNacimiento.getYear();
                String rolSeleccionado = spRol.getSelectedItem().toString();

                Toast.makeText(Registrarse.this, "Registro exitoso: " + nombres + " " + apellidos + " es un " + rolSeleccionado, Toast.LENGTH_SHORT).show();

                txtNombres.setText("");
                txtApellidos.setText("");
                txtUsuario.setText("");
                txtContrasenia.setText("");
                Calendar calendar = Calendar.getInstance();
                dpFechaNacimiento.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

            }
        });

    }


    public void retroceder(View view) {
        finish();
    }
}