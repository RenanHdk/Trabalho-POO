package Entities;

public class Inscricao {
    private Participante participante;
    private Palestra palestra;

    public Inscricao(Participante participante, Palestra palestra) {
        this.participante = participante;
        this.palestra = palestra;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Palestra getPalestra() {
        return palestra;
    }

    public void setPalestra(Palestra palestra) {
        this.palestra = palestra;
    }
}
