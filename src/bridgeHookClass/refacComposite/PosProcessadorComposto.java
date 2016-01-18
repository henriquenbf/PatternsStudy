package bridgeHookClass.refacComposite;

import java.io.IOException;

import bridgeHookClass.PosProcessador;

public class PosProcessadorComposto implements PosProcessador {

    private PosProcessador[] posProcessadores;

    public PosProcessadorComposto(PosProcessador... posProcessadores) {
        this.posProcessadores = posProcessadores;
    }

    @Override
    public byte[] processar(byte[] bytes) throws IOException {
        for (PosProcessador posProcessador : posProcessadores) {
            bytes = posProcessador.processar(bytes);
        }
        return bytes;
    }
    
    public void add(PosProcessador pp) {
        
    }

}
