package com.example.monedas;

public class Yen extends Moneda{

    public Yen (float cantidad){
        super(cantidad);
        tasa_dolares = 0.0067F;
    }
    public String en(String moneda) {
        if (moneda.equalsIgnoreCase(":bolivares")){
            return (cantidad*tasa_dolares*36)+" Bs";
        } else if (moneda.equalsIgnoreCase(":Euros")) {
            return (cantidad*0.0061)+" €";
        } else if (moneda.equalsIgnoreCase(":Bitcoins")) {
            return  (cantidad*tasa_dolares*0.000015)+" Bitcoins";
        } else if (moneda.equalsIgnoreCase(":Dolares")) {
            return (cantidad*tasa_dolares)+" $";
        } else if (moneda.equalsIgnoreCase(":yens")) {
            return cantidad+" ¥";
        }
        return "Error, moneda a convertir no reconocida \n";
    }
}
