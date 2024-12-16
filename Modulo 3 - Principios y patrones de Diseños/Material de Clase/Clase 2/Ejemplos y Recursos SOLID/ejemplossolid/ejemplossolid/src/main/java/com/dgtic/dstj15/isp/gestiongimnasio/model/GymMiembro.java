package com.dgtic.dstj15.isp.gestiongimnasio.model;

public interface GymMiembro {
    void reservarClase(String clase);
    void consultarPlanEntrenamiento();
    void pagarMembresia(double monto);
    void brindarPlanEntrenamiento();
    
}
