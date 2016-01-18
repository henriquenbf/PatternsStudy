package bridgeHookClass;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import bridgeHookClass.refacComposite.PosProcessadorComposto;

public abstract class GeradorArquivo {
    
    // Hook Class (Com composite)
    private PosProcessadorComposto posProcessador;
    
    public final void gerarArquivo(String nome, Map<String, Object> propriedades) throws IOException {
        String conteudo = gerarConteudo(propriedades);
        byte[] bytes = conteudo.getBytes();
        bytes = posProcessador.processar(bytes);
        FileOutputStream fileout = new FileOutputStream(nome);
        fileout.write(bytes);
        fileout.close();
    }
    
    // Hook Method
    protected abstract String gerarConteudo(Map<String, Object> propriedades);

    public void setPosProcessador(PosProcessadorComposto posProcessador) {
        this.posProcessador = posProcessador;
    }
    
}
