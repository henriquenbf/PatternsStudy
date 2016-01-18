package bridgeHookClass.refacChain;

public abstract class PosProcessadorChain {

    private PosProcessadorChain proximo;

    public PosProcessadorChain(PosProcessadorChain proximo) {
        this.proximo = proximo;
    }

    public byte[] processarCadeia(byte[] bytes) {
        bytes = processar(bytes);
        return proximo.processarCadeia(bytes);
    }

    protected abstract byte[] processar(byte[] bytes);

}
