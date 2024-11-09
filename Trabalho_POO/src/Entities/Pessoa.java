package Entities;

public abstract class Pessoa {
    protected String Nome;
    protected String Endereco;
    protected String Email;
    protected ArrayList<String> Telefone;

    public Pessoa(String Nome, String Endereco, String Email){
        this.Nome = Nome;
        this.Endereco = Endereco;
        this.Email = Email;
        this.Telefone  = new ArrayList<String>();
    }

    public String getNome() {
        return Nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public String getEmail() {
        return Email;
    }

    public ArrayList<String> getTelefone() {
        return Telefone;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setTelefone(ArrayList<String> telefone) {
        Telefone = telefone;
    }
}
