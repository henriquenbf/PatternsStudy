package chainOfResponsability;

import java.util.HashMap;
import java.util.Map;

public class RecuperadorArquivoEmCache extends RecuperadorArquivo {

    private Map<String, Arquivo> cache = new HashMap<>();

    public RecuperadorArquivoEmCache(RecuperadorArquivo proximo) {
        super(proximo);
    }

    @Override
    public Arquivo recuperaArquivo(String nome) {
        if (cache.containsKey(nome)) {
            cache.get(nome);
        }
        return null;
    }

    @Override
    public Arquivo chamarProximo(String nome) {
        Arquivo a = super.chamarProximo(nome);
        cache.put(nome, a);
        return a;
    }

    @Override
    public String toString() {
        return "RecuperadorArquivoEmCache [cache=" + cache + "]";
    }

}
