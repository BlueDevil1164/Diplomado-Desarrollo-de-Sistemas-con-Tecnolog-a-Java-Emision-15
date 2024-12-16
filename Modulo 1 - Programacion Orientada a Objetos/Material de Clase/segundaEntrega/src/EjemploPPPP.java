import recursoshumanos.Empleado;   // Para hacer uso de Empleado que está en otro paquete
public class EjemploPPPP {
    public static void main(String[] args) {
        // Uso de paquetes y de miembros públicos, privados y protegidos
        Empleado objeto1 = new Empleado();
        objeto1.nombre = "Eligio";  // nombre es público
        /// objeto1.genero = 'M';  // genero es privado
        /// objeto1.sueldo = 111;  // sueldo es protegido

    }
}
