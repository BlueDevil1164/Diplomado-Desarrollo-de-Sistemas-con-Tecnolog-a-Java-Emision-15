package com.dgtic.dstj15.isp.impresora;

public interface Impresora {
    void imprimir(Documento documento);
    void escanear(Documento documento);
    void enviarFax(Documento documento);
}