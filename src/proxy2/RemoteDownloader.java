package proxy2;

import java.io.IOException;

public interface RemoteDownloader {
    public byte[] buscarArquivo(String url) throws IOException;
}
