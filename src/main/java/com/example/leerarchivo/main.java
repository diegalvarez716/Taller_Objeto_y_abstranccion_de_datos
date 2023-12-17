package com.example.leerarchivo;
import java.io.*;
import javax.swing.JOptionPane;
public class main {
    public static void main(String [] args){

        StackPokedex stackPokedex = new StackPokedex(); QueuePokedex queuePokedex= new QueuePokedex();
        StackTeam stackTeam = new StackTeam(); QueueTeam queueTeam = new QueueTeam();
        String encuentro="", stackteam="", queueteam="", stackpokedex="",queuepokedex="";

        String ruta = System.getProperty("user.home") + "/Desktop";
        String rutaArchivo = ruta.replace("\\", "/")+"\\ArchivoSalida.mpdm";


        if(args[0].length() > 0){
            try {
                String buffer;
                BufferedReader bf = new BufferedReader(new FileReader(args[0]));

                while((buffer = bf.readLine()) != null){

                    if(buffer.equalsIgnoreCase("CREATE STACK POKEDEX")){
                        buffer = bf.readLine();
                        for(int i=0; i<buffer.length();i++){

                            String nombreytipo="",nombre="",tipo="";
                            if(buffer.charAt(i) != ' '){
                                try {
                                    while (buffer.charAt(i) != ','){
                                        nombreytipo = nombreytipo + buffer.charAt(i);
                                        i++;
                                    }
                                }catch (Exception e){
                                }
                            }

                            if(!(nombreytipo.equalsIgnoreCase(""))){
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
                            }

                            if(tipo.trim().equalsIgnoreCase("Fire") || tipo.trim().equalsIgnoreCase("Water") ||
                                    tipo.trim().equalsIgnoreCase("Grass")){
                                PocketMonster nuevo = new PocketMonster(tipo.trim(),nombre.trim());
                                stackPokedex.add(nuevo);
                            }
                        }

                    }else if (buffer.equalsIgnoreCase("CREATE QUEUE POKEDEX")){

                        buffer = bf.readLine();

                        for(int i=0; i<buffer.length();i++){

                            String nombreytipo="",nombre="",tipo="";

                            if(buffer.charAt(i) != ' '){
                                try {
                                    while (buffer.charAt(i) != ','){
                                        nombreytipo = nombreytipo + buffer.charAt(i);
                                        i++;
                                    }
                                }catch (Exception e){
                                }
                            }

                            if(!(nombreytipo.equalsIgnoreCase(""))){
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
                            }

                            if(tipo.trim().equalsIgnoreCase("Fire") || tipo.trim().equalsIgnoreCase("Water") ||
                                    tipo.trim().equalsIgnoreCase("Grass")){
                                PocketMonster nuevo = new PocketMonster(tipo.trim(),nombre.trim());
                                queuePokedex.add(nuevo);
                            }
                        }

                    }else if (buffer.equalsIgnoreCase("SHOW STACK POKEDEX")){
                        stackpokedex = stackPokedex.show();
                    }else if (buffer.equalsIgnoreCase("SHOW QUEUE POKEDEX")){
                        queuepokedex = queuePokedex.show();
                    }else if (buffer.equalsIgnoreCase("CREATE STACK TEAM")){
                        buffer = bf.readLine();
                        for (int i=0; i<buffer.length(); i++){
                            String tipo="";
                            try{
                                while (buffer.charAt(i) != ' '){
                                    tipo=tipo+buffer.charAt(i);
                                    i++;
                                }
                            }catch (Exception e) {
                            }
                            if (!(tipo.equalsIgnoreCase(""))){
                                llenarteamstack(tipo,stackPokedex,stackTeam);
                            }
                        }

                    }else if (buffer.equalsIgnoreCase("CREATE QUEUE TEAM")){
                        buffer = bf.readLine();
                        for (int i=0; i<buffer.length(); i++){
                            String tipo="";
                            try{
                                while (buffer.charAt(i) != ' '){
                                    tipo=tipo+buffer.charAt(i);
                                    i++;
                                }
                            }catch (Exception e){
                            }

                            if(!(tipo.equalsIgnoreCase(""))){
                                llenarteamqueue(tipo, queuePokedex, queueTeam);
                            }
                        }
                    }else if (buffer.equalsIgnoreCase("SHOW STACK TEAM")) {
                        stackteam = stackTeam.show();
                    }else if (buffer.equalsIgnoreCase("SHOW QUEUE TEAM")){
                        queueteam = queueTeam.show();
                    } else if (buffer.equalsIgnoreCase("ENCOUNTER")) {
                        encuentro = Encuentro(stackTeam,queueTeam);
                    }
                }

            }catch (IOException e){
                JOptionPane.showMessageDialog(null, "Error al leer el archivo de entrada");
            }

            try {
                FileWriter fw = new FileWriter(rutaArchivo, true);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write("STACK POKEDEX \n");
                bw.write(stackpokedex);
                bw.write("\n QUEUE POKEDEX \n");
                bw.write(queuepokedex);
                bw.write("\n STACK TEAM \n");
                bw.write(stackteam);
                bw.write("\n QUEUE TEAM \n");
                bw.write(queueteam);
                bw.write(encuentro);
                bw.close();
            }catch (IOException e){
                JOptionPane.showMessageDialog(null, "Error al escribir el archivo de salida");
            }finally {
                JOptionPane.showMessageDialog(null, "Archivo de salida escrito satisfactoriamente en el escritorio");
            }
        }else{
           JOptionPane.showMessageDialog(null, "Debe pasar un archivo como parametro");
        }


    }
    public static String Encuentro(StackTeam team1, QueueTeam team2){
        String retorno ="";
        int i =1;

        while ((team1.tamaño> 0 && team2.tamaño > 0)){

            PocketMonster pokemon1, pokemon2,ganador;
            pokemon1 = team1.remove();
            pokemon2 = team2.remove();

            if((team1.tamaño == team2.tamaño)){
                if(iguales(team1,team2)){
                    team1.add(pokemon1);
                    team2.add(pokemon2);
                    break;
                }
            }

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
    public static void llenarteamstack (String tipo, StackPokedex pokedex, StackTeam team){
        PocketMonster aux = pokedex.fin;
        while (aux != null){
            if(aux.type.equalsIgnoreCase(tipo) && !aux.seleccionado){
                aux.seleccionado = true;
                team.add(new PocketMonster(aux.type, aux.name));
                break;
            }
            aux = aux.siguiente;
        }
    }
    public static void llenarteamqueue (String tipo, QueuePokedex pokedex, QueueTeam team){
        PocketMonster aux = pokedex.inicio;
        while (aux != null){
            if(aux.type.equalsIgnoreCase(tipo) && !aux.seleccionado){
                aux.seleccionado = true;
                team.add(new PocketMonster(aux.type, aux.name));
                break;
            }
            aux = aux.siguiente;
        }

    }
    public static boolean iguales(StackTeam team1, QueueTeam team2){
        PocketMonster aux1 = team1.fin;
        PocketMonster aux2 = team2.inicio;
        while (aux1 != null){
            if(!(aux1.type.equalsIgnoreCase(aux2.type)))
                return false;
            aux1 = aux1.siguiente;
            aux2 = aux2.siguiente;
        }
        return true;
    }

}
