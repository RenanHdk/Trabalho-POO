package Entities;

import java.time.LocalDateTime;

public class Certificado {
    private LocalDateTime Data_De_Acontecimento;
    private Palestrante Palestrante;
    private Participante Participante;
    private String Descricao;

    public Certificado(LocalDateTime Data_De_Acontecimento, Palestrante Palestrante, Participante Participante, String Descricao) {
        this.Data_De_Acontecimento = Data_De_Acontecimento;
        this.Palestrante = Palestrante;
        this.Participante = Participante;
        this.Descricao = Descricao;
    }

    public LocalDateTime getData_De_Acontecimento() {
        return Data_De_Acontecimento;
    }

    public void setData_De_Acontecimento(LocalDateTime data_De_Acontecimento) {
        Data_De_Acontecimento = data_De_Acontecimento;
    }

    public Palestrante getPalestrante() {
        return Palestrante;
    }

    public void setPalestrante(Palestrante palestrante) {
        Palestrante = palestrante;
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
