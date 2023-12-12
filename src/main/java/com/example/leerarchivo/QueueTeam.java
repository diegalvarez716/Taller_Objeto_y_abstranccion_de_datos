package com.example.leerarchivo;

public class QueueTeam extends Group{
    PocketMonster cabeza,cola;
    int tamaño=0;

    public QueueTeam() {
        cabeza = cola = null;
    }

    @Override
    public void add(PocketMonster nuevo) {
        if (cabeza == null){
            cabeza = cola = nuevo;
        }else {
            cabeza.siguiente = nuevo;
            cabeza = nuevo;
        }
        tamaño++;
    }

    @Override
    public PocketMonster remove() {
        if(cola == null){
            return null;
        }
        PocketMonster aux = cola;
        cola = aux.siguiente;
        tamaño--;
        return aux;
    }

    @Override
    public String show() {
        if(cola == null) return "La cola esta vacia";
        PocketMonster aux = cola;
        String nombres = "";
        while(aux != null){
            nombres = nombres+" "+aux.name+"/"+aux.type;
            aux = aux.siguiente;
        }
        return nombres;
    }
}
