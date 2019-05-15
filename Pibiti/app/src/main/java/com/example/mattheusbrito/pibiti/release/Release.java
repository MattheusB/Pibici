package com.example.mattheusbrito.pibiti.release;


import java.util.Calendar;

public class Release {

    public String indicador1;
    public Integer indicador2;
    public Integer indicador3;
    public Integer indicador4;
    public Integer indicador5;

    public Release() {
        Calendar calendar = Calendar.getInstance();
        this.indicador5 = calendar.getTime().getHours();
    }


    @Override
    public boolean equals(Object o) {
        boolean result = true;

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Release release = (Release) o;
        if (indicador1 != null){
            result = indicador1.equals(release.indicador1);
        }
        if (indicador2 != null){
            result = result && indicador2.equals(release.indicador2);
        }
        if (indicador3 != null){
            result = result && indicador3.equals(release.indicador3);
        }
        if (indicador4 != null){
            result = result && indicador4.equals(release.indicador4);
        }
        if (indicador5 != null){
            result = result && indicador5.equals(release.indicador5);
        }
        return  result;
    }

}