package dgtic.core.modelo;

public class PlanificacionProyectos implements Actividades{

    private Integer numeroProyectos;
    @Override
    public void realiza() {
        System.out.println("Planificar Proyectos");
    }

    public Integer getNumeroProyectos() {
        return numeroProyectos;
    }

    public void setNumeroProyectos(Integer numeroProyectos) {
        this.numeroProyectos = numeroProyectos;
    }
}