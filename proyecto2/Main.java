import java.io.*;
import java.util.List;
import static main.Resultado.*;
import static main.Notacion.*;
import main.Arbol;
import main.Arbol.*;
import main.Nodo;
import main.Notacion;
import main.Resultado;

public class Main {
    public static void main(String[] args) {

        Arbol arbol = new Arbol();

        //Creando los archivos
        File output = new File("entrada_y_salida\\test.output");
        File tree = new File("entrada_y_salida\\test.tree");

        try {

            FileWriter fw2 = new FileWriter(output, true);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            PrintWriter salida2 = new PrintWriter(bw2);

            FileWriter fw3 = new FileWriter(tree, true);
            BufferedWriter bw3 = new BufferedWriter(fw3);
            PrintWriter salida3 = new PrintWriter(bw3);
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        try{
            PrintWriter salida = new PrintWriter(new FileWriter(output, true));
            PrintWriter salida2 = new PrintWriter(new FileWriter(tree, true));
            BufferedReader entrada = new BufferedReader(new FileReader("entrada_y_salida\\test.input"));
            String lectura=entrada.readLine();

            while (lectura!=null){
                if("CORRECTO".equals(comprobar(lectura))){
                    String expresion= Notacion.conversionPostfijo(lectura);
                    int resultado= Resultado.resolucion(expresion);

                    String[] postfix = expresion.split(" ");
                    Nodo raiz = arbol.construirArbol(postfix);
                    arbol.imprimirArbolVertical(raiz, salida2);

                    salida2.println("------------------------------------");
                    salida.println(resultado);
                    salida.println("-----------");

                }else{
                    salida.println(comprobar(lectura));
                    salida.println("-----------");
                    salida2.println(comprobar(lectura));
                    salida2.println("------------------------------------");
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
        System.out.println("Corrida Exitosa");

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
                    return "ERROR";
                }
            }
        }
        return "CORRECTO";
    }
}