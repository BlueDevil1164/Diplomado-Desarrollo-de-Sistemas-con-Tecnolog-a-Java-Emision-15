package edu.dgtic.chain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;

public class TestLectorDocumentos {
    @Test
    public void test() {
        List<Documento> lista = Arrays.asList(
                new Documento("doc", "documento doc"),
                new Documento("pdf", "documento pdf"),
                new Documento("odt", "documento odt")
        );
        String resultado = new ProcesadorDocumentos().concatena(lista);
        String esperado = "doc documento doc\n" +
                "pdf documento pdf\n" +
                "odt documento odt\n";
        assertEquals(esperado, resultado);
    }
}
