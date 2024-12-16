package mx.unam.dgtic.datos;

public class Detalles {

    private String area;
    private String plan;

    public Detalles() {
    }

    public Detalles(String area, String plan) {
        this.area = area;
        this.plan = plan;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPlan() {
        return plan;
    }


    public void setPlan(String plan) {
        this.plan = plan;
    }
}
