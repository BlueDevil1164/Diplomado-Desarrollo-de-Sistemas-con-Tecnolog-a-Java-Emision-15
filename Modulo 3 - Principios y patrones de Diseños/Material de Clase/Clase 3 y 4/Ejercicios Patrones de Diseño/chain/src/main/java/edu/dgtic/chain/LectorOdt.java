package edu.dgtic.chain;

public class LectorOdt implements LectorDocumentos {
	@Override
	public String contenido(Documento documento) {
		return "odt " + documento.getContenido();
	}
}
