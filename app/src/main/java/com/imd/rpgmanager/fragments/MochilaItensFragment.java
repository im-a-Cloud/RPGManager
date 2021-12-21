package com.imd.rpgmanager.fragments;

import android.os.Bundle;

import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.imd.rpgmanager.R;
import com.imd.rpgmanager.model.Mochila;

import java.util.ArrayList;
import java.util.List;

public class MochilaItensFragment extends ListFragment {

    List<Mochila>Itens_na_mochila = new ArrayList<Mochila>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }
     private List<Mochila> carregar_itens_mochila(){
        List<Mochila> itens = new ArrayList<Mochila>();

        Itens_na_mochila.add(new Mochila("Buster Sword", 1));
        return itens;
    }
    public void add_itens_na_mochila(Mochila mochila){
        Itens_na_mochila.add(mochila);
    }


}