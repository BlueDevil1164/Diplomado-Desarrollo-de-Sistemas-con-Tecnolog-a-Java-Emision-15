package edu.dgtic.factorymethod;

public abstract class Lavadora {
	public boolean tieneTambor;
	public boolean tieneMandos;
	public String  tipoCarga;
	public void ponerTambor() {
		tieneTambor = true;
	}
	public void ponerMandos() {
		tieneMandos = true;
	}
}
