package bridgeHookClass;

import java.io.IOException;

public interface PosProcessador {
    public byte[] processar(byte[] bytes) throws IOException;
}
