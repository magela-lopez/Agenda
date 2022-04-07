package com.mobileexercicio.agendacontatos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class AgregarActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        EditText nomeP = findViewById(R.id.txtPersonNameAdd);
        EditText celularP = findViewById(R.id.txtPhoneAdd);
        EditText endereçoP = findViewById(R.id.txtAddressAdd);
        EditText emailP = findViewById(R.id.txtEmailAdd);
        getSupportActionBar().hide();

        Button btnVoltarAdd = findViewById(R.id.btnBackAddNew);
        Button btnCancelarAdd = findViewById(R.id.btnCancellAddNew);

        btnVoltarAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnCancelarAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nomeP.setText("");
                celularP.setText("");
                endereçoP.setText("");
                emailP.setText("");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
