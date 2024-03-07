package com.example.monedas;


public class Dolar extends Moneda{

    public Dolar(Float cantidad){
        super(cantidad);
        tasa_dolares =1;
    }
    @Override
    public String en(String moneda) {


        if (moneda.equalsIgnoreCase(":bolivares")){
            return (cantidad*36)+" Bs";
        } else if (moneda.equalsIgnoreCase(":yens")) {
            return (cantidad*149)+" ¥";
        } else if (moneda.equalsIgnoreCase(":Bitcoins")) {
            return (cantidad*0.000015)+" Bitcoins";
        } else if (moneda.equalsIgnoreCase(":Euros")) {
            return  (cantidad*0.92)+" €";
        } else if (moneda.equalsIgnoreCase(":dolares")) {
            return cantidad+" $";
        }
        return "Error, moneda a convertir no reconocida \n";
    }

}
