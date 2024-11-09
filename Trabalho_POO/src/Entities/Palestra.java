package Entities;

import java.time.LocalDateTime;

public class Palestra {
    private String Nome;
    private String Descricao;
    private LocalDateTime Inicio;
    private LocalDateTime Fim;
    private Integer Vagas;
    private Boolean EmiteCertificado;

    public Palestra(String nome, String descricao, LocalDateTime inicio, LocalDateTime fim, int vagas, boolean emiteCertificado) {
        Nome = nome;
        Descricao = descricao;
        Inicio = inicio;
        Fim = fim;
        Vagas = vagas;
        EmiteCertificado = emiteCertificado;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public LocalDateTime getInicio() {
        return Inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        Inicio = inicio;
    }

    public LocalDateTime getFim() {
        return Fim;
    }

    public void setFim(LocalDateTime fim) {
        Fim = fim;
    }

    public int getVagas() {
        return Vagas;
    }

    public void setVagas(int vagas) {
        Vagas = vagas;
    }

    public boolean isEmiteCertificado() {
        return EmiteCertificado;
    }

    public void setEmiteCertificado(boolean emiteCertificado) {
        EmiteCertificado = emiteCertificado;
    }
}
