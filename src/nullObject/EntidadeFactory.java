package nullObject;

public class EntidadeFactory {
    
    public static Entidade criaEntidade() {
        
        boolean usuarioPossuiPrivilegio = false;
        
        if (usuarioPossuiPrivilegio) {
             return new Entidade();
        }
        
        return EntidadeNula.getInstance();
        
    }
    
}
