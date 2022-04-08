package com.mobileexercicio.agendacontatos;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        //setContentView(R.layout.fragment_details);

        getSupportActionBar().setTitle("Contatos");

        ActionBar actionBar = getSupportActionBar();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.Tab tab = actionBar.newTab().setText("Detalle");
        tab.setTabListener(new MyTabListener(new FragmentDetails()));
        actionBar.addTab(tab);

        //Envia información del contacto al fragment de detalles
        Bundle bundle = getIntent().getExtras();
        FragmentDetails fragmentDetails = new FragmentDetails();
        fragmentDetails.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragDetails,fragmentDetails)
                .commit();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.Tab tab2 = actionBar.newTab().setText("Editar");
        tab2.setTabListener(new MyTabListener(new FragmentEdit()));
        actionBar.addTab(tab2);

            Bundle bundle1 = getIntent().getExtras();
            //Envia información del contacto al fragment de actualizar
            FragmentEdit fragmentEdit = new FragmentEdit();
            fragmentEdit.setArguments(bundle1);
            getSupportFragmentManager().beginTransaction().add(R.id.layoutFragEdit,fragmentEdit)
                    .commit();


    }

}
