package Entities;

public class Participante extends Pessoa{
    private Integer Codigo;

    public Participante(String Nome, String Endereco, String Email, Integer codigo) {
        super(Nome, Endereco, Email);
        Codigo = codigo;
    }

    public Integer getCodigo() {
        return Codigo;
    }

    public void setCodigo(Integer codigo) {
        Codigo = codigo;
    }
}
