package com.example.monedas;

public class Bolivar extends Moneda{

    public Bolivar(float cantidad){
        super(cantidad);
        tasa_dolares= 0.027F;
    }
    @Override
    public String en(String moneda) {
        if (moneda.equalsIgnoreCase(":euros")){
            return (cantidad*0.025)+"€";
        } else if (moneda.equalsIgnoreCase(":yens")) {
            return (cantidad*tasa_dolares*149.34) + "¥";
        } else if (moneda.equalsIgnoreCase(":Bitcoins")) {
            return (cantidad*tasa_dolares*0.000015) + " Bitcoins";
        } else if (moneda.equalsIgnoreCase(":Dolares")) {
            return (cantidad*tasa_dolares)+" $";
        } else if (moneda.equalsIgnoreCase(":bolivares")) {
            return cantidad+" Bs";
        }
        return "Error, moneda a convertir no reconocida \n";
    }

}
