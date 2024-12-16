package edu.dgtic.adapter;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class InternationMoneyTests {

	private InternationalMoneyOrganization servicio;
	
	@BeforeEach
	public void init() {
		// cambia este null por una referencia al adapter que has creado
		servicio = null;
	}
	
	@Test
	public void test_cliente_no_existe() {
		assertEquals(0,servicio.state("No_existo"));
	}

	@Test
	public void test_operaciones_con_nuevo_cliente() {
		String cliente = "nuevo";
		servicio.transfer(100, cliente);
		assertEquals(100, servicio.state(cliente));
		servicio.transfer(-70, cliente);
		assertEquals(30, servicio.state(cliente));
	}
}
