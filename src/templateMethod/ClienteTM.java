package templateMethod;

import hookMethod.GeradorArquivo;
import hookMethod.GeradorPropriedadesCriptografado;

import java.io.IOException;
import java.util.HashMap;

public class ClienteTM {
    
    public static void main(String[] args) throws IOException {
        GeradorArquivo gerador = new GeradorPropriedadesCriptografado(100);
        gerador.gerarArquivo("testeTemplateMethod", new HashMap<String, Object>());
    }
    
}
