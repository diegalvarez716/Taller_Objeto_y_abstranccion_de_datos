package com.example.laboratorio1;

public class nodo {
    public int valor;
    public nodo derecha, izquierda;
    public nodo(int valor){
        this.valor = valor;
        derecha = null;
        izquierda = null;
    }

    public void add(int valor){
        if(valor > this.valor){
            if(derecha == null){
                derecha = new nodo(valor);
            }else{
                derecha.add(valor);
            }
        }else {
            if(izquierda == null){
                izquierda = new nodo(valor);
            }else{
                izquierda.add(valor);
            }
        }
    }


}
