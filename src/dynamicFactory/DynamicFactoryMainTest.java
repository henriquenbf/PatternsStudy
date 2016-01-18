package dynamicFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DynamicFactoryMainTest {
    
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        
        AnimalDeEstimacao animal;
        
        while (true) {
            animal = new FabricaDinamica("config.properties").criaImplementacao(AnimalDeEstimacao.class);
            
            System.out.println(animal.emiteSom());
            
            Thread.sleep(1000);
        }
        
    }
    
}
