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
import android.widget.Toast;

public class FragmentEdit extends Fragment {


    private static final String ARG_PARAM1 = "nome";
    private static final String ARG_PARAM2 = "celular";
    private static final String ARG_PARAM3 = "endereco";
    private static final String ARG_PARAM4 = "email";
    private static final String ARG_PARAM5 = "id";
    PessoaDB pessoaDB;

    private String nome;
    private String celular;
    private String endereco;
    private String email;
    private int id;

    public FragmentEdit() {
        // Required empty public constructor
    }

    public static FragmentEdit newInstance(String nome, String celular, String endereco, String email, int id) {
        FragmentEdit fragment = new FragmentEdit();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, nome);
        args.putString(ARG_PARAM2, celular);
        args.putString(ARG_PARAM3, endereco);
        args.putString(ARG_PARAM4, email);
        args.putInt(ARG_PARAM5,id);
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
            id= getArguments().getInt(ARG_PARAM5);
        }
    }

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
        EditText enderecoPessoa = view.findViewById(R.id.txtAddressUpdate);
        EditText emailPessoa = view.findViewById(R.id.txtEmailUpdate);

        nomePessoa.setText(nome);
        celularPessoa.setText(celular);
        enderecoPessoa.setText(endereco);
        emailPessoa.setText(email);

        pessoaDB = new PessoaDB(getContext());
        Button btnSalvar = view.findViewById(R.id.btnSaveUpdate);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(nomePessoa.getText().toString().trim());
                pessoa.setCelular(celularPessoa.getText().toString());
                pessoa.setEndereco(enderecoPessoa.getText().toString());
                pessoa.setEmail(emailPessoa.getText().toString());
                pessoa.setId(id);
                pessoaDB.save(pessoa);

                Toast.makeText(getContext(), "Dados Atualizados", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

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