package com.example.proyecto.ui.empresa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.proyecto.R;
import com.example.proyecto.ui.empresa.principal.AdministracionEmpresa;
import com.example.proyecto.ui.empresa.principal.InicioEmpresa;
import com.example.proyecto.ui.empresa.principal.PerfilEmpresa;
import com.example.proyecto.ui.empresa.principal.ProductoEmpresa;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuPrincipalEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal_empresa);

        mostrarFragmentoInicial();

        // Configurar el BottomNavigationView para cambiar de fragments cuando se selecciona un ítem
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.btnInicio:
                        mostrarFragmento(new InicioEmpresa());
                        return true;
                    case R.id.btnProducto:
                        mostrarFragmento(new ProductoEmpresa());
                        return true;
                    case R.id.btnAdmin:
                        mostrarFragmento(new AdministracionEmpresa());
                        return true;
                    case R.id.btnPerfil:
                        mostrarFragmento(new PerfilEmpresa());
                        return true;
                }
                return false;
            }
        });
    }


    private void mostrarFragmentoInicial() {
        InicioEmpresa fragmentInicial = new InicioEmpresa();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragmentInicial);
        fragmentTransaction.commit();
    }

    private void mostrarFragmento(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}