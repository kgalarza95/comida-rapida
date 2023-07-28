package com.example.proyecto.ui.cliente;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.proyecto.R;
import com.example.proyecto.secundarias.TimePickerFragment;

public class InicioFragment extends Fragment {
    RadioButton rad1, rad2;
    Button btnAgg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);


        rad1 = view.findViewById(R.id.option_1);
        rad2 = view.findViewById(R.id.option_2);
        btnAgg = view.findViewById(R.id.btnAggFecha);
        rad1.setChecked(true);

        Spinner spinner = (Spinner) view.findViewById(R.id.foodsSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.types_foods, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        rad1.setOnClickListener(view12 -> onRadioButtonClicked(view12));
        rad2.setOnClickListener(view1 -> onRadioButtonClicked(view1));

        btnAgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view);
            }
        });

        return view;
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getChildFragmentManager(), "timePicker");
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.option_1:
                if (checked) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(R.string.dialog_message)
                            .setTitle(R.string.dialog_title);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                break;
            case R.id.option_2:
                if (checked) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(R.string.dialog_message2)
                            .setTitle(R.string.dialog_title2);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                break;
        }
    }
}