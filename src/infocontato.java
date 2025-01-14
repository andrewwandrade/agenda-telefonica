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

    public String formatarTelefone(String telefone){
        if(telefone.length() == 11){
            return "(" + telefone.substring(0,2) + ")" + " " + telefone.substring(2,7) + "-" + telefone.substring(7);
        } else {
            return telefone;
        }
    }

    @Override
    public String toString(){
        return "Nome: " + nome + "\n" +
               "Telefone: " + formatarTelefone(telefone) + "\n" +
               "Endereco: " + endereco + "\n" +
               "Relacao: " + relacao + "\n";
    }
}