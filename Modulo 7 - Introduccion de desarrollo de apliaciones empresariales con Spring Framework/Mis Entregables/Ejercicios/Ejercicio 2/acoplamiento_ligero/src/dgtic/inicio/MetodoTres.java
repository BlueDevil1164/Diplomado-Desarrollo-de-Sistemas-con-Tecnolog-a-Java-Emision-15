package dgtic.inicio;

import dgtic.modelo.*;

public class MetodoTres {
    public static void main(String[] args) {
        Profesor profesor = new Profesor();
        ExplicarClases explicarClases = new ExplicarClases();
        //Responsabilidades explicarClases2 = new ExplicarClases();
        //((ExplicarClases) explicarClases2).realizar();
        Calificar calificar = new Calificar();
        Reportes reportes = new Reportes();
        profesor.getResponsabilidades().add(explicarClases);
        profesor.getResponsabilidades().add(calificar);
        profesor.getResponsabilidades().add(reportes);

        for(Responsabilidades objeto: profesor.getResponsabilidades()){
            objeto.realizar();
        }

    }
}
