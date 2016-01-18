package observer;

public class AcoesLogger implements Observador {

    @Override
    public void alteracaoNaQuantidadeDeAcoes(String codigoAcao, Integer novaQuantidade) {
        System.out.println("Ocorreu uma alteração na quantidade da ação: " + codigoAcao + " - " + novaQuantidade);
    }

}
