package chainOfResponsability;

public class RecuperadorArquivoNoServidor extends RecuperadorArquivo {

    public RecuperadorArquivoNoServidor(RecuperadorArquivo proximo) {
        super(proximo);
    }

    @Override
    public Arquivo recuperaArquivo(String nome) {
        // Codigo para buscar o arquivo no servidor
        return null;
    }

    @Override
    public String toString() {
        return "RecuperadorArquivoNoServidor []";
    }
    
}
