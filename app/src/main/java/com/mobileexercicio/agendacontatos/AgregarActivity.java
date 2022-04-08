package com.mobileexercicio.agendacontatos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AgregarActivity extends AppCompatActivity {

    private EditText nomeP;
    private EditText celularP;
    private EditText enderecoP;
    private EditText emailP;
    private PessoaDB pessoaDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        getSupportActionBar().hide();

        Button btnVoltarAdd = findViewById(R.id.btnBackAddNew);
        Button btnCancelarAdd = findViewById(R.id.btnCancellAddNew);
        Button btnSalvarAdd = findViewById(R.id.btnSaveAddNew);
        nomeP = findViewById(R.id.txtPersonNameAdd);
        celularP = findViewById(R.id.txtPhoneAdd);
        enderecoP = findViewById(R.id.txtAddressAdd);
        emailP = findViewById(R.id.txtEmailAdd);
        pessoaDB = new PessoaDB(this);

        btnSalvarAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(nomeP.getText().toString().trim());
                pessoa.setCelular(celularP.getText().toString());
                pessoa.setEndereco(enderecoP.getText().toString());
                pessoa.setEmail(enderecoP.getText().toString());
                pessoaDB.save(pessoa);

            }
        });

        btnVoltarAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Pessoa> pessoas = pessoaDB.findAll();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("listContatos", (Serializable) pessoas);
                startActivity(intent);
            }
        });

        btnCancelarAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               nomeP.setText("");
                celularP.setText("");
                enderecoP.setText("");
                emailP.setText("");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
