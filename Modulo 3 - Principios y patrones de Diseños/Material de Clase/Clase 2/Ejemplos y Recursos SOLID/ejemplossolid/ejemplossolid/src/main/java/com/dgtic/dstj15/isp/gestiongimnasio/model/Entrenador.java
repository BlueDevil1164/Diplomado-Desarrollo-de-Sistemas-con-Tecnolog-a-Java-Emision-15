package com.dgtic.dstj15.isp.gestiongimnasio.model;

public class Entrenador implements GymMiembro {

    @Override
    public void brindarPlanEntrenamiento() {
        System.out.println("Escribiendo plan entrenamiento");
        
    }

    @Override
    public void consultarPlanEntrenamiento() {
        System.out.println("Consultando plan de entrenamiento");
        
    }

    @Override
    public void pagarMembresia(double monto) {
        throw new UnsupportedOperationException("Los entrenadores son empleados");
        
    }

    @Override
    public void reservarClase(String clase) {
        throw new UnsupportedOperationException("Los entrenadores ya tienen su clase reservada al principio");
        
    } 

}
