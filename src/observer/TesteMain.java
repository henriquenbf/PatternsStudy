package observer;

public class TesteMain {
    
    public static void main(String[] args) throws InterruptedException {
        
        AcoesLogger logger = new AcoesLogger();
        GraficoDeAcoes grafico = new GraficoDeAcoes();
        
        CarteiraDeAcoes c = new CarteiraDeAcoes();
        c.addObservador(logger);
        c.addObservador(grafico);
        
        Thread.sleep(2000);
        c.adicionaAcoes("COMP02", 200);
        Thread.sleep(2000);
        c.adicionaAcoes("EMP34", 400);
        Thread.sleep(2000);
        c.adicionaAcoes("ACDF89", 300);
        Thread.sleep(2000);
        c.adicionaAcoes("EMP34", -200);
        Thread.sleep(2000);
        c.adicionaAcoes("COMP02", 150);
        
    }

}
