package com.example.leerarchivo;

public class StackTeam extends Group{
    PocketMonster fin;
    int tamaño =0;
    public StackTeam(){
        fin = null;
    }

    @Override
    public void add(PocketMonster nuevo) {
        if (fin == null){
            fin = nuevo;
        }else {
            nuevo.siguiente = fin;
            fin = nuevo;
        }
        tamaño++;
    }

    @Override
    public PocketMonster remove() {
        if(fin == null){
            return null;
        }
        PocketMonster aux = fin;
        fin = aux.siguiente;
        tamaño--;
        return aux;
    }

    @Override
    public String show() {
        if(fin == null) return "La pila esta vacia";
        PocketMonster aux = fin;
        String nombres = "";
        while(aux != null){
            nombres = nombres+" "+aux.name+"/"+aux.type;
            aux = aux.siguiente;
        }
        return nombres;
    }
}
