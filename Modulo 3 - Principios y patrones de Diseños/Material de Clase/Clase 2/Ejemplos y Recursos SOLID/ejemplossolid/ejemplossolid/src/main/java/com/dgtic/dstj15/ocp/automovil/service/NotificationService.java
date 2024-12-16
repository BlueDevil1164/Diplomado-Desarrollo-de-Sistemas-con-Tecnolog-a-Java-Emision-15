package com.dgtic.dstj15.ocp.automovil.service;

public class NotificationService {

    private String tipoNotificacion;

    public NotificationService() {
    }

    public NotificationService(String tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }
    public void enviarNotificacion(String datos){
        switch (tipoNotificacion) {
            case "EMAIL":
                System.out.println("Enviando notificación por email");
                break;
            case "SMS":
                System.out.println("Enviando notificación por SMS");
                break;
            default:
                break;
        }
    }
}
