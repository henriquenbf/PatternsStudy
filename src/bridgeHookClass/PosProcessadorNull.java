package bridgeHookClass;

import java.io.IOException;

public class PosProcessadorNull implements PosProcessador {

    @Override
    public byte[] processar(byte[] bytes) throws IOException {
        return bytes;
    }

}
