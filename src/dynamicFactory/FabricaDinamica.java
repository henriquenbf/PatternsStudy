package dynamicFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FabricaDinamica {

    private Properties props;

    public FabricaDinamica(String arquivo) throws FileNotFoundException, IOException {
        props = new Properties();

        try (FileInputStream fis = new FileInputStream(arquivo)) {
            props.load(fis);
        }

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public <E> E criaImplementacao(Class<E> abstracao) {

        String nomeAbstracao = abstracao.getName();
        
        String nomeClasse = props.getProperty(nomeAbstracao);

        if (nomeClasse == null) {
            throw new IllegalArgumentException("Implementação não configurada para esta abstração!");
        }

        try {
            Class clazz = Class.forName(nomeClasse);
            if (abstracao.isAssignableFrom(clazz)) {
                return (E) clazz.newInstance();
            } else {
                throw new IllegalArgumentException(String.format("Classe configurada [%s] não implementa esta abstração [%s]", nomeClasse, nomeAbstracao));
            }
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(String.format("Classe da implementação configurada [%s] não existe", nomeClasse), e);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("Não foi possível criar a implementação [%s]", nomeClasse), e);
        }

    }
}
