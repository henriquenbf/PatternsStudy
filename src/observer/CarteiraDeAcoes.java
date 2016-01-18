package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarteiraDeAcoes {
    
    private Map<String, Integer> acoes = new HashMap<>();
    private List<Observador> observadores = new ArrayList<>();
    
    public void adicionaAcoes(String codigoAcao, Integer quantidade) {
        
        if (acoes.containsKey(codigoAcao)) {
            quantidade += acoes.get(codigoAcao);
        }
        
        acoes.put(codigoAcao, quantidade);
        notificar(codigoAcao, quantidade);
        
    }

    private void notificar(String codigoAcao, Integer quantidade) {
        for (Observador observador : observadores) {
            observador.alteracaoNaQuantidadeDeAcoes(codigoAcao, quantidade);
        }
    }
    
    public void addObservador(Observador observador) {
        this.observadores.add(observador);
    }
    
}
