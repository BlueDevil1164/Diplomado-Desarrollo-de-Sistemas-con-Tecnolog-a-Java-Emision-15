package com.dgtic.dstj15.ocp.pintor;

import java.util.Collection;

public class Pintor {

    void pinta(Collection<Figura> figuras) {
        for (Figura figura : figuras) {
            if (figura instanceof Cuadrado)
                pinta((Cuadrado) figura);
            else if (figura instanceof Circulo)
                pinta((Circulo) figura);
        }
    }

    void pinta(Cuadrado cuadrado) {
        // ...
    }

    void pinta(Circulo circulo) { // ...
    }
}