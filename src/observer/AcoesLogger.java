package observer;

public class AcoesLogger implements Observador {

    @Override
    public void alteracaoNaQuantidadeDeAcoes(String codigoAcao, Integer novaQuantidade) {
        System.out.println("Ocorreu uma altera��o na quantidade da a��o: " + codigoAcao + " - " + novaQuantidade);
    }

}
