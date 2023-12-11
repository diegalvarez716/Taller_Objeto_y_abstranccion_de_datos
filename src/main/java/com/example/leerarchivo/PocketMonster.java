package com.example.leerarchivo;

public class PocketMonster {
    String type, name;
    PocketMonster siguiente;

    public PocketMonster(String type, String name) {
        this.type = type;
        this.name = name;
        siguiente = null;
    }
}
