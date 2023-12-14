package com.example.leerarchivo;

public class QueuePokedex extends Group {
    PocketMonster inicio, fin;
    int tamaño=0;

    public QueuePokedex(){
       inicio = fin = null;
    }

    @Override
    public void add(PocketMonster nuevo) {
        if (inicio == null){
            inicio = fin = nuevo;
        }else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        tamaño++;
    }
    @Override
    public PocketMonster remove() {
        if(inicio  == null){
            return null;
        }
        PocketMonster aux = inicio;
        inicio = aux.siguiente;
        tamaño--;
        return aux;
    }

    @Override
    public String show() {
        if(inicio == null) return "La cola esta vacia";
        PocketMonster aux = inicio;
        String nombres = "";
        while(aux != null){
            nombres = nombres+" "+aux.name+"/"+aux.type;
            aux = aux.siguiente;
        }
        return nombres;
    }
}
