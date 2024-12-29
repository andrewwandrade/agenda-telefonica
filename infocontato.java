public class infocontato{
    String nome;
    String telefone;
    String endereco;
    String relacao;

    public infocontato(String nome, String telefone, String endereco, String relacao){
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.relacao = relacao;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + "\n" +
               "Telefone: " + telefone + "\n" +
               "Endereco: " + endereco + "\n" +
               "Relacao: " + relacao + "\n";
    }
}