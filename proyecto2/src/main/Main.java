package main;
import javax.swing.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        //Creando los archivos
        File input = new File("proyecto2\\entrada_y_salida\\test1.input.mpdm");
        File output = new File("proyecto2\\entrada_y_salida\\test1.output.mpdm");
        File tree = new File("proyecto2\\entrada_y_salida\\test1.tree.mpdm");

        try {
            FileWriter fw = new FileWriter(input, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);

            FileWriter fw2 = new FileWriter(output, true);
            BufferedWriter bw2 = new BufferedWriter(fw);
            PrintWriter salida2 = new PrintWriter(bw);

            FileWriter fw3 = new FileWriter(tree, true);
            BufferedWriter bw3 = new BufferedWriter(fw3);
            PrintWriter salida3 = new PrintWriter(bw3);
            salida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

       if(!args[0].isEmpty()){
           try{
               PrintWriter salida = new PrintWriter(new FileWriter(output, true));
               PrintWriter salida2 = new PrintWriter(new FileWriter(tree, true));
               BufferedReader entrada = new BufferedReader(new FileReader(args[0]));
               String lectura=entrada.readLine();
               int index =0;
               while (lectura!=null){
                   if("CORRECTO".equals(comprobar(lectura))){
                       String expresion=Notacion.conversionPostfijo(lectura);
                       int resultado=Resultado.resolucion(expresion);
                       salida.println(resultado);
                       try {
                           salida2.println(Resultado.lista.get(index).graficar());
                           index+=1;
                       }catch (Exception e){}
                   }else{
                       salida.println(comprobar(lectura));
                   }
                   lectura=entrada.readLine();
               }
               salida.close();
               salida2.close();

           }catch (FileNotFoundException e) {
               e.printStackTrace(System.out);
           } catch (IOException e) {
               e.printStackTrace(System.out);
           }
       }else {
           JOptionPane.showMessageDialog(null, "Debe pasar un archivo como parametro");
       }

    }

    private static String comprobar(String expresion){
        for (int i=0; i<expresion.length(); i++){
            if(i==0){
                if(Notacion.jerarquia(expresion.charAt(0))>0){
                    return "ERROR";
                }
            }
            if(expresion.charAt(i)=='.' || expresion.charAt(i)==','){
                return "ERROR";
            }
            if(Notacion.jerarquia(expresion.charAt(i))>0){
                if (Notacion.jerarquia(expresion.charAt(i+1))>0){
                    return "ERROR";
                }
            }
            if(expresion.charAt(i)=='/'){
                if(expresion.charAt(i+1)=='0'){
                    return "DIVISION ENTRE 0";
                }
            }
        }
        return "CORRECTO";
    }
}
