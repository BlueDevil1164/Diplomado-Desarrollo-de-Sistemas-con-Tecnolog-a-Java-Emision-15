package com.dgtic.dstj15.lsp.ventaautos;

public class PuntoVenta {
    public void pruebaAuto(Automovil auto){
        auto.encender();
        auto.apagar();
        auto.cargarGasolina(10.0);
        auto.cargarGasolina(20.0);
        auto.cargarGasolina(30.0);
        auto.cargarGasolina(40.0);
    }
}
