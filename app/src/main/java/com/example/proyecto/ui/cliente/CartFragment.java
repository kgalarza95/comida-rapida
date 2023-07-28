package com.example.proyecto.ui.cliente;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyecto.R;
import com.example.proyecto.adapter.ProductoAdapter;
import com.example.proyecto.adapter.ProductoCarritoAdapter;
import com.example.proyecto.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

    View vista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vista = inflater.inflate(R.layout.fragment_cart, container, false);
        List<Producto> productList = getProductoList();

        RecyclerView recyclerView = vista.findViewById(R.id.rvCarrito);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ProductoCarritoAdapter productoCarritoAdapter = new ProductoCarritoAdapter(productList, getContext());
        recyclerView.setAdapter(productoCarritoAdapter);

        vista.findViewById(R.id.btnProcederPago).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoConfirmacionPago( v);
            }
        });
        //
        return vista;
    }

    private void mostrarDialogoConfirmacionPago(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setTitle("Confirmar Pago");
        builder.setMessage("¿Deseas proceder con el pago?");
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(v.getContext(), "Pago confirmado. ¡Gracias por tu compra!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }

    private List<Producto> getProductoList() {
        List<Producto> listaProductos = new ArrayList<>();

        Producto producto2 = new Producto(2, "Hamburguesa Clásica", "Jugosa hamburguesa con carne de res, queso, lechuga y tomate", 8.49, R.drawable.hamburguesa_clasica);
        listaProductos.add(producto2);

        Producto producto6 = new Producto(6, "Pasta Alfredo", "Pasta con salsa Alfredo, champiñones y pollo", 10.25, R.drawable.pasta_alfredo);
        listaProductos.add(producto6);

        Producto producto9 = new Producto(9, "Café Latte", "Café latte caliente con espuma de leche", 3.99, R.drawable.cafe_latte);
        listaProductos.add(producto9);

        Producto producto10 = new Producto(10, "Burrito Vegetariano", "Burrito relleno de verduras, arroz y frijoles", 7.25, R.drawable.burrito_vegetariano);
        listaProductos.add(producto10);
        return listaProductos;
    }
}