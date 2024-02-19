package main;

public class Nodo {
    String valor;
    Nodo izquierda, derecha;

    Nodo(String item) {
        valor = item;
        izquierda = derecha = null;
    }
}
