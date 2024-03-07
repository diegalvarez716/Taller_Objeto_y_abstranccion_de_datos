import com.example.monedas.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
            FileWriter salida = new FileWriter("entrada_y_salida\\test.output");
            BufferedWriter bw= new BufferedWriter(salida);

        try {
            FileReader entrada = new FileReader("entrada_y_salida\\test.input");
            BufferedReader bf= new BufferedReader(entrada);
            String buffer;

            while((buffer = bf.readLine())!=null){
                String cantidad="", moneda="", metodo="";
                int i = 0;
                while ((((int)(buffer.charAt(i)) >= 48)&&((int)(buffer.charAt(i)) <= 57)||((int)(buffer.charAt(i)) == 46))){
                    if((((int)(buffer.charAt(i+1)) >= 48)&&((int)(buffer.charAt(i+1)) <= 57)||((int)(buffer.charAt(i+1)) == 46))){
                        cantidad=cantidad+buffer.charAt(i);
                        i++;
                    }else{
                        break;
                    }
                }
                i++;
                while ((int)(buffer.charAt(i)) != 46){
                    moneda = moneda+buffer.charAt(i);
                    i++;
                }
                i++;
                while ((int)(buffer.charAt(i)) != 40){
                    metodo=metodo+buffer.charAt(i);
                    i++;
                }
                i++;

                if(metodo.equalsIgnoreCase("en")){
                    String conversion="";
                    while((int)(buffer.charAt(i)) != 41){
                        conversion+=buffer.charAt(i);
                        i++;
                    }

                    if(moneda.equalsIgnoreCase("euros")){
                        Euro monedaBase = new Euro(Float.parseFloat(cantidad));
                        if(!conversion.isEmpty()){
                            bw.write(monedaBase.en(conversion)+"\n");
                        }else bw.write("Error, campo vacio \n");

                    } else if (moneda.equalsIgnoreCase("dolares")) {
                        Dolar monedaBase = new Dolar(Float.parseFloat(cantidad));
                        if(!conversion.isEmpty()){
                            bw.write(monedaBase.en(conversion)+"\n");
                        }else bw.write("Error, campo vacio \n");

                    } else if (moneda.equalsIgnoreCase("yens")) {
                        Yen monedaBase = new Yen(Float.parseFloat(cantidad));
                        if(!conversion.isEmpty()){
                            bw.write(monedaBase.en(conversion)+"\n");
                        }else bw.write("Error, campo vacio \n");

                    } else if (moneda.equalsIgnoreCase("bitcoins")) {
                        Bitcoin monedaBase = new Bitcoin(Float.parseFloat(cantidad));
                        if(!conversion.isEmpty()){
                            bw.write(monedaBase.en(conversion)+"\n");
                        }else bw.write("Error, campo vacio \n");

                    } else if (moneda.equalsIgnoreCase("bolivares")) {
                       Bolivar monedaBase = new Bolivar(Float.parseFloat(cantidad));
                        if(!conversion.isEmpty()){
                            bw.write(monedaBase.en(conversion)+"\n");
                        }else bw.write("Error, campo vacio \n");

                    }else {
                        bw.write("Error, moneda base no reconocida \n");
                    }

                } else if (metodo.equalsIgnoreCase("comparar")) {

                    String cantidad2="", moneda2="";

                    while ((((int)(buffer.charAt(i)) >= 48)&&((int)(buffer.charAt(i)) <= 57)||((int)(buffer.charAt(i)) == 46))){
                        if((((int)(buffer.charAt(i+1)) >= 48)&&((int)(buffer.charAt(i+1)) <= 57)||((int)(buffer.charAt(i+1)) == 46))){
                            cantidad2=cantidad2+buffer.charAt(i);
                            i++;
                        }else{
                            break;
                        }
                    }
                    i++;
                    while ((int)(buffer.charAt(i)) != 41){
                        moneda2 = moneda2+buffer.charAt(i);
                        i++;
                    }

                    if (!(cantidad2.isEmpty())&&!(moneda2.isEmpty())){
                        if(moneda.equalsIgnoreCase("dolares")){
                            Dolar monedabase = new Dolar(Float.parseFloat(cantidad));
                            if (moneda2.equalsIgnoreCase("euros")){
                                Euro monedacomparar = new Euro(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("yens")) {
                                Yen monedacomparar = new Yen(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("bitcoins")) {
                                Bitcoin monedacomparar = new Bitcoin(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("bolivares")) {
                                Bolivar monedacomparar = new Bolivar(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("dolares")) {
                                Dolar monedacomparar = new Dolar(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            }else{
                                bw.write("Error, moneda a comparar no reconocida \n");
                            }
                        } else if (moneda.equalsIgnoreCase("euros")) {
                            Euro monedabase = new Euro(Float.parseFloat(cantidad));
                            if (moneda2.equalsIgnoreCase("euros")){
                                Euro monedacomparar = new Euro(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("yens")) {
                                Yen monedacomparar = new Yen(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("bitcoins")) {
                                Bitcoin monedacomparar = new Bitcoin(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("bolivares")) {
                                Bolivar monedacomparar = new Bolivar(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("dolares")) {
                                Dolar monedacomparar = new Dolar(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            }else{
                                bw.write("Error, moneda a comparar no reconocida \n");
                            }

                        } else if (moneda.equalsIgnoreCase("bitcoins")) {
                            Bitcoin monedabase = new Bitcoin(Float.parseFloat(cantidad));
                            if (moneda2.equalsIgnoreCase("euros")){
                                Euro monedacomparar = new Euro(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("yens")) {
                                Yen monedacomparar = new Yen(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("bitcoins")) {
                                Bitcoin monedacomparar = new Bitcoin(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("bolivares")) {
                                Bolivar monedacomparar = new Bolivar(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("dolares")) {
                                Dolar monedacomparar = new Dolar(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            }else{
                                bw.write("Error, moneda a comparar no reconocida \n");
                            }

                        } else if (moneda.equalsIgnoreCase("yens")) {
                            Yen monedabase = new Yen(Float.parseFloat(cantidad));
                            if (moneda2.equalsIgnoreCase("euros")){
                                Euro monedacomparar = new Euro(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("yens")) {
                                Yen monedacomparar = new Yen(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("bitcoins")) {
                                Bitcoin monedacomparar = new Bitcoin(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("bolivares")) {
                                Bolivar monedacomparar = new Bolivar(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("dolares")) {
                                Dolar monedacomparar = new Dolar(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            }else{
                                bw.write("Error, moneda a comparar no reconocida \n");
                            }
                        } else if (moneda.equalsIgnoreCase("bolivares")) {
                            Bolivar monedabase = new Bolivar(Float.parseFloat(cantidad));
                            if (moneda2.equalsIgnoreCase("euros")){
                                Euro monedacomparar = new Euro(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("yens")) {
                                Yen monedacomparar = new Yen(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("bitcoins")) {
                                Bitcoin monedacomparar = new Bitcoin(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("bolivares")) {
                                Bolivar monedacomparar = new Bolivar(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            } else if (moneda2.equalsIgnoreCase("dolares")) {
                                Dolar monedacomparar = new Dolar(Float.parseFloat(cantidad2));
                                bw.write(monedabase.comparar(monedacomparar)+"\n");
                            }else{
                                bw.write("Error, moneda a comparar no reconocida \n");
                            }
                        }else {
                            bw.write("Error, moneda base no reconocida +\n");
                        }
                    }else {
                        bw.write("Error, la cantidad y moneda a comparar estan vacios \n");
                    }
                }else{
                    bw.write("Error, operacion no reconocida \n");
                }
            }
            bw.close();
        }catch (Exception e){
            System.out.println("Problemas al leer el archivo \n "+e);
        }
    }
}
