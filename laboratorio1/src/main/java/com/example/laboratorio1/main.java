package com.example.laboratorio1;
import java.io.*;
public class main {
    public static void main(String[] args) throws FileNotFoundException {
        arbol arbol = new arbol();
        if(args[0].length() > 0){
            try {
                String buffer;
                BufferedReader bf = new BufferedReader(new FileReader(args[0]));
                while((buffer = bf.readLine()) != null){
                    String numero="";
                    for (int i =0; i<buffer.length(); i++){
                        if(buffer.charAt(i) != ','){
                            numero = numero+buffer.charAt(i);
                        }else {
                            arbol.agregar(Integer.valueOf(numero));
                            numero="";
                        }
                    }
                    arbol.agregar(Integer.valueOf(numero));
                }
            }catch (Exception e){
                System.out.println("error al leer archivo");
            }
        }else {
            System.out.println("debe ingresar un archivo como parametro");
        }
        arbol.imprimirArbol(arbol.raiz, (arbol.numNodos*10)/2);
    }
}
