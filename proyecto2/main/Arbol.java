package main;
import java.io.*;
import java.util.*;

public class Arbol {
    Nodo raiz;

    boolean esOperador(String c) {
        if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
            return true;
        }
        return false;
    }

    public void imprimirArbol(Nodo nodo, String prefijo, boolean esIzquierda, PrintWriter salida) {
        if (nodo != null) {
            salida.println(prefijo + (esIzquierda ? "├── " : "└── ") + nodo.valor);
            imprimirArbol(nodo.izquierda, prefijo + (esIzquierda ? "│   " : "    "), true, salida);
            imprimirArbol(nodo.derecha, prefijo + (esIzquierda ? "│   " : "    "), false, salida);
        }
    }
    public void imprimirArbolVertical(Nodo raiz, PrintWriter salida) {
        imprimirArbol(raiz, "", true, salida);
    }
    public Nodo construirArbol(String postfix[]) {
        Stack<Nodo> pila = new Stack();
        Nodo t, t1, t2;

        for (int i = 0; i < postfix.length; i++) {
            if (!esOperador(postfix[i])) {
                t = new Nodo(postfix[i]);
                pila.push(t);
            } else {
                t = new Nodo(postfix[i]);

                t1 = pila.pop();
                t2 = pila.pop();

                t.derecha = t1;
                t.izquierda = t2;

                pila.push(t);
            }
        }

        t = pila.peek();
        pila.pop();

        return t;
    }
}