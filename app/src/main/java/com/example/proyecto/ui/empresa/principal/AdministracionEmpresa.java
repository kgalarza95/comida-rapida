package com.example.proyecto.ui.empresa.principal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyecto.R;


public class AdministracionEmpresa extends Fragment {

    public AdministracionEmpresa() {
    }

    public static AdministracionEmpresa newInstance(String param1, String param2) {
        AdministracionEmpresa fragment = new AdministracionEmpresa();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_administracion_empresa, container, false);
    }
}