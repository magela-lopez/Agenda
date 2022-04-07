package com.mobileexercicio.agendacontatos;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MyTabListener implements ActionBar.TabListener {
    private Fragment fragment;

    public MyTabListener(FragmentEdit fragmentEdit) {
        this.fragment = fragmentEdit;
    }
    public MyTabListener(FragmentDetails fragmentDetails) {
        this.fragment = fragmentDetails;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        ft.replace(R.id.layoutFragEdit, this.fragment,null);
        ft.replace(R.id.layoutFragEdit, this.fragment,null);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
