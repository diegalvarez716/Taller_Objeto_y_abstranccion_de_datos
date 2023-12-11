package com.example.leerarchivo;
import java.io.*;
public class main {

    public static void main(String [] args){

        try {
            String buffer;
            BufferedReader bf = new BufferedReader(new FileReader(args[0]));
            while((buffer = bf.readLine()) != null){

                if(buffer.equalsIgnoreCase("CREATE STACK POKEDEX")){

                }else if (buffer.equalsIgnoreCase("CREATE QUEUE POKEDEX")){

                }else if (buffer.equalsIgnoreCase("SHOW STACK POKEDEX")){

                }else if (buffer.equalsIgnoreCase("SHOW QUEUE POKEDEX")){

                }else if (buffer.equalsIgnoreCase("CREATE STACK TEAM")){
                    
                }else if (buffer.equalsIgnoreCase("CREATE QUEUE TEAM")){
                    
                }else if (buffer.equalsIgnoreCase("SHOW STACK TEAM")) {
                    
                }else if (buffer.equalsIgnoreCase("SHOW QUEUE TEAM")){

                } else if (buffer.equalsIgnoreCase("ENCOUNTER")) {

                }
            }

        }catch (Exception e){
            System.out.println("Error al leer el archivo");
        }

    }

}
