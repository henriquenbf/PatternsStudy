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
            throw new IllegalArgumentException("Implementa��o n�o configurada para esta abstra��o!");
        }

        try {
            Class clazz = Class.forName(nomeClasse);
            if (abstracao.isAssignableFrom(clazz)) {
                return (E) clazz.newInstance();
            } else {
                throw new IllegalArgumentException(String.format("Classe configurada [%s] n�o implementa esta abstra��o [%s]", nomeClasse, nomeAbstracao));
            }
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(String.format("Classe da implementa��o configurada [%s] n�o existe", nomeClasse), e);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("N�o foi poss�vel criar a implementa��o [%s]", nomeClasse), e);
        }

    }
}
