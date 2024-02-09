package com.example.laboratorio1;

public class arbol {
    nodo raiz;
    int numNodos=0;

    public arbol(){
        raiz = null;
    }

    public void agregar(int valor){
        if(raiz == null){
            raiz = new nodo(valor);
            numNodos++;
        }else{
            raiz.add(valor);
            numNodos++;
        }
    }

    /*
    public void dispararInorden(){
        inorden(raiz);
    }
    public void inorden(nodo raiz){
        if(raiz == null){
            return;
        }else {
            inorden(raiz.izquierda);
            System.out.print(raiz.valor+" ");
            inorden(raiz.derecha);

        }
    }
    */

    void imprimirArbol(nodo nodo, int espacio) {
        if (nodo == null)
            return;

        for (int i=0; i<espacio; i++) System.out.print(" ");
        System.out.println(nodo.valor);

        imprimirArbol(nodo.derecha, espacio+10);
        imprimirArbol(nodo.izquierda, espacio-10);


    }
}
