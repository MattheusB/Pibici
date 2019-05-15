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

    public Release(String nomeIndicador, int valorRetrabalho, int valorDescarte, int valorSobrepeso) {
        this.indicador1 = nomeIndicador;
        this.indicador2 = valorRetrabalho;
        this.indicador3 = valorDescarte;
        this.indicador4 = valorSobrepeso;

    }

    public Release(String nomeIndicador, int valorEmbalagemPerdida, int valorProdutosAcabados) {
        this.indicador1 = nomeIndicador;
        this.indicador2 = valorEmbalagemPerdida;
        this.indicador3 = valorProdutosAcabados;
    }

    public Release(String nomeIndicador, int valorProducaoEmbalada) {
        this.indicador1 = nomeIndicador;
        this.indicador2 = valorProducaoEmbalada;
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

    public String getIndicador1() {
        return indicador1;
    }

    public void setIndicador1(String indicador1) {
        this.indicador1 = indicador1;
    }

    public Integer getIndicador2() {
        return indicador2;
    }

    public void setIndicador2(Integer indicador2) {
        this.indicador2 = indicador2;
    }

    public Integer getIndicador3() {
        return indicador3;
    }

    public void setIndicador3(Integer indicador3) {
        this.indicador3 = indicador3;
    }

    public Integer getIndicador4() {
        return indicador4;
    }

    public void setIndicador4(Integer indicador4) {
        this.indicador4 = indicador4;
    }

    public Integer getIndicador5() {
        return indicador5;
    }

    public void setIndicador5(Integer indicador5) {
        this.indicador5 = indicador5;
    }
}