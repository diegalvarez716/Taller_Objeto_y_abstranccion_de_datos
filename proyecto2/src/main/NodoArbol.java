package main;

public class NodoArbol {
    String contenido;
    NodoArbol derecha, izquierda;
    public NodoArbol(String contenido){
        this.contenido = contenido;
        derecha = null;
        izquierda = null;
    }
}
