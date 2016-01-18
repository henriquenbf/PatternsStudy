package hookMethod;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GeradorXMLCompactado extends GeradorArquivo {

    @Override
    protected String gerarConteudo(Map<String, Object> propriedades) {
        StringBuilder xmlFileBuilder = new StringBuilder();
        xmlFileBuilder.append("<properties>");
        for (String prop : propriedades.keySet()) {
            xmlFileBuilder.append("<" + prop + ">" + propriedades.get(prop) + "</" + prop + ">");
        }
        xmlFileBuilder.append("</properties>");
        return xmlFileBuilder.toString();
    }

    @Override
    protected byte[] processar(byte[] bytes) throws IOException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ZipOutputStream out = new ZipOutputStream(byteOut);
        out.putNextEntry(new ZipEntry("internal"));
        out.write(bytes);
        out.closeEntry();
        out.close();
        return byteOut.toByteArray();
    }

}
