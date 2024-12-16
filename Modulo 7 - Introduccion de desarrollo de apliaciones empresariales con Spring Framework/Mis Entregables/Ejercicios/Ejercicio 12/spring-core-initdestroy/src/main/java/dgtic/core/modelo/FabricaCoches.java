package dgtic.core.modelo;

public class FabricaCoches {
    private static FabricaCoches instance = new FabricaCoches();

    public static FabricaCoches getInstance() {
        return instance;
    }

    public ModeloCoche getModeloCoche(TipoCarro tipo) throws IllegalAccessException {
        if(tipo.equals(TipoCarro.DEPORTIVO))
            return new Deportivo();
        if(tipo.equals(TipoCarro.FAMILIAR))
            return new Familiar();
        if (tipo.equals(TipoCarro.TODOTERRENO))
            return new TodoTerreno();

        throw new IllegalAccessException("No existe el carro");
    }
}
