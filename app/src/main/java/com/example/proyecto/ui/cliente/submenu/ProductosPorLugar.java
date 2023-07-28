package com.example.proyecto.ui.cliente.submenu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyecto.R;
import com.example.proyecto.adapter.ProductoAdapter;
import com.example.proyecto.model.Producto;

import java.util.ArrayList;
import java.util.List;


public class ProductosPorLugar extends Fragment {


    public ProductosPorLugar() {
    }


    public static ProductosPorLugar newInstance(String param1, String param2) {
        ProductosPorLugar fragment = new ProductosPorLugar();
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

        vista =  inflater.inflate(R.layout.fragment_productos_por_lugar, container, false);
        List<Producto> productList = getProductoList();

        RecyclerView recyclerView = vista.findViewById(R.id.rv_productos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ProductoAdapter productAdapter = new ProductoAdapter(productList, getContext());
        recyclerView.setAdapter(productAdapter);

        return vista;
    }

    private List<Producto> getProductoList() {
        List<Producto> listaProductos = new ArrayList<>();

        Producto producto1 = new Producto(1, "Pizza Margarita", "Deliciosa pizza con salsa de tomate, mozzarella y albahaca", 9.99, R.drawable.pizza_margarita);
        listaProductos.add(producto1);

        Producto producto2 = new Producto(2, "Hamburguesa Clásica", "Jugosa hamburguesa con carne de res, queso, lechuga y tomate", 8.49, R.drawable.hamburguesa_clasica);
        listaProductos.add(producto2);

        Producto producto3 = new Producto(3, "Ensalada César", "Ensalada fresca con pollo a la parrilla, crutones y aderezo César", 7.99, R.drawable.ensalada_cesar);
        listaProductos.add(producto3);

        Producto producto4 = new Producto(4, "Sushi Variado", "Delicioso sushi variado con salmón, atún y aguacate", 12.50, R.drawable.sushi_variado);
        listaProductos.add(producto4);

        Producto producto5 = new Producto(5, "Pastel de Chocolate", "Suave pastel de chocolate con cobertura de crema", 5.99, R.drawable.pastel_chocolate);
        listaProductos.add(producto5);

        Producto producto6 = new Producto(6, "Pasta Alfredo", "Pasta con salsa Alfredo, champiñones y pollo", 10.25, R.drawable.pasta_alfredo);
        listaProductos.add(producto6);

        Producto producto7 = new Producto(7, "Tacos de Carnitas", "Tacos de carnitas con cebolla, cilantro y salsa verde", 6.75, R.drawable.tacos_carnitas);
        listaProductos.add(producto7);

        Producto producto8 = new Producto(8, "Helado de Vainilla", "Delicioso helado de vainilla con toppings de tu elección", 4.25, R.drawable.helado_vainilla);
        listaProductos.add(producto8);

        Producto producto9 = new Producto(9, "Café Latte", "Café latte caliente con espuma de leche", 3.99, R.drawable.cafe_latte);
        listaProductos.add(producto9);

        Producto producto10 = new Producto(10, "Burrito Vegetariano", "Burrito relleno de verduras, arroz y frijoles", 7.25, R.drawable.burrito_vegetariano);
        listaProductos.add(producto10);
        return listaProductos;
    }
}