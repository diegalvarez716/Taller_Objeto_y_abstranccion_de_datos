package com.example.monedas;

public abstract class Moneda {
    float cantidad; float tasa_dolares;
    public Moneda(float cantidad){
        this.cantidad = cantidad;
    }
    public abstract String en (String moneda);
    public String comparar(Moneda moneda) {
        if ((cantidad*tasa_dolares)>(moneda.cantidad * moneda.tasa_dolares))return "mayor";
        else if ((cantidad*tasa_dolares)==(moneda.cantidad * moneda.tasa_dolares)) return "igual";
        return "menor";
    }
}
