package com.example.mattheusbrito.pibiti.record;

public class Release {

    public Integer indicador1;
    public Integer indicador2;
    public Integer indicador3;
    public Integer indicador4;


    @Override
    public String toString() {
        return indicador1.toString().concat(indicador2.toString());
    }
}