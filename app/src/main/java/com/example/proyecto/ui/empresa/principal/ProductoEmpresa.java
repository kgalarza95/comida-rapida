package com.example.proyecto.ui.empresa.principal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyecto.R;


public class ProductoEmpresa extends Fragment {


    public ProductoEmpresa() {
    }

    public static ProductoEmpresa newInstance(String param1, String param2) {
        ProductoEmpresa fragment = new ProductoEmpresa();
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
        return inflater.inflate(R.layout.fragment_producto_empresa, container, false);
    }
}