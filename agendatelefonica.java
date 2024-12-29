import java.util.ArrayList;
import java.util.Scanner;

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

    @override
    public string toString(){
        return "Nome: " + nome + "\n" +
               "Telefone: " + telefone + "\n" +
               "Endereco: " + endereco + "\n" +
               "Relacao: " + relacao + "\n";
    }
}

public class agenda{
    ArrayList<infocontato> contatos;

    public agenda(){
        contatos = new ArrayList<>();
    }

    public void adicionarContato(infocontato dados){

        for(int i=0; i<contatos.size(); i++){
            infocontato pessoa = contatos.get(i);
            if(pessoa.nome.equalsIgnoreCase(dados.nome)){
                alterarContato(dados);
                return;
            }
        }

        contatos.add(pessoa);
        System.out.println("\nContato adicionado!\n\n");
    }

    public void removerContato(String nomeContato){
        for(int i=0; i<contatos.size(); i++){
            infocontato pessoa = contatos.get(i);
            if(pessoa.nome.equalsIgnoreCase(nomeContato)){
                contatos.remove(i);
                System.out.println("\nContato removido!\n\n");
                return;
            }
        }
        System.out.println("\n[X] Contato nao encontrado!\n\n");
    }

    public void alterarContato(String nomeContato){

        for(int i=0; i<contatos.size(); i++){
            infocontato pessoa = contatos.get(i);
            if(pessoa.nome.equalsIgnoreCase(nomeContato)){

                System.out.println("\nDigite o nome: ");
                pessoa.nome = scan.nextLine();
                
                System.out.println("\nDigite o telefone (Formato 11 111111111): "); 
                pessoa.telefone = scan.nextLine();

                System.out.println("\nDigite o endereco: ");
                pessoa.endereco = scan.nextLine();

                System.out.println("\nDigite a relacao: ");
                pessoa.relacao = scan.nextLine();

                System.out.println("\nContato alterado!\n\n");
                return;
            }
        }
        System.out.println("\n[X] Contato nao encontrado! Alteracao nao foi realizada.\n\n");
    }

    public void exibirContatos(){
        if(contatos.isEmpty()){
            System.out.println("A agenda nao possui nenhum contato!");
        } else {
            System.out.println("Lista de Contatos:");
            for(int i=0; i<contatos.size(); i++){
                infocontato pessoa = contatos.get(i);
                System.out.println(pessoa.toString());
            }
        }
    }

    public infocontato buscarPorNome(String nomeContato){
        for(int i=0; i<contatos.size(); i++){
            infocontato pessoa = contatos.get(i);
            if(contato.nome.toLowerCase().contains(nomeContato.toLowerCase())){
                return pessoa;
            }
        }
        return null;
    }

}

public class principal{

    public static void main(String[] arg){
        agenda minhaAgenda = new agenda();
        Scanner scan = new Scanner(System.in);
        int opcao = 0;

        do{

            System.out.println("\n\n----------[AGENDA TELEFONICA]----------\n\n");
            System.out.println("[1] Adicionar contato\n
                                [2] Exibir todos os contatos\n
                                [3] Procurar contato\n
                                [4] Alterar informacoes do contato\n
                                [5] Remover contato\n
                                [6] Salvar agenda de contatos\n
                                [7] Recuperar agenda de contatos\n
                                [8] Sair");

            System.out.println("\n\nDigite uma opcao: ");
            opcao = scan.nextInt();

            switch(opcao){
                case 1:
                    String nome, telefone, endereco, relacao;

                    System.out.println("\nDigite o nome: ");
                    nome = scan.nextLine();

                    System.out.println("\nDigite o telefone (Formato 11 111111111): "); 
                    telefone = scan.nextLine();

                    System.out.println("\nDigite o endereco: ");
                    endereco = scan.nextLine();

                    System.out.println("\nDigite a relacao: ");
                    relacao = scan.nextLine();

                    contato pessoa = new contato(nome, telefone, endereco, relacao);
                    agenda.adicionarContato(pessoa);

                    break;

                case 2:
                    agenda.exibirContatos();
                    break;

                case 3:
                    String procurado;
                    infocontato encontrado;

                    System.out.println("Digite o nome da pessoa que deseja procurar: ");
                    procurado = scan.nextLine();

                    encontrado = agenda.buscarPorNome(procurado);
                    if(encontrado == null){
                        System.out.println("\n[X] Contato nao encontrado!\n\n");
                    } else {
                        System.out.println("\nContato encontrado:\n\n");
                        System.out.println(encontrado.toString());
                    }

                    break;
                
                case 4:
                    String nome;

                    System.out.println("\nDigite o nome do contato que deseja alterar os dados: ");
                    nome = scan.nextLine();

                    agenda.alterarContato(nome);
                    break;
                
                case 5:
                    String nome;

                    System.out.println("Digite o nome do contato que deseja excluir: ");
                    nome = scan.nextLine();

                    agenda.removerContato(nome);
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    scan.close();
                    System.out.println("\nPrograma encerrado!\n\n");
                    break;

                default:
                    System.out.println("\n[X] Selecione uma opcao valida!\n\n");
                    break;
            }

        }while(opcao != 8);

    }

}