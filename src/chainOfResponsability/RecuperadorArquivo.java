package chainOfResponsability;

public abstract class RecuperadorArquivo {

    private RecuperadorArquivo proximo;

    public RecuperadorArquivo(RecuperadorArquivo proximo) {
        this.proximo = proximo;
    }

    public Arquivo recuperar(String nome) {
        Arquivo a = recuperaArquivo(nome);
        if (a == null || !a.isValido())
            return chamarProximo(nome);
        else
            return a;
    }
    
    // Template Method
    public Arquivo chamarProximo(String nome) {

        if (proximo == null) {
            throw new RuntimeException("Não foi possível recuperar o arquivo.");
        }

        return proximo.recuperar(nome);

    }

    // Hook Method
    public abstract Arquivo recuperaArquivo(String nome);

}
