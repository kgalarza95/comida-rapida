package com.example.proyecto.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto.ui.cliente.submenu.ProductosPorLugar;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.example.proyecto.model.Lugar;
import com.squareup.picasso.Picasso;

import com.example.proyecto.R;

import java.util.List;

public class LugaresAdapter extends FirestoreRecyclerAdapter<Lugar, LugaresAdapter.ViewHolder> {

    private FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();

    private List<Lugar> mData;
    private Context context;

    public LugaresAdapter(FirestoreRecyclerOptions<Lugar> options, Context context1) {
        super(options);
        this.context = context1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_lugar, parent, false);
        return new ViewHolder(v);
    }


    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Lugar lugar) {
        holder.txNameSite.setText(lugar.getNombre());
        holder.txDescription.setText(lugar.getDescripcion());
        String photoSite = lugar.getImagen_id();

        try {
            if (!photoSite.equals("")) {
                Picasso.with(context)
                        .load(photoSite)
                        .into(holder.imgSite);
            }
        } catch (Exception e) {
            Log.d("Exception image", "e: " + e);
        }

        holder.linearLCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //context.startActivity(new Intent(context, ProductosPorLugar.class));

                FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, new ProductosPorLugar())
                        .addToBackStack(null) //permite volver al fragmento anterior presionando  Atrás
                        .commit();
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgSite;
        TextView txNameSite, txDescription;
        LinearLayout linearLCard;
        CardView cardView;

        ViewHolder(View itemView) {
            super(itemView);
            linearLCard = itemView.findViewById(R.id.linearCard);
            imgSite = itemView.findViewById(R.id.imgLugar);
            txNameSite = itemView.findViewById(R.id.txtNombreLugar);
            txDescription = itemView.findViewById(R.id.txtDescripcionLugar);
        }
    }
}
