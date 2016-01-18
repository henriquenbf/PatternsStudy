package builder;

import bridgeHookClass.Compactador;
import bridgeHookClass.Criptografador;
import bridgeHookClass.GeradorArquivo;
import bridgeHookClass.GeradorXML;
import bridgeHookClass.PosProcessador;

public class BuilderGeradorArquivo {

    private GeradorArquivo instancia;

    public BuilderGeradorArquivo gerandoEmXML() {
        instancia = new GeradorXML();
        return this;
    }

    public BuilderGeradorArquivo gerandoEmPropriedades() {
        // instancia = new GeradorPropriedades();
        return this;
    }

    public BuilderGeradorArquivo comCriptografia() {
        adicionaProcessador(new Criptografador());
        return this;
    }

    public BuilderGeradorArquivo comCompactacao() {
        adicionaProcessador(new Compactador());
        return this;
    }

    private void adicionaProcessador(PosProcessador p) {
        System.out.println(p.toString());
        // PosProcessador atual = instancia.getProcessador();
        // if(atual instanceof NullProcessador) {
        // instancia.setProcessador(p);
        // }else{
        // PosProcessadorComposto pc = new PosProcessadorComposto();
        // pc.add(atual);
        // pc.add(p);
        // instancia.setProcessador(pc);
        // }
    }

    public GeradorArquivo construir() {
        return instancia;
    }
}
