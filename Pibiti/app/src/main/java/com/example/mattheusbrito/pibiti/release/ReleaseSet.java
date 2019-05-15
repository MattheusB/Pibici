package com.example.mattheusbrito.pibiti.release;

import java.util.ArrayList;
import java.util.List;

public class ReleaseSet {

    List<Release> lancamentos = new ArrayList<>();

    public List<Release> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Release> lancamentos) {
        this.lancamentos = lancamentos;
    }
}
