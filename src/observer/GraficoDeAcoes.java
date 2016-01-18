package observer;

public class GraficoDeAcoes implements Observador {

    @Override
    public void alteracaoNaQuantidadeDeAcoes(String codigoAcao, Integer novaQuantidade) {
        atualizaGrafico(codigoAcao, novaQuantidade);
    }

    private void atualizaGrafico(String codigoAcao, Integer novaQuantidade) {
        System.out.println("Atualizou a ação: " + codigoAcao + " - " + novaQuantidade);
    }

}
