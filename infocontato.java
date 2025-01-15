public class infocontato{
    private String nome;
    private String telefone;
    private String endereco;
    private String relacao;

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

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public void setRelacao(String relacao){
        this.relacao = relacao;
    }

    public String getNome(){
        return this.nome;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public String getRelacao(){
        return this.relacao;
    }

}