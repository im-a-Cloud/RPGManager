package com.imd.rpgmanager.model;

import android.view.View;

public class Mochila {
    private String nome_item;
    private int quantidade_item;


    public Mochila(String nome_item, int quantidade_item) {
        this.nome_item = nome_item;
        this.quantidade_item = quantidade_item;
    }
    public void setNome_item(String nome_item){
        this.nome_item = nome_item;
    }
    public void setQuantidade_item(int quantidade_item){
        this.quantidade_item = quantidade_item;
    }
    public String getNome_item(){
        return  nome_item;
    }

    public int getQuantidade_item() {
        return quantidade_item;
    }

    @Override
    public String toString() {
        if(quantidade_item>0)
            return String.format("%sx %s", quantidade_item, nome_item);
        return nome_item;
    }

    public void onClick(View view){

    }
}
