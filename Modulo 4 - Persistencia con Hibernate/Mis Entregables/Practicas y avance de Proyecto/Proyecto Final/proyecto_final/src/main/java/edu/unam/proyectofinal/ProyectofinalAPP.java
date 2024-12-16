package edu.unam.proyectofinal;

import edu.unam.proyectofinal.hibernate.HibernateUtil;
import edu.unam.proyectofinal.model.*;
import edu.unam.proyectofinal.service.*;
import edu.unam.proyectofinal.service.impl.*;

import java.util.*;

public class ProyectofinalAPP {
    private Scanner sn;
    private final LaptopService laptopService = LaptopServiceImpl.getInstance();
    private final MeansLaptopsService meansLaptopsService = MeansLaptopsServiceImpl.getInstance();
    private final CatalogService catalogService = CatalogServiceImpl.getInstance();

    public static void main(String[] args) {
        HibernateUtil.init();
        ProyectofinalAPP laptopsAPP = new ProyectofinalAPP();
        laptopsAPP.cargaMenu();
    }

    public void cargaMenu() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do {
            System.out.println("1. Catalogos");
            System.out.println("2. Laptop");
            System.out.println("3. Salir");
            try {
                sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando menú Laptop --");
                        cargaMenuCatalogos();
                        break;
                    case 2:
                        System.out.println("-- Entrando Laptop --");
                        cargaMenuLaptop();
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
            System.out.println("1. Medio Laptop");
            System.out.println("2. Tipo Laptop");
            System.out.println("3. Salir");
            try {
                sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando Catálogo Medio Laptop --");
                        cargaMenuMedioLaptop();
                        break;
                    case 2:
                        System.out.println("-- Entrando Catálogo Tipo Laptop --");
                        cargaMenuTipoLaptop();
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
        while (!salir);
    }

    public void cargaMenuMedioLaptop() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do {
            System.out.println("1. Ver Medio Laptop por ID");
            System.out.println("2. Ver Medios Laptop");
            System.out.println("3. Insertar Medio Laptop");
            System.out.println("4. Actualizar Medio Laptop");
            System.out.println("5. Eliminar Medio Laptop");
            System.out.println("6. Salir");
            try {
                sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando Ver Medio Laptop por ID --");
                        consultaMedioLaptopRegistrosPorId();
                        break;
                    case 2:
                        System.out.println("-- Entrando Ver Todos Medios Laptop --");
                        consultaMedioLaptopRegistros();
                        break;
                    case 3:
                        System.out.println("-- Entrando Crea Medio Laptop --");
                        insertaMedioLaptopRegistros();
                        break;
                    case 4:
                        System.out.println("-- Entrando Actualiza Medio Laptop --");
                        actualizaMedioLaptopRegistros();
                        break;
                    case 5:
                        System.out.println("-- Entrando Elimina Medio Laptop --");
                        eliminaMedioLaptopRegistros();
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
        }
        while (!salir);
    }

    public void cargaMenuTipoLaptop() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do {
            System.out.println("1. Ver Tipo Laptop por ID");
            System.out.println("2. Ver Tipos Laptop");
            System.out.println("3. Insertar Tipo Laptop");
            System.out.println("4. Actualizar Tipo Laptop");
            System.out.println("5. Eliminar Tipo Laptop");
            System.out.println("6. Salir");
            try {
                sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando Ver Medio Laptop por ID --");
                        consultaTipoLaptopRegistrosPorId();
                        break;
                    case 2:
                        System.out.println("-- Entrando Ver Todos Medios Laptops --");
                        consultaTipoLaptopRegistros();
                        break;
                    case 3:
                        System.out.println("-- Entrando Crea Medio Laptop --");
                        insertaTipoLaptopRegistros();
                        break;
                    case 4:
                        System.out.println("-- Entrando Actualiza Medio Laptop --");
                        actualizaTipoLaptopRegistros();
                        break;
                    case 5:
                        System.out.println("-- Entrando Elimina Medio Laptop --");
                        eliminaTipoLaptopRegistros();
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
        }
        while (!salir);
    }

    public void cargaMenuLaptop() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do {
            System.out.println("1. Ver Laptop por ID");
            System.out.println("2. Ver Laptops");
            System.out.println("3. Insertar Laptop");
            System.out.println("4. Actualizar Laptop");
            System.out.println("5. Eliminar Laptop");
            System.out.println("6. Salir");
            try {
                sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando Ver Laptop por ID --");
                        consultaLaptopRegistrosPorId();
                        break;
                    case 2:
                        System.out.println("-- Entrando Ver Todas las Laptop --");
                        consultaLaptopRegistros();
                        break;
                    case 3:
                        System.out.println("-- Entrando Crea Laptop --");
                        insertaLaptopRegistros();
                        break;
                    case 4:
                        System.out.println("-- Entrando Actualiza Laptop --");
                        actualizaLaptopRegistros();
                        break;
                    case 5:
                        System.out.println("-- Entrando Elimina Laptop --");
                        eliminaLaptopRegistros();
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
        }
        while (!salir);
    }

    public void consultaMedioLaptopRegistros() {
        for (CatalogLaptops medioLaptop: catalogService.getAllCatalogLaptops()) {
            System.out.println("Medio Laptop:" + medioLaptop.toString());
        }
    }

    public void consultaMedioLaptopRegistrosPorId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dame el id a buscar:");
        int busca = scanner.nextInt();
        CatalogLaptops medioLaptop = catalogService.getCatalogLaptopsById(busca);
        if (medioLaptop != null)
            System.out.println("Medio Laptop:" + medioLaptop.toString());
        else
            System.out.println("Medio Laptop no encontrado");
    }

    public void insertaMedioLaptopRegistros() {
        System.out.println("TODO");
    }

    public void actualizaMedioLaptopRegistros() {
        System.out.println("TODO");
    }

    public void eliminaMedioLaptopRegistros() {
        System.out.println("TODO");
    }


    public void consultaTipoLaptopRegistros() {
        for (Catalog tipoLaptop : catalogService.getAllLaptopType()) {
            System.out.println("Medio Laptop:" + tipoLaptop.toString());
        }

    }

    public void consultaTipoLaptopRegistrosPorId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dame el id a buscar:");
        int busca = scanner.nextInt();
        Catalog tipoLaptop = catalogService.getLaptopTypeById(busca);
        if (tipoLaptop != null)
            System.out.println("Tipo Laptop:" + tipoLaptop.toString());
        else
            System.out.println("Tipo Laptop no encontrado");
    }

    public void insertaTipoLaptopRegistros() {

        System.out.println("TODO");
    }

    public void actualizaTipoLaptopRegistros() {
        System.out.println("TODO");
    }

    public void eliminaTipoLaptopRegistros() {
        System.out.println("TODO");
    }

    public void consultaLaptopRegistros() {
        for (Laptop laptop : laptopService.getAllLaptops()) {
            System.out.println("Laptop:" + laptop.toString());
        }
    }

    public void consultaLaptopRegistrosPorId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dame el id a buscar:");
        int busca = scanner.nextInt();
        Laptop laptop = laptopService.getLaptopById(busca);
        if (laptop != null)
            System.out.println("Laptop:" + laptop.toString());
        else
            System.out.println("Laptop no encontrado");
    }

    public void insertaLaptopRegistros() {
        Scanner scanner = new Scanner(System.in);
        Laptop nuevo = new Laptop();
        System.out.println("Dame modelo: ");
        nuevo.setModelo(scanner.nextLine());
        System.out.println("Dame Tamano de Pantalla: ");
        nuevo.setPantalla(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Dame Marca: ");
        nuevo.setMarca(scanner.nextLine());
        System.out.println("Dame Color: ");
        nuevo.setColor(scanner.nextLine());

        System.out.println("Dame Tamano Ram: ");
        nuevo.setRam(scanner.nextInt());
        System.out.println("Tipos de Laptops a elegir: ");
        consultaTipoLaptopRegistros();
        System.out.println("Dame ID Tipo Laptop: ");
        int busca = scanner.nextInt();
        scanner.nextLine();
        LaptopType tipoLaptop = catalogService.getLaptopTypeById(busca);
        if (tipoLaptop != null)
            nuevo.setLaptopType(tipoLaptop);
        else
            nuevo.setLaptopType(null);
        System.out.println("Medios de Laptops a elegir: ");
        consultaMedioLaptopRegistros();
        System.out.println("Dame ID Medio Laptops: ");
        busca = scanner.nextInt();
        scanner.nextLine();
        CatalogLaptops medio = catalogService.getCatalogLaptopsById(busca); //obtencion de laptop de medio laptop
        MeansLaptops laptopMedio = new MeansLaptops(); //creacion de laptop medio
        System.out.println("Dame el numero de Laptop: ");
        laptopMedio.setValue(scanner.nextLine()); //llenado de datos de laptop medio
        laptopMedio.setCatalogLaptops(medio); //relacionamos contacto medio con catalogo medio laptop
        laptopMedio.setLaptop(nuevo); // relacionamos con contacto
        Set<MeansLaptops> laptopsMedios = new HashSet<>(); //generamos la coleccion
        laptopsMedios.add(laptopMedio); //llenamos la coleccion
        nuevo.setMeansLaptops(laptopsMedios);
        if (laptopService.insertLaptop(nuevo))
            System.out.println("Insertado correctamente");
        else
            System.out.println("Error al insertar registro");
    }

    public void actualizaLaptopRegistros() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dame el id a actualizar:");
        int busca = scanner.nextInt();
        scanner.nextLine();//limpieza
        Laptop nuevo = laptopService.getLaptopById(busca);
        if (nuevo != null) {
            System.out.println("Dame modelo: ");
            nuevo.setModelo(scanner.nextLine());
            System.out.println("Dame Tamano de Pantalla: ");
            nuevo.setPantalla(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Dame Marca: ");
            nuevo.setMarca(scanner.nextLine());
            System.out.println("Dame Color: ");
            nuevo.setColor(scanner.nextLine());
            System.out.println("Dame Tamano Ram: ");
            nuevo.setRam(scanner.nextInt());
            System.out.println("Tipos de Laptops a elegir: ");
            consultaTipoLaptopRegistros();
            System.out.println("Dame ID Tipo Laptop: ");
            busca = scanner.nextInt();
            scanner.nextLine();
            LaptopType tipoLaptop = catalogService.getLaptopTypeById(busca);
            nuevo.setLaptopType(tipoLaptop);

            List<MeansLaptops> medios = meansLaptopsService.getMeansLaptopsByLaptop(nuevo.getId());
            for (MeansLaptops medio : medios) {
                meansLaptopsService.deleteMeansLaptops(medio);
            }
            //se procede a adjuntar uno nuevo
            System.out.println("Medios de Laptops a elegir: ");
            consultaMedioLaptopRegistros();
            System.out.println("Dame ID Medio Laptop: ");
            busca = scanner.nextInt();
            scanner.nextLine();
            CatalogLaptops medio = catalogService.getCatalogLaptopsById(busca); //obtencion de catalogo de medio laptop
            MeansLaptops laptopMedio = new MeansLaptops(); //creacion de contacto medio
            System.out.println("Dame el numero de Laptop: ");
            laptopMedio.setValue(scanner.nextLine()); //llenado de datos de laptop medio
            laptopMedio.setCatalogLaptops(medio); //relacionamos contacto medio con catalogo medio laptop
            laptopMedio.setLaptop(nuevo); // relacionamos con contacto
            Set<MeansLaptops> laptopsMedios = new HashSet<>(); //generamos la coleccion
            laptopsMedios.add(laptopMedio); //llenamos la coleccion
            nuevo.setMeansLaptops(laptopsMedios);
            if (laptopService.updateLaptop(nuevo))
                System.out.println("Insertado correctamente");
            else
                System.out.println("Error al insertar registro");
        } else
            System.out.println("Medio Laptop no encontrado");
    }

    public void eliminaLaptopRegistros() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dame el id a eliminar:");
        int busca = scanner.nextInt();
        scanner.nextLine();//limpieza
        Laptop laptop = laptopService.getLaptopById(busca);
        if (laptop != null) {
            System.out.println("Laptop:" + laptop.toString());
            //se hace forzado, puesto que cascade no funciona
            //List<MeansLaptops> medios = meansLaptopsService.getMeansLaptopsByLaptop(laptop.getId());
            MeansLaptops medios = meansLaptopsService.getMeansLaptopsById(laptop.getId());
            /*for (MeansLaptops medio : medios) {
                meansLaptopsService.deleteMeansLaptops(medio);
            }*/
            laptop.setMeansLaptops(null);// se elimina, sino, falla
            if (laptopService.deleteLaptop(laptop))
                System.out.println("Eliminado correctamente");
            else
                System.out.println("Error al eliminar registro");
        } else
            System.out.println("Laptop no encontrada");
    }
}