package com.example.leerarchivo;
import java.io.*;
public class main {
    public static void main(String [] args){

        StackPokedex stackPokedex = new StackPokedex(); QueuePokedex queuePokedex= new QueuePokedex();
        StackTeam stackTeam = new StackTeam(); QueueTeam queueTeam = new QueueTeam();

        String encuentro, stackteam, queueteam, stackpokedex,queuepokedex;

        try {
            String buffer,copia;
            BufferedReader bf = new BufferedReader(new FileReader(args[0]));

            while((buffer = bf.readLine()) != null){

                if(buffer.equalsIgnoreCase("CREATE STACK POKEDEX")){

                    buffer = bf.readLine();
                    copia = buffer.trim();

                    for(int i=0; i<copia.length();i++){

                        String nombreytipo="",nombre="",tipo="";

                        try {
                            while (buffer.charAt(i) != ','){
                                nombreytipo = nombreytipo + copia.charAt(i);
                                i++;
                            }
                        }catch (Exception e){
                        }

                        int j;
                        try {
                            for (j=0; nombreytipo.trim().charAt(j)!='/';j++){
                                nombre=nombre+nombreytipo.trim().charAt(j);
                            }
                            for (int k=j+1; k<nombreytipo.length(); k++){
                                tipo = tipo+nombreytipo.trim().charAt(k);
                            }
                        }catch (Exception e){
                        }

                        if(tipo.trim().equalsIgnoreCase("Fire") || tipo.trim().equalsIgnoreCase("Water") ||
                                tipo.trim().equalsIgnoreCase("Grass")){
                                PocketMonster nuevo = new PocketMonster(tipo,nombre);
                                stackPokedex.add(nuevo);
                        }
                    }

                }else if (buffer.equalsIgnoreCase("CREATE QUEUE POKEDEX")){

                    buffer = bf.readLine();
                    copia = buffer.trim();

                    for(int i=0; i<copia.length();i++){

                        String nombreytipo="",nombre="",tipo="";

                        try {
                            while (buffer.charAt(i) != ','){
                                nombreytipo = nombreytipo + copia.charAt(i);
                                i++;
                            }
                        }catch (Exception e){
                        }

                        int j;
                        try {
                            for (j=0; nombreytipo.trim().charAt(j)!='/';j++){
                                nombre=nombre+nombreytipo.trim().charAt(j);
                            }
                            for (int k=j+1; k<nombreytipo.length(); k++){
                                tipo = tipo+nombreytipo.trim().charAt(k);
                            }
                        }catch (Exception e){
                        }

                        if(tipo.trim().equalsIgnoreCase("Fire") || tipo.trim().equalsIgnoreCase("Water") ||
                                tipo.trim().equalsIgnoreCase("Grass")){
                            PocketMonster nuevo = new PocketMonster(tipo,nombre);
                            queuePokedex.add(nuevo);
                        }
                    }

                }else if (buffer.equalsIgnoreCase("SHOW STACK POKEDEX")){
                    stackpokedex = stackPokedex.show();
                }else if (buffer.equalsIgnoreCase("SHOW QUEUE POKEDEX")){
                    queuepokedex = queuePokedex.show();
                }else if (buffer.equalsIgnoreCase("CREATE STACK TEAM")){

                    
                }else if (buffer.equalsIgnoreCase("CREATE QUEUE TEAM")){

                    
                }else if (buffer.equalsIgnoreCase("SHOW STACK TEAM")) {
                    stackteam = stackTeam.show();
                }else if (buffer.equalsIgnoreCase("SHOW QUEUE TEAM")){
                    queueteam = queueTeam.show();
                } else if (buffer.equalsIgnoreCase("ENCOUNTER")) {
                    encuentro = Encuentro(stackTeam,queueTeam);
                }
            }

        }catch (Exception e){
            System.out.println("Error al leer el archivo");
        }


    }


    public static String Encuentro(StackTeam team1, QueueTeam team2){
        String retorno ="";
        int i =1;
        while ((team1.tamaño> 0 && team2.tamaño > 0)){
            PocketMonster pokemon1, pokemon2,ganador;
            pokemon1 = team1.remove();
            pokemon2 = team2.remove();
            ganador = ganador(pokemon1,pokemon2);

            if(ganador != null){
                retorno = retorno + "\nTURN "+String.valueOf(i)+"\n"+pokemon1.name+"/"+pokemon1.type+" VS "+pokemon2.name+"/"+pokemon2.type +
                        " -> "+ganador.name+"/"+ganador.type;
                if(ganador == pokemon1){

                    team1.add(pokemon1);
                }else{

                    team2.add(pokemon2);
                }
            }else{

                team1.add(pokemon1);
                team2.add(pokemon2);
                retorno = retorno + "\nTURN "+String.valueOf(i)+"\n"+pokemon1.name+"/"+pokemon1.type+" VS "+pokemon2.name+"/"+pokemon2.type +
                        " -> DRAW";
            }

            if((team1.tamaño==0 && team2.tamaño==0)&&(pokemon1.type.equalsIgnoreCase(pokemon2.type))){
                team1.add(pokemon1);
                team2.add(pokemon2);
                break;
            }
            i++;
        }

        if (team1.tamaño == 0) {
            retorno = retorno+"\n"+"QUEUE TEAM WINS";
        } else if (team2.tamaño == 0) {
            retorno = retorno+"\n"+"STACK TEAM WINS";
        } else {
            retorno = retorno+"\n"+"TIE";
        }

        return retorno;
    }

    public static PocketMonster ganador(PocketMonster pokemon1, PocketMonster pokemon2){

        if (pokemon1.type.equalsIgnoreCase("Water") && pokemon2.type.equalsIgnoreCase("Fire")){
            return pokemon1;
        }else if(pokemon1.type.equalsIgnoreCase("Fire") && pokemon2.type.equalsIgnoreCase("Grass")){
            return pokemon1;
        } else if (pokemon1.type.equalsIgnoreCase("Grass") && pokemon2.type.equalsIgnoreCase("Water")) {
            return pokemon1;
        } else if (pokemon2.type.equalsIgnoreCase("Water") && pokemon1.type.equalsIgnoreCase("Fire")) {
            return pokemon2;
        } else if (pokemon2.type.equalsIgnoreCase("Fire") && pokemon1.type.equalsIgnoreCase("Grass")) {
            return pokemon2;
        } else if (pokemon2.type.equalsIgnoreCase("Grass") && pokemon1.type.equalsIgnoreCase("Water")) {
            return pokemon2;
        }else if(pokemon1.type.equalsIgnoreCase(pokemon2.type)){
            return null;
        }

        return null;
    }

}
