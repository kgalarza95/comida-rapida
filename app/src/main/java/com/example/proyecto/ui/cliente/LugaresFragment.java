package com.example.proyecto.ui.cliente;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyecto.R;
import com.example.proyecto.adapter.LugaresAdapter;
import com.example.proyecto.model.Lugar;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class LugaresFragment extends Fragment {

    LugaresAdapter lugaresAdapter;

    RecyclerView mRecycler;
    private FirebaseFirestore mFirestore;
    private CollectionReference query;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_lugares, container, false);

        mFirestore = FirebaseFirestore.getInstance();

        mRecycler = vista.findViewById(R.id.recVLugares);

        setUpRecyclerView();

        return vista;
    }

    private void setUpRecyclerView() {
        query = mFirestore.collection("lugar");

        FirestoreRecyclerOptions<Lugar> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Lugar>().setQuery(query, Lugar.class).build();

        lugaresAdapter = new LugaresAdapter(firestoreRecyclerOptions, getContext());
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecycler.setAdapter(lugaresAdapter);

    }

    @Override
    public void onStart() {
        super.onStart();
        lugaresAdapter.startListening();
    }
}