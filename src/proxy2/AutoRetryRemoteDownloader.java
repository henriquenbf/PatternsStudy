package proxy2;

import java.io.IOException;

public class AutoRetryRemoteDownloader implements RemoteDownloader {

    private RemoteDownloader downloader;
    private int maximoTentativas;

    public AutoRetryRemoteDownloader(RemoteDownloader downloader, int maximoTentativas) {
        this.downloader = downloader;
        this.maximoTentativas = maximoTentativas;
    }

    public byte[] buscarArquivo(String url) throws IOException {
        int tentativas = 0;
        IOException ultimoErro = null;
        while (tentativas < maximoTentativas) {
            try {
                return downloader.buscarArquivo(url);
            } catch (IOException ex) {
                tentativas++;
                ultimoErro = ex;
            }
        }
        throw ultimoErro;
    }

}
