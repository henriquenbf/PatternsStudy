package proxy;

public class ProxyAssincrono implements Transacao {

    private Transacao t;

    public ProxyAssincrono(Transacao t) {
        this.t = t;
    }

    @Override
    public void executar() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                t.executar();
            }
        };
        Thread t = new Thread(r);
        t.start();
    }

}
