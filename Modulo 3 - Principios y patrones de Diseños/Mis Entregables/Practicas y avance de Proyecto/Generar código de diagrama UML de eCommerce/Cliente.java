import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 ** @Producto: {{Clase Cliente}}
 ** @author: {{Noyola Nazario Alejandro}}
 ** @Fecha: {{20 de Junio 2024}}
 ***/
public class Cliente {
    private String nombre;
    private String email;
    private String password;

    // Lista para almacenar los clientes registrados
    private static List<Cliente> personas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Constructor
    public Cliente(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Método para registrar un nuevo cliente
    public static void registrar(Cliente cliente) {
        personas.add(cliente);
        System.out.println("Registro exitoso");
    }

    // Método para iniciar sesión
    public static void login() {
        System.out.print("Ingresa tu email: ");
        String email = scanner.nextLine();
        System.out.print("Ingresa tu contraseña: ");
        String password = scanner.nextLine();

        boolean encontrado = false;
        for (Cliente cliente : personas) {
            if (cliente.getEmail().equals(email) && cliente.getPassword().equals(password)) {
                System.out.println("Login exitoso. Bienvenido, " + cliente.getNombre() + "!");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Email o contraseña incorrectos.");
        }
    }
}
