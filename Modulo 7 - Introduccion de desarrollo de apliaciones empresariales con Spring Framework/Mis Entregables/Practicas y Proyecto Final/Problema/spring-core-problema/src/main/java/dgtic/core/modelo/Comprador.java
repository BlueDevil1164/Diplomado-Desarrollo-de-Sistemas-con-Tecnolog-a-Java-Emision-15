package dgtic.core.modelo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Data
public class Comprador {

    private String matricula;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String correo;
    private String password;

    public Comprador(String matricula, String nombre, String apellido, Integer edad, String correo, String password) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.password = password;
    }

    private List<Electronico> electronicos = new ArrayList<>();



    public void setElectronico(Electronico ... electronicos){
        this.electronicos.addAll(Arrays.asList(electronicos));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comprador that)) return false;
        return Objects.equals(matricula, that.matricula)
                && Objects.equals(nombre, that.nombre)
                && Objects.equals(edad, that.edad)
                && Objects.equals(correo, that.correo)
                && Objects.equals(password, that.password);

    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, nombre, edad, correo, password);
    }
}

