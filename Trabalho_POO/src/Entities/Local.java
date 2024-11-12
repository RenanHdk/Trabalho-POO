package Entities;

import java.util.ArrayList;

public class Local {
    private String Nome;
    private Integer Capacidade;
    private ArrayList<String> Recursos;

    public Local(String Nome, int Capacidade){
        this.Nome = Nome;
        this.Capacidade = Capacidade;
        this.Recursos = new ArrayList<>();
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setCapacidade(Integer capacidade) {
        Capacidade = capacidade;
    }

    public int getCapacidade() {
        return Capacidade;
    }

    public ArrayList<String> getRecursos() {
        return Recursos;
    }



    public void setCapacidade(int capacidade) {
        Capacidade = capacidade;
    }

    public void setRecursos(ArrayList<String> recursos) {
        Recursos = recursos;
    }

}

