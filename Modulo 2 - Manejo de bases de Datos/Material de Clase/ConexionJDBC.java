import java.sql.*;

public class ConexionJDBC {
    public static void ejecutaSelect (){
        System.out.println("Ejemplo de conectividad de Java con MariaDB");
        String servidor="127.0.0.1", baseDD="sistema";
        String usuario="root", contrasena="sqlMD3";

        String cadenaDeConexion = "jdbc:mariadb://"+servidor+"/"+baseDD;
        try {
            // 1. Establecer la conexión
            Connection conexion;
            conexion = DriverManager.getConnection(cadenaDeConexion, usuario, contrasena);
            System.out.println("Conexión establecida...");

            // 2. Ejecutar el comando
            String comando = "SELECT * FROM roles";

            Statement instruccion;
            ResultSet registros;  // COntendrá el resultado de ejecutar el comando

            instruccion=conexion.createStatement();  // Asocia el comando con la conexión
            registros = instruccion.executeQuery (comando);
            System.out.println("SELECT ejecutado: ");

            // 3. Ver resultados
            System.out.println("Registros modificados: "+ instruccion.getUpdateCount());
            while (registros.next()) {  // Recorre el resultado mientras haya datos
                System.out.print(registros.getInt("idRol") + "\t");  // Extracción por nombre
                System.out.println(registros.getString(2));       // Extracción por posición
            }


            // 4. Cerrar todo
            instruccion.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Algo sucedió al operar con la base de datos: "+e.getErrorCode());
            System.out.println(e.getSQLState());
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        System.out.println("Ejemplo de conectividad de Java con MariaDB");
        System.out.println("ANTES del INSERT");
        ejecutaSelect();


        String servidor="127.0.0.1", baseDD="sistema";
        String usuario="root", contrasena="sqlMD3";

        String cadenaDeConexion = "jdbc:mariadb://"+servidor+"/"+baseDD;
        try {
            // 1. Establecer la conexión
            Connection conexion;
            conexion = DriverManager.getConnection(cadenaDeConexion, usuario, contrasena);
            System.out.println("Conexión establecida...");

            // 2. Ejecutar el comando
            String comando = "INSERT INTO roles VALUES (10, 'Otro rol más');";
            //comando = "DELETE FROM roles WHERE idRol >=8";

            Statement instruccion;
            instruccion=conexion.createStatement();  // Asocia el comando con la conexión
            instruccion.executeQuery (comando);
            System.out.println("Comando ejecutado: ");

            // 3. Ver resultados
            System.out.println("Registros modificados: "+ instruccion.getUpdateCount());


            // 4. Cerrar todo
            instruccion.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Algo sucedió al operar con la base de datos: "+e.getErrorCode());
            System.out.println(e.getSQLState());
            System.out.println(e);
        }
        System.out.println("DESPUÉS del INSERT");
        ejecutaSelect();
    }

}
