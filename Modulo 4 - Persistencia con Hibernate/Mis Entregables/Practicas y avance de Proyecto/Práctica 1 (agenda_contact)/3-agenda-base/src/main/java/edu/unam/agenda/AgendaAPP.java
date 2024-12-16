package edu.unam.agenda;

import edu.unam.agenda.hibernate.HibernateUtil;
import edu.unam.agenda.model.ContactType;
import edu.unam.agenda.model.PhoneType;
import edu.unam.agenda.service.MeansContactsService;
import edu.unam.agenda.service.ContactService;
import edu.unam.agenda.service.PhoneTypeService;
import edu.unam.agenda.service.ContactTypeService;
import edu.unam.agenda.service.impl.MeansContactsServiceImpl;
import edu.unam.agenda.service.impl.ContactServiceImpl;
import edu.unam.agenda.service.impl.PhoneTypeServiceImpl;
import edu.unam.agenda.service.impl.ContactTypeServiceImpl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class AgendaAPP {
	private Scanner sn;
	private final PhoneTypeService phoneTypeService = PhoneTypeServiceImpl.getInstance();
	private final ContactTypeService contactTypeService = ContactTypeServiceImpl.getInstance();
	private final ContactService contactService = ContactServiceImpl.getInstance();
	private final MeansContactsService meansContactsService = MeansContactsServiceImpl.getInstance();

	public static void main(String[] args) {
		HibernateUtil.init(); 
		AgendaAPP catalogosAPP = new AgendaAPP();
		catalogosAPP.cargaMenu();
	}

	public void cargaMenu() {
		boolean salir = false;
		int opcion; //Guardaremos la opcion del usuario
		do {
			System.out.println("1. Telefonos");
			System.out.println("2. Contactos");
			System.out.println("3. Salir");
			try {
				sn = new Scanner(System.in);
				System.out.println("Escribe una de las opciones");
				opcion = sn.nextInt();
				sn.nextLine();//limpieza
				switch (opcion) {
					case 1:
						System.out.println("-- Entrando menú Telefonos --");
						cargaMenuCatalogos();
						break;
					case 2:
						System.out.println("-- Entrando Contactos --");
						cargaMenuContactos();
						break;
					case 3:
						salir = true;
						break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes insertar un número");
				sn.next();
			}
		}
		while (!salir) ;
	}

	public void cargaMenuContactos() {

		boolean salir = false;
		int opcion; //Guardaremos la opcion del usuario
		do {
			System.out.println("1. Catalogo Tipo de contacto ");
			System.out.println("2. Catalogo tipo de telefono ");
			System.out.println("3. Salir");
			try {
				sn = new Scanner(System.in);
				System.out.println("Escribe una de las opciones");
				opcion = sn.nextInt();
				sn.nextLine();//limpieza
				switch (opcion) {
					case 1:
						System.out.println("-- Entrando menú tipo contacto --");
						cargaMenuCatalogoTipoContacto();
						break;
					case 2:
						System.out.println("-- Entrando menú tipo telefono --");
						cargaMenuCatalogoTipoTelefono();
						break;
					case 3:
						salir = true;
						break;
					default:
						System.out.println("Opción no existe");
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes insertar un número");
				sn.next();
			}
		}
		while (!salir) ;
	}

    public void cargaMenuCatalogos() {

		boolean salir = false;
		int opcion; //Guardaremos la opcion del usuario
		do {
			System.out.println("1. Catalogo tipo de contacto ");
			System.out.println("2. Catalogo tipo de telefono");
			System.out.println("3. Salir");
			try {
				sn = new Scanner(System.in);
				System.out.println("Escribe una de las opciones");
				opcion = sn.nextInt();
				sn.nextLine();//limpieza
				switch (opcion) {
					case 1:
						System.out.println("-- Entrando menú tipo contacto --");
						cargaMenuCatalogoTipoContacto();
						break;
					case 2:
						System.out.println("-- Entrando menú tipo telefono --");
						cargaMenuCatalogoTipoTelefono();
						break;
					case 3:
						salir = true;
						break;
					default:
						System.out.println("Opción no existe");
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes insertar un número");
				sn.next();
			}
		}
		while (!salir) ;
	}

	public void cargaMenuCatalogoTipoTelefono() {
		boolean salir = false;
		int opcion; // Guardaremos la opción del usuario
		do {
			System.out.println("1. Ver todos los tipos de teléfonos");
			System.out.println("2. Buscar por tipo de teléfono");
			System.out.println("3. Insertar tipo de teléfono");
			System.out.println("4. Actualizar tipo de teléfono");
			System.out.println("5. Eliminar tipo de teléfono");
			System.out.println("6. Salir");
			try {
				sn = new Scanner(System.in);
				System.out.println("Escribe una de las opciones");
				opcion = sn.nextInt();
				sn.nextLine(); // limpieza

				PhoneType phoneType = new PhoneType();
				Scanner snew = new Scanner(System.in);
				int id = 0;
				switch (opcion) {
					case 1:
						System.out.println("-- Entrando ver todos los Tipos de Teléfono --");
						//ToDo
						//Decalarar lista para obtener todos los tipos de telefonos
						List<PhoneType> listPhoneType = phoneTypeService.getAllPhoneTypes();
						//imprimir en consola
						for (PhoneType phone : listPhoneType)
							System.out.println(phone.toString());
						break;
					case 2:
						System.out.println("-- Entrando Buscar por tipo de Teléfono --");
						snew = new Scanner(System.in);
						System.out.println("Dame un id para buscar");
						id =snew.nextInt();
						phoneType = phoneTypeService.getPhoneTypeById(id);
						if (phoneType == null)
							System.out.println("El tipo de telefono no se encontro");
						System.out.println(phoneType);
						break;
					case 3:
						System.out.println("-- Insertar tipo de teléfono --");

						// ToDo
						// Crear el objeto vacío PhoneType
						//PhoneType phoneType = new PhoneType();
						// Pedir los datos al usuario.
						snew = new Scanner(System.in);
						System.out.println("Dame el nombre: ");
						String name = snew.nextLine();
						System.out.println("Dame el ESTATUS: ");
						String estatus = snew.nextLine();
						// Llenar el objeto
						phoneType.setName(name);
						phoneType.setStatus(estatus);
						// Insertar el objeto
						phoneTypeService.insertPhoneType(phoneType);
						// fin
						System.out.println("El objeto se inserto de forma correcta" + phoneType);
						break;
					case 4:
						System.out.println("-- Actualizar tipo de teléfono --");
						snew = new Scanner(System.in);
						System.out.println("Dame un Id para buscar");
						id = snew.nextInt();
						phoneType = phoneTypeService.getPhoneTypeById(id);
						if (phoneType == null)
							System.out.println("El tipo de telefono no se encontro");
						else {
							snew = new Scanner(System.in);
							System.out.println("Dame el nombre: ");
							String name2 = snew.nextLine();
							System.out.println("Dame el ESTATUS: ");
							String estatus2 = snew.nextLine();
							// Llenar el objeto
							phoneType.setName(name2);
							phoneType.setStatus(estatus2);
							// Insertar el objeto
							phoneTypeService.updatePhoneType(phoneType);
							System.out.println("El objeto actualizado es " + phoneType);

						}

						break;
					case 5:
						System.out.println("-- Eliminar tipo de teléfono --");
						snew = new Scanner(System.in);
						System.out.println("Dame un Id para buscar");
						id = snew.nextInt();
						phoneType = phoneTypeService.getPhoneTypeById(id);
						if (phoneType == null)
							System.out.println("El registro no existe");
						else
							phoneTypeService.deletePhoneType(phoneType);
						break;
					case 6:
						salir = true;
						break;
					default:
						System.out.println("Opción no existe");
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes insertar un número");
				sn.next();
			}
		} while (!salir);
	}


	public void cargaMenuCatalogoTipoContacto() {
		boolean salir = false;
		int opcion; // Guardaremos la opción del usuario
		do {
			System.out.println("1. Ver todos los tipos de contacto");
			System.out.println("2. Buscar por tipo de contacto");
			System.out.println("3. Insertar tipo de contacto");
			System.out.println("4. Actualizar tipo de contacto");
			System.out.println("5. Eliminar tipo de contacto");
			System.out.println("6. Salir");
			try {
				sn = new Scanner(System.in);
				System.out.println("Escribe una de las opciones");
				opcion = sn.nextInt();
				sn.nextLine(); // limpieza

				ContactType contactType = new ContactType();
				Scanner snew = new Scanner(System.in);
				int id = 0;
				switch (opcion) {
					case 1:
						System.out.println("-- Entrando ver todos los Tipos de Contacto --");
						//ToDo
						//Decalarar lista para obtener todos los tipos de telefonos
						List<ContactType> listContactType = contactTypeService.getAllContactType();
						//imprimir en consola
						for (ContactType contact : listContactType)
							System.out.println(contact.toString());
						break;
					case 2:
						System.out.println("-- Entrando Buscar por tipo de Contacto --");
						snew = new Scanner(System.in);
						System.out.println("Dame un id para buscar");
						id =snew.nextInt();
						contactType = contactTypeService.getContactTypeById(id);
						if (contactType == null)
							System.out.println("El tipo de contacto no se encontro");
						System.out.println(contactType);
						break;
					case 3:
						System.out.println("-- Insertar tipo de contacto --");

						// ToDo
						// Crear el objeto vacío PhoneType
						//PhoneType phoneType = new PhoneType();
						// Pedir los datos al usuario.
						snew = new Scanner(System.in);
						System.out.println("Dame el nombre: ");
						String name = snew.nextLine();
						System.out.println("Dame el ESTATUS: ");
						String estatus = snew.nextLine();
						// Llenar el objeto
						contactType.setName(name);
						contactType.setStatus(estatus);
						// Insertar el objeto
						contactTypeService.insertContactType(contactType);
						// fin
						System.out.println("El objeto se inserto de forma correcta" + contactType);
						break;
					case 4:
						System.out.println("-- Actualizar tipo de contacto --");
						snew = new Scanner(System.in);
						System.out.println("Dame un Id para buscar");
						id = snew.nextInt();
						contactType = contactTypeService.getContactTypeById(id);
						if (contactType == null)
							System.out.println("El tipo de contacto no se encontro");
						else {
							snew = new Scanner(System.in);
							System.out.println("Dame el nombre: ");
							String name2 = snew.nextLine();
							System.out.println("Dame el ESTATUS: ");
							String estatus2 = snew.nextLine();
							// Llenar el objeto
							contactType.setName(name2);
							contactType.setStatus(estatus2);
							// Insertar el objeto
							contactTypeService.updateContactType(contactType);
							System.out.println("El objeto actualizado es " + contactType);

						}

						break;
					case 5:
						System.out.println("-- Eliminar tipo de contacto --");
						snew = new Scanner(System.in);
						System.out.println("Dame un Id para buscar");
						id = snew.nextInt();
						contactType = contactTypeService.getContactTypeById(id);
						if (contactType == null)
							System.out.println("El registro no existe");
						else
							contactTypeService.deleteContactType(contactType);
						break;
					case 6:
						salir = true;
						break;
					default:
						System.out.println("Opción no existe");
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes insertar un número");
				sn.next();
			}
		} while (!salir);
	}



}
