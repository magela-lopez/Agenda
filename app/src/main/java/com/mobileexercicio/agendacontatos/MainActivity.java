package com.mobileexercicio.agendacontatos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity {

    private ListView contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Contatos");
        contatos = findViewById(R.id.listContatos);
        String listContacts []= {"Magela","Carmen","Cirila","Gimena"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listContacts);
        contatos.setAdapter(adapter);

        contatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nameContact = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), nameContact, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), DetalleActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("contactoSeleccionado",nameContact);
                FragmentDetails fragmentDetails = new FragmentDetails();
                intent.putExtras(bundle);
                startActivity(intent);
                //finish();
            }
        });
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingBtnAdd);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( getApplicationContext(), "troca de tela", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), AgregarActivity.class);
                startActivity(intent);
                //finish();
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


        }else if(item.getItemId() == R.id.action_add){
            Intent intent = new Intent(getApplicationContext(), AgregarActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}