package Entities;

public class Apresentacao {
    private Palestrante palestrante;
    private Palestra palestra;

    public Apresentacao(Palestrante palestrante, Palestra palestra) {
        this.palestrante = palestrante;
        this.palestra = palestra;
    }

    public Palestrante getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(Palestrante palestrante) {
        this.palestrante = palestrante;
    }

    public Palestra getPalestra() {
        return palestra;
    }

    public void setPalestra(Palestra palestra) {
        this.palestra = palestra;
    }
}
