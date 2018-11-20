package com.example.mattheusbrito.pibiti.mock;

import java.io.Serializable;
import java.util.ArrayList;

public class Mock implements Serializable {
    public static final ArrayList<Mock> mocker = new ArrayList<>();

    private String indicador1;
    private String indicador2;
    private String indicador3;
    private String indicador4;
    private String indicador5;
    private String indicador6;


    public Mock (){

    }

    public Mock(String indicador1, String indicador2, String indicador3, String indicador4, String indicador5, String indicador6){
        this.indicador1 = indicador1;
        this.indicador2 = indicador2;
        this.indicador3 = indicador3;
        this.indicador4 = indicador4;
        this.indicador5 = indicador5;
        this.indicador6 = indicador6;
    }

    public void addRelease(String indicador1, String indicador2, String indicador3, String indicador4, String indicador5, String indicador6){

        Mock aux = new Mock(indicador1, indicador2, indicador3, indicador4, indicador5, indicador6);

        mocker.add(aux);
    }


}
