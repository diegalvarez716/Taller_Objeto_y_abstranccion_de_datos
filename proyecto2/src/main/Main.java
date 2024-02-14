package main;
import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Arbol et = new Arbol();

        //Creando los archivos
        File input = new File("proyecto2\\entrada_y_salida\\test1.input");
        File output = new File("proyecto2\\entrada_y_salida\\test1.output");
        File tree = new File("proyecto2\\entrada_y_salida\\test1.tree");

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

        try{
            PrintWriter salida = new PrintWriter(new FileWriter(output, true));
            BufferedReader entrada = new BufferedReader(new FileReader("proyecto2\\entrada_y_salida\\test1.input"));
            String lectura=entrada.readLine();

            while (lectura!=null){
                if("CORRECTO".equals(comprobar(lectura))){
                    String expresion=Notacion.conversionPostfijo(lectura);
                    int resultado=Resultado.resolucion(expresion);

                    salida.println(resultado);

                }else{
                    salida.println(comprobar(lectura));
                }
                lectura=entrada.readLine();
            }
            salida.close();

        }catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
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
