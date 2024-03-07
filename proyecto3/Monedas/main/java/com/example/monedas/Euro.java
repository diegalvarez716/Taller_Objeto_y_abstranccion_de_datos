package com.example.monedas;

public class Euro extends Moneda{


    public Euro(float cantidad){
        super(cantidad);
        tasa_dolares = 1.09F;
    }
    @Override
    public String en(String moneda) {
        if (moneda.equalsIgnoreCase(":bolivares")){
            return (cantidad*39)+" Bs";
        } else if (moneda.equalsIgnoreCase(":yens")) {
            return (cantidad*162)+" ¥";
        } else if (moneda.equalsIgnoreCase(":Bitcoins")) {
            return (cantidad*0.000016)+ " Bitcoins";
        } else if (moneda.equalsIgnoreCase(":Dolares")) {
            return (cantidad*tasa_dolares)+" $";
        } else if (moneda.equalsIgnoreCase(":euros")) {
            return cantidad+" €";
        }
        return "Error, moneda a convertir no reconocida \n";
    }

}
