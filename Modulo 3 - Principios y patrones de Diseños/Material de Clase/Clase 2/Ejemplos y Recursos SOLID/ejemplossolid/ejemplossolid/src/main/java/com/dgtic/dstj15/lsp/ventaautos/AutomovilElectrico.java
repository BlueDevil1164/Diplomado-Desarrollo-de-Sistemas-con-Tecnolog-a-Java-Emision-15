package com.dgtic.dstj15.lsp.ventaautos;

import javax.management.RuntimeErrorException;

public class AutomovilElectrico extends Automovil {

    public AutomovilElectrico(String nombre, double precio, int kilometraje, String marca, String modelo) {
        super(nombre, precio, kilometraje, marca, modelo);
    }

    @Override
    public void apagar() {
        super.apagar();
    }

    @Override
    public void cargarGasolina(double lts) {
        try {
            throw new RuntimeErrorException(null, "No se puede cargar gasolina en un automovil electrico");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void encender() {
        super.encender();
    }

    

    
}
