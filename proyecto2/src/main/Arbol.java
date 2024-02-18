package main;

public class Arbol {
    NodoArbol raiz;
    public  Arbol(){
        raiz = null;
    }
    public void add (String contenido){
        if (raiz==null){
            raiz = new NodoArbol(contenido);
        } else if (raiz.derecha ==null){
            raiz.derecha = new NodoArbol(contenido);
        }else {
            raiz.izquierda = new NodoArbol(contenido);
        }
    }
    public String graficar(){
        String retorno = "   "+raiz.contenido+"   \n"+
                         "  / \\"+"\n"+
                         " "+raiz.izquierda.contenido+"   "+raiz.derecha.contenido+"\n";
        return retorno;
    }

}
