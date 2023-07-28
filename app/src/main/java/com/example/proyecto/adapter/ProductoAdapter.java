package com.example.proyecto.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto.R;
import com.example.proyecto.model.Producto;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductViewHolder> {
    private List<Producto> productList;
    private Context context;

    public ProductoAdapter(List<Producto> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_item_producto_por_lugar, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        int pos = position;
        Producto product = productList.get(pos);

        // Configurar los datos del producto en los elementos de vista del CardView
        holder.imgProducto.setImageResource(product.getRecursoImagen());
        holder.txtNombreProducto.setText("Producto: "+product.getNombre());
        holder.txtDescripcionPro.setText("Descripción: "+product.getDescripcion());
        holder.txtPrecioProducto.setText("Precio: $" + product.getPrecio());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mostrar el diálogo para agregar al carrito
                mostrarDialogoAgregarCarrito(pos);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }




    private void mostrarDialogoAgregarCarrito(final int position) {
        Producto selectedProduct = productList.get(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Agregar al carrito");
        builder.setMessage("¿Deseas agregar " + selectedProduct.getNombre() + " al carrito?");
        builder.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Producto agregado al carrito", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }



    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProducto;
        TextView txtNombreProducto;
        TextView txtDescripcionPro;
        TextView txtPrecioProducto;

        public ProductViewHolder(View itemView) {
            super(itemView);
            imgProducto = itemView.findViewById(R.id.imgProducto);
            txtNombreProducto = itemView.findViewById(R.id.txtNombreProducto);
            txtDescripcionPro = itemView.findViewById(R.id.txtDescripcionPro);
            txtPrecioProducto = itemView.findViewById(R.id.txtPrecioProducto);
        }
    }
}
