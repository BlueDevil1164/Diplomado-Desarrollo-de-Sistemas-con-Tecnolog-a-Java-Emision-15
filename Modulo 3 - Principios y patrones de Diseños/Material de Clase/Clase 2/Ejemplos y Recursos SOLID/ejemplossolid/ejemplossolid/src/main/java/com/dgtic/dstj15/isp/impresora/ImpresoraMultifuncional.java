package com.dgtic.dstj15.isp.impresora;

public class ImpresoraMultifuncional implements Impresora {

    @Override
    public void imprimir(Documento documento) {
        System.out.println("Imprimiendo "+documento);
    }

    @Override
    public void escanear(Documento documento) {
        System.out.println("Escaneando "+documento);
    }

    @Override
    public void enviarFax(Documento documento) {
        throw new UnsupportedOperationException("La impresora no implementa fax :v");
    }
    
}
