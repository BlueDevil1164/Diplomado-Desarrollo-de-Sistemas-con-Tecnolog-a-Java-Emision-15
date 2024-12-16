package dgtic.core.modelo;

public class TiendaElectronicos {
        private  static TiendaElectronicos tiendaElectronicos=new TiendaElectronicos();

        private TiendaElectronicos(){
        }

        public static TiendaElectronicos getInstance(){
            if (tiendaElectronicos==null){
                tiendaElectronicos = new TiendaElectronicos();
            }
            return  tiendaElectronicos;
        }

    public static TiendaElectronicos getTiendaElectronicos() {
        return tiendaElectronicos;
    }

    public static void setFabricaCoches(TiendaElectronicos tiendaElectronicos) {
        TiendaElectronicos.tiendaElectronicos = tiendaElectronicos;
    }


    public  Productos getProductos(TipoElectronico tipo) throws IllegalAccessException {
            if (tipo.equals(TipoElectronico.LAPTOP)) {
                return new Laptop();
            } else if (tipo.equals(TipoElectronico.CELULAR)) {
                return new Celular();
            } else if (tipo.equals(TipoElectronico.TABLET)) {
                return new Tablet();
            }
            throw new IllegalAccessException("No existe ese Producto");
        }
}
