import java.io.*;
public class Cartesiano {
    public static void main(String[] args) {

        File output = new File("entrada_y_salida\\test.output");

        try {
            FileWriter fw3 = new FileWriter(output, true);
            BufferedWriter bw3 = new BufferedWriter(fw3);
            PrintWriter salida3 = new PrintWriter(bw3);
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(output, true));
            BufferedReader entrada = new BufferedReader(new FileReader("entrada_y_salida\\test.input"));
            String lectura=entrada.readLine();

            while (lectura!=null){
                if(Errores(lectura).equals("CORRECTO")){
                    String[] parts = lectura.split("\\] \\[");

                    String[] array1 = parts[0].substring(1).split(", ");
                    String[] array2 = parts[1].substring(0, parts[1].length()-1).split(", ");

                    for(int i=0; i<array1.length; i++){
                        for (int j=0; j< array2.length; j++){
                            salida.println("["+array1[i]+", "+array2[j]+"]");
                        }
                    }
                    salida.println("---------------------------------------");
                }else {
                    salida.println(Errores(lectura));
                    salida.println("---------------------------------------");
                }
                lectura=entrada.readLine();
            }
            salida.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public static String Errores(String palabra){
        boolean isOpen = false;
        for (int i=0; i<palabra.length(); i++){
            char c = palabra.charAt(i);
            if(c == '['){
                if(isOpen){
                    return "ERROR: Se abrió un corchete sin cerrar el anterior.";
                }
                isOpen = true;
            } else if(c == ']'){
                if(!isOpen){
                    return "ERROR: Se cerró un corchete sin abrir uno antes.";
                }
                isOpen = false;
            } else if(c == ',' && i+1 < palabra.length() && palabra.charAt(i+1) == ','){
                return "ERROR: Dos comas consecutivas no son válidas.";
            } else if(c == ',' && i+1 < palabra.length() && palabra.charAt(i+1) != ' '){
                return "ERROR: Falta un espacio después de la coma.";
            }
        }
        if(isOpen){
            return "ERROR: Falta cerrar un corchete.";
        }
        return "CORRECTO";
    }

}
