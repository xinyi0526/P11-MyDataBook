package com.myapplicationdev.android.p12_mydatabook;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class VaccinationFragment extends Fragment {

    FloatingActionButton fab;
    Button btnEdit;
    TextView tvVac;
    SharedPreferences prefs;
    String input;


    public VaccinationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vaccination, container, false);

        fab = view.findViewById(R.id.fab);
        btnEdit = view.findViewById(R.id.btnEdit);
        tvVac = view.findViewById(R.id.tvVac);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String msg = pref.getString("v_input","no input");
        tvVac.setText(msg);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"HI",Toast.LENGTH_SHORT).show();
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater1 = (LayoutInflater)getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater1.inflate(R.layout.input,null);

                final EditText etInput = viewDialog.findViewById(R.id.etBio);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(getActivity());
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Edit Vaccination");


                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String message = etInput.getText().toString();
                        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor prefEdit = prefs.edit();
                        prefEdit.putString("v_input",message);
                        prefEdit.commit();
                        input = message;
                        Log.d("TAG",message);
                        tvVac.setText(message);
                        Toast.makeText(getActivity(),"Insert Vaccination successfully",Toast.LENGTH_SHORT).show();

                    }
                });
                myBuilder.setNegativeButton("Cancel",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        return view;
    }
}
