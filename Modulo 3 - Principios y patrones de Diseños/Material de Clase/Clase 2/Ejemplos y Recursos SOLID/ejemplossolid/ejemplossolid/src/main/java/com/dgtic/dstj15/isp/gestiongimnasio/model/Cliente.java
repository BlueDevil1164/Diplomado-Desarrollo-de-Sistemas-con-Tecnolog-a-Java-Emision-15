package com.dgtic.dstj15.isp.gestiongimnasio.model;

public class Cliente implements GymMiembro
{
    @Override
    public void brindarPlanEntrenamiento() {
       throw new UnsupportedOperationException("Los clientes no pueden entrenar a otras personas.");
        
    }

    @Override
    public void consultarPlanEntrenamiento() {
        System.out.println("Plan de entrenamiento ....");
        
    }

    @Override
    public void pagarMembresia(double monto) {
        System.out.println("Pagando membresia....");
        
    }

    @Override
    public void reservarClase(String clase) {
        System.out.println("Se reservo la clase "+clase);
        
    } 

    
}
