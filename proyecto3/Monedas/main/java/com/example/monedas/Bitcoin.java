package com.example.monedas;

public class Bitcoin extends Moneda {

    public Bitcoin(float cantidad){
        super(cantidad);
        tasa_dolares = 66301;
    }
    @Override
    public String en(String moneda) {
        if (moneda.equalsIgnoreCase(":bolivares")){
            return (cantidad*tasa_dolares*36)+" Bs";
        } else if (moneda.equalsIgnoreCase(":yens")) {
            return (cantidad*9877690)+" ¥";
        } else if (moneda.equalsIgnoreCase(":euros")) {
            return (cantidad*60687)+" €";
        } else if (moneda.equalsIgnoreCase(":Dolares")) {
            return (cantidad*tasa_dolares)+" $";
        } else if (moneda.equalsIgnoreCase(":bitcoins")) {
            return cantidad+" Bitcoins";
        }
        return "Error, moneda a convertir no reconocida \n";

    }

}
