package Entities;

import java.time.LocalDateTime;

public class Certificado {
    private Palestra palestra;
    private Participante Participante;
    private String Descricao;

    public Certificado(Palestra palestra, Participante Participante, String Descricao) {
        this.palestra = palestra;
        this.Participante = Participante;
        this.Descricao = Descricao;
    }

    public Palestra getPalestra() {
        return palestra;
    }

    public void setPalestra(Palestra palestra) {
        this.palestra = palestra;
    }

    public Entities.Participante getParticipante() {
        return Participante;
    }

    public void setParticipante(Entities.Participante participante) {
        Participante = participante;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
}
