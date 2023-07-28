package com.example.proyecto.ui.empresa.principal;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.proyecto.R;
import com.example.proyecto.login.LoginActivity;
import com.example.proyecto.ui.cliente.PrincipalActivity;


public class InicioEmpresa extends Fragment implements View.OnClickListener {


    public InicioEmpresa() {
    }

    public static InicioEmpresa newInstance(String param1, String param2) {
        InicioEmpresa fragment = new InicioEmpresa();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    View vista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_inicio_empresa, container, false);

        Button btnAdministrarProductos = vista.findViewById(R.id.btnAdministrarProductos);
        Button btnGestionarUsuarios = vista.findViewById(R.id.btnGestionarUsuarios);
        Button btnCerrarSesion = vista.findViewById(R.id.btnCerrarSesion);

        btnAdministrarProductos.setOnClickListener(this);
        btnGestionarUsuarios.setOnClickListener(this);
        btnCerrarSesion.setOnClickListener(this);


        return vista;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAdministrarProductos:
                mostrarModalAdministrarEconomia();
                break;
            case R.id.btnGestionarUsuarios:
                mostrarModalListaProductos();
                break;
            case R.id.btnCerrarSesion:
                irALogin();
                break;
        }
    }

    private void mostrarModalAdministrarEconomia() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Administración Económica");
        builder.setMessage("Resumen de Ingresos:\n" +
                "\n" +
                "Ingreso Mensual: $4500\n" +
                "Ingreso Semanal: $1200\n" +
                "Ingreso Diario Promedio: $100\n" +
                "Resumen de Gastos:\n" +
                "\n" +
                "Gasto Mensual en Alquiler: $1000\n" +
                "Gasto Mensual en Personal: $1200\n" +
                "Gasto Mensual en Suministros: $500\n" +
                "Resumen de Compras:\n" +
                "\n" +
                "Última Compra: 25/07/2023\n" +
                "Total de Compras en el Mes: $2300\n" +
                "Total de Compras en el Año: $16500\n" +
                "Resumen de Ventas:\n" +
                "\n" +
                "Última Venta: 24/07/2023\n" +
                "Total de Ventas en el Mes: $3800\n" +
                "Total de Ventas en el Año: $29500\n" +
                "Resumen de Beneficios:\n" +
                "\n" +
                "Beneficio Mensual: $2500\n" +
                "Beneficio Anual: $13000");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }

    private void mostrarModalListaProductos() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Lista de Productos en Bodega");
        builder.setMessage("Hamburguesa Clásica\n" +
                "\n" +
                "Descripción: Deliciosa hamburguesa con carne, queso, lechuga, tomate y salsa especial\n" +
                "Precio: $6.99\n" +
                "Cantidad en stock: 50\n" +
                "Pizza Margarita\n" +
                "\n" +
                "Descripción: Pizza con salsa de tomate, mozzarella y albahaca fresca\n" +
                "Precio: $9.99\n" +
                "Cantidad en stock: 30\n" +
                "Ensalada César\n" +
                "\n" +
                "Descripción: Ensalada fresca con lechuga, pollo a la parrilla, crutones y aderezo césar\n" +
                "Precio: $5.49\n" +
                "Cantidad en stock: 20\n" +
                "Pasta Alfredo\n" +
                "\n" +
                "Descripción: Pasta con salsa Alfredo y camarones a la parrilla\n" +
                "Precio: $8.75\n" +
                "Cantidad en stock: 15\n" +
                "Sushi Variado\n" +
                "\n" +
                "Descripción: Variedad de sushi incluyendo rollos de salmón, atún y aguacate\n" +
                "Precio: $12.99\n" +
                "Cantidad en stock: 40\n" +
                "Pollo a la Parrilla\n" +
                "\n" +
                "Descripción: Pechuga de pollo a la parrilla con papas y ensalada\n" +
                "Precio: $7.25\n" +
                "Cantidad en stock: 25\n" +
                "Tacos de Carne Asada\n" +
                "\n" +
                "Descripción: Tacos de carne asada con cebolla, cilantro y salsa picante\n" +
                "Precio: $3.50\n" +
                "Cantidad en stock: 60\n" +
                "Pastel de Chocolate\n" +
                "\n" +
                "Descripción: Delicioso pastel de chocolate con ganache de chocolate\n" +
                "Precio: $4.99\n" +
                "Cantidad en stock: 10\n" +
                "Café Latte\n" +
                "\n" +
                "Descripción: Café latte con espuma de leche y un toque de canela\n" +
                "Precio: $3.25\n" +
                "Cantidad en stock: 35\n" +
                "Jugo Natural de Naranja\n" +
                "\n" +
                "Descripción: Jugo de naranja recién exprimido\n" +
                "Precio: $2.99\n" +
                "Cantidad en stock: 45");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }

    private void irALogin() {
        Intent intent = new Intent(requireContext(), PrincipalActivity.class);
        startActivity(intent);
        requireActivity().finish();
    }
}