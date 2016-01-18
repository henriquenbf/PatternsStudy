package builder;

import bridgeHookClass.GeradorArquivo;

public class BuilderMainTest {
    
    public static void main(String[] args) {
        
        GeradorArquivo ga = new BuilderGeradorArquivo().gerandoEmXML().comCompactacao().comCriptografia().construir();
        
        System.out.println(ga.toString());
        
    }
    
}
