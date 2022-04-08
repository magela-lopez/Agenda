package com.mobileexercicio.agendacontatos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ListView contatos;
    private PessoaDB pessoaDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Contatos");
        pessoaDB = new PessoaDB(this);

        List<Pessoa> pessoas = pessoaDB.findAll();

        contatos = (ListView) findViewById(R.id.listContatos);

       String[] array = new String[pessoas.size()];
        for(int i=0;i<pessoas.size();i++){
            array[i] = pessoas.get(i).getNome();
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,array);
        contatos.setAdapter(adapter);


        contatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nome = adapter.getItem(position);

                //Verifica la persona seleccionada (comparando la string con la lista de personas)
                for (int i = 0; i < pessoas.size() ; i++) {
                    if(nome.equals(pessoas.get(i).getNome())){

                        // envia la información a la activity relacionada al fragment
                        Intent intent = new Intent(getApplicationContext(),DetalleActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("nome",pessoas.get(i).getNome());
                        bundle.putString("celular",pessoas.get(i).getCelular());
                        bundle.putString("endereco",pessoas.get(i).getEndereco());
                        bundle.putString("email",pessoas.get(i).getEmail());
                        bundle.putInt("id",pessoas.get(i).getId());
                        intent.putExtras(bundle);
                        startActivity(intent);

                    }
                }


                }
        });
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingBtnAdd);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AgregarActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);

        MenuItem menuItemSearch = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItemSearch.getActionView();
        searchView.setOnQueryTextListener(onSearch());

        return true;
    }

    private SearchView.OnQueryTextListener onSearch(){
        return new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(TextUtils.isEmpty(newText)){
                    contatos.clearTextFilter();
                }else{
                    contatos.setFilterText(newText);
                    //contatos = newText;

                }
                return false;
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.action_search){
            Toast.makeText(getApplicationContext(),"busca", Toast.LENGTH_SHORT).show();

        }else if(item.getItemId() == R.id.action_add){
            Intent intent = new Intent(getApplicationContext(), AgregarActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}