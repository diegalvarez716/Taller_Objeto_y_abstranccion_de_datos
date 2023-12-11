package com.example.leerarchivo;

public class StackTeam extends Group{
    PocketMonster cabeza,cola;
    int tamaño =0;
    public StackTeam(){
        cabeza = cola = null;
    }

    @Override
    public void add(PocketMonster nuevo) {
        if (cola == null){
            cabeza = cola = nuevo;
        }else {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        }
        tamaño++;
    }

    @Override
    public PocketMonster remove() {
        if(cola == null){
            return null;
        }
        PocketMonster aux = cabeza;
        cabeza = aux.siguiente;
        return aux;
    }

    @Override
    public String show() {
        if(cola == null) return "La pila esta vacia";
        PocketMonster aux = cabeza;
        String nombres = "";
        while(aux != null){
            nombres = nombres+" "+aux.name;
            aux = aux.siguiente;
        }
        return nombres;
    }
}
