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

    public void exibirDados(){
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereco: " + endereco);
        System.out.println("Relacao: " + relacao);
    }

}

public class agenda{
    ArrayList<infocontato> contatos;

    public agenda(){
        contatos = new ArrayList<>();
    }

    public void adicionarContato(infocontato pessoa){
        contatos.add(contato);
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

    public void alterarContato(String nomeContato, String telContato, String endContato, String relContato){

        for(int i=0; i<contatos.size(); i++){
            infocontato pessoa = contatos.get(i);
            if(pessoa.nome.equalsIgnoreCase(nomeContato)){
                pessoa.nome = nomeContato;
                pessoa.telefone = telContato;
                pessoa.endereco = endContato;
                pessoa.relacao = relContato;
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
                pessoa.exibirDados();
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
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do{

            System.out.println("\n\n----------[AGENDA TELEFONICA]----------\n\n");
            System.out.println("[1] Adicionar contato\n
                                [2] Exibir todos os contatos\n
                                [3] Procurar contato\n
                                [4] Alterar informacoes do contato\n
                                [5] Remover contato\n
                                [6] Sair");
            System.out.println("\n\nDigite uma opcao: ");

            opcao = sc.nextInt();

            switch(opcao){
                case 1:
                    String nome, telefone, endereco, relacao;

                    System.out.println("\nDigite o nome: ");
                    nome = sc.nextLine();

                    System.out.println("\nDigite o telefone (Formato 11 111111111): "); 
                    telefone = sc.nextLine();

                    System.out.println("\nDigite o endereco: ");
                    endereco = sc.nextLine();

                    System.out.println("\nDigite a relacao: ");
                    relacao = sc.nextLine();

                    contato pessoa = new contato(nome, telefone, endereco, relacao);
                    agenda.adicionarContato(pessoa);

                    System.out.println("\nContato adicionado!\n\n");
                    break;

                case 2:
                    agenda.exibirContatos();
                    break;

                case 3:
                    String procurado;
                    infocontato encontrado;

                    System.out.println("Digite o nome da pessoa que deseja procurar: ");
                    procurado = sc.nextLine();

                    encontrado = agenda.buscarPorNome(procurado);
                    if(encontrado == null){
                        System.out.println("\n[X] Contato nao encontrado!\n\n");
                    } else {
                        encontrado.exibirDados();
                    }

                    break;
                
                case 5:

                    break;
                
                case 6:

                    break;

                case 6:
                    sc.close();
                    System.out.println("\nPrograma encerrado!\n\n");
                    break;

                default:
                    System.out.println("\n[X] Selecione uma opcao valida!\n\n");
                    break;
            }

        }while(opcao != 6);

    }

}