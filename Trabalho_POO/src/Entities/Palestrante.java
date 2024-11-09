package Entities;

public class Palestrante extends Pessoa{
    private String Especialidade;
    public Palestrante(String Nome, String Endereco, String Email, String Especialidade){
        super(Nome, Endereco, Email);
        this.Especialidade = Especialidade;
    }

    public String getEspecialidade() {
        return Especialidade;
    }

    public void setEspecialidade(String especialidade) {
        Especialidade = especialidade;
    }

}
