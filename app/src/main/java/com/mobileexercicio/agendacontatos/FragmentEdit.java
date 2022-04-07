package com.mobileexercicio.agendacontatos;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentEdit extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText nomePessoa = view.findViewById(R.id.txtPersonNameUpdate);
        EditText celularPessoa = view.findViewById(R.id.txtPhoneUpdate);
        EditText endereçoPessoa = view.findViewById(R.id.txtAddressUpdate);
        EditText emailPessoa = view.findViewById(R.id.txtEmailUpdate);

        Button btnVoltarEdit = view.findViewById(R.id.btnBackUpdate);
        btnVoltarEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnCancelarEdit = view.findViewById(R.id.btnCancellUpdate);
        btnCancelarEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}