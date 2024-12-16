package com.dgtic.dstj15.srp.automovil.service;

import java.util.List;

import com.dgtic.dstj15.srp.automovil.entity.Automovil;

public class AutomovilServiceImpl implements AutomovilService {

    private List<Automovil> automoviles;
    
    public AutomovilServiceImpl() {
        this.automoviles = List.of(
            new Automovil("Tesla"),
            new Automovil("Jeep"),
            new Automovil("Mazda"));
    }

    @Override
    public void arrancarMotor(Automovil automovil) {
        System.out.println("Arrancado!");
        enviarNotificacion("Automovil arrancado!");
    }

    @Override
    public void acelerar(Automovil automovil) {
        System.out.println("Acelerando!! Run run!");

    }

    @Override
    public void frenar(Automovil automovil) {
        System.out.println("Automovil frenado");
        enviarNotificacion("Frenando automovil!");
    }

    @Override
    public void mostrarInformacion(Automovil automovil) {
        System.out.println(this.cargarAutoBD(automovil.getMarca()).toString());
    }

    public void enviarNotificacion(String datos){
        System.out.println("Enviando notificación: " + datos);
    }

    public void guardarAutomovilBD(Automovil auto) {
        this.automoviles.add(auto);
    }

    public Automovil cargarAutoBD(String marca) {
        return this.automoviles.stream().filter(auto -> auto.getMarca().equals(marca)).findFirst()
                .orElseThrow(NullPointerException::new);
    }

    

}
