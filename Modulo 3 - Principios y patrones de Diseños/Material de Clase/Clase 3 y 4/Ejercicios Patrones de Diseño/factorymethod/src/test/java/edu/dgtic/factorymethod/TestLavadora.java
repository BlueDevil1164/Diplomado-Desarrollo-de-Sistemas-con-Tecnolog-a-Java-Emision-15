package edu.dgtic.factorymethod;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TestLavadora {
	@Test
	public void test_carga_frontal() {
		Lavadora lavadora = new LavadoraCargaFrontal();
		lavadora.ponerMandos();
		lavadora.ponerTambor();
		assertEquals("frontal", lavadora.tipoCarga);
		assertTrue(lavadora.tieneMandos);
		assertTrue(lavadora.tieneTambor);
	}
	@Test
	public void test_carga_superior() {
		Lavadora lavadora = new LavadoraCargaSuperior();
		lavadora.ponerMandos();
		lavadora.ponerTambor();
		assertEquals("superior", lavadora.tipoCarga);
		assertTrue(lavadora.tieneMandos);
		assertTrue(lavadora.tieneTambor);
	}
}
