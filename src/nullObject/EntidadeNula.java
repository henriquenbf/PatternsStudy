package nullObject;

public class EntidadeNula extends Entidade {
    
    private static final EntidadeNula instance = new EntidadeNula();
    
    private EntidadeNula() {}
    
    public static Entidade getInstance() {
        return instance;
    }
    
    public int getId() {
        return 0;
    }

    public Double getValor() {
        return 0.0;
    }
    
}
