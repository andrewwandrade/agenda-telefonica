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

    public infocontato buscarNome(String nome){
        for(int i=0; i<contatos.size(); i++){
            infocontato pessoa = contatos.get(i);
            if(pessoa.nome.equalsIgnoreCase(nome)){
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
                                [4] Sair");
            System.out.println("\n\nDigite uma opcao: ");

            opcao = sc.nextInt();

            switch(opcao){
                case 1:
                    String nome, telefone, endereco, relacao;

                    System.out.println("\nDigite o nome: ");
                    nome = sc.nextLine();

                    System.out.println("\nDigite o telefone (Ex: 11 111111111): ");
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

                    encontrado = agenda.buscarNome(procurado);
                    if(encontrado == null){
                        System.out.println("\n[X] Contato nao encontrado!\n\n");
                    } else {
                        encontrado.exibirDados();
                    }

                    break;

                case 4:
                    sc.close();
                    System.out.println("\nPrograma encerrado!\n\n");
                    break;

                default:
                    System.out.println("\n[X] Selecione uma opcao valida!\n\n");
                    break;
            }

        }while(opcao != 4);

    }

}