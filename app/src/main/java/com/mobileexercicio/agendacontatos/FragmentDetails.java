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
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FragmentDetails extends Fragment {

    private static final String ARG_PARAM1 = "nome";
    private static final String ARG_PARAM2 = "celular";
    private static final String ARG_PARAM3 = "endereco";
    private static final String ARG_PARAM4 = "email";

    private String nome;
    private String celular;
    private String endereco;
    private String email;

    public FragmentDetails() {
        // Required empty public constructor
    }

    public static FragmentDetails newInstance(String nome, String celular, String endereco, String email) {
        FragmentDetails fragment = new FragmentDetails();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, nome);
        args.putString(ARG_PARAM2, celular);
        args.putString(ARG_PARAM3, endereco);
        args.putString(ARG_PARAM4, email);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nome = getArguments().getString(ARG_PARAM1);
            celular = getArguments().getString(ARG_PARAM2);
            endereco = getArguments().getString(ARG_PARAM3);
            email = getArguments().getString(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnVoltar = view.findViewById(R.id.btnBackDetalle);
        TextView lblNome = view.findViewById(R.id.lblNameDetalle);
        TextView lblCelular = view.findViewById(R.id.lblPhoneDetalle);
        TextView lblEndereco = view.findViewById(R.id.lblHomeDetalle);
        TextView lblEmail = view.findViewById(R.id.lblEmailDetalle);

        lblNome.setText(nome);
        lblCelular.setText(celular);
        lblEndereco.setText(endereco);
        lblEmail.setText(email);


        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("nome",nome);
    }
}