import main.Notacion;
import main.Resultado;
import java.io.*;

public class Main {
    public static void main(String[] args) {
           try{
               FileWriter fw = new FileWriter("C:\\Users\\Usuario\\Desktop\\Taller_Objeto_y_abstranccion_de_datos\\proyecto2\\entrada_y_salida\\test1.output.md", true);
               BufferedWriter salida = new BufferedWriter(fw);

               FileWriter fw2= new FileWriter("C:\\Users\\Usuario\\Desktop\\Taller_Objeto_y_abstranccion_de_datos\\proyecto2\\entrada_y_salida\\test1.tree.md", true);
               BufferedWriter salida2 = new BufferedWriter(fw2);

               BufferedReader entrada = new BufferedReader(new FileReader("C:\\Users\\Usuario\\Desktop\\Taller_Objeto_y_abstranccion_de_datos\\proyecto2\\entrada_y_salida\\test1.input.md"));
               String lectura=entrada.readLine();

               int index =0;

               while (lectura!=null){
                   if("CORRECTO".equals(comprobar(lectura))){
                       String expresion= Notacion.conversionPostfijo(lectura);
                       int resultado= Resultado.resolucion(expresion);
                       salida.write(resultado+"\n");
                       try {
                           salida2.write(Resultado.lista.get(index).graficar());
                           index+=1;
                       }catch (Exception e){}
                   }else{
                       salida.write(comprobar(lectura));
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
