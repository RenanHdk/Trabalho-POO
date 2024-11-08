package Entities;

public class Alocacao {
    private Local local;
    private Palestra palestra;

    public Alocacao(Local local, Palestra palestra) {
        this.local = local;
        this.palestra = palestra;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Palestra getPalestra() {
        return palestra;
    }

    public void setPalestra(Palestra palestra) {
        this.palestra = palestra;
    }
}
