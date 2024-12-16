package dgtic.core.modelo;

public class FabricaCoches {
        private  static FabricaCoches fabricaCoches=new FabricaCoches();

        private FabricaCoches(){
        }

        public static FabricaCoches getInstance(){
            if (fabricaCoches==null){
                fabricaCoches = new FabricaCoches();
            }
            return  fabricaCoches;
        }

    public static FabricaCoches getFabricaCoches() {
        return fabricaCoches;
    }

    public static void setFabricaCoches(FabricaCoches fabricaCoches) {
        FabricaCoches.fabricaCoches = fabricaCoches;
    }

    public  ModeloCoche getModeloCoche(TipoCarro tipo) throws IllegalAccessException {
            if (tipo.equals(TipoCarro.DEPORTIVO)) {
                return new Deportivo();
            } else if (tipo.equals(TipoCarro.FAMILIAR)) {
                return new Familiar();
            } else if (tipo.equals(TipoCarro.TODOTERRENO)) {
                return new TodoTerreno();
            }
            throw new IllegalAccessException("No existe ese carro");
        }
}
