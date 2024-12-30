import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class principal{

    public static void main(String[] arg){
        agenda minhaAgenda = new agenda();
        Scanner scan = new Scanner(System.in);
        int opcao = 0;
/*
        minhaAgenda.adicionarContato(new infocontato("João Paulo", "11987654321", "Rua A, 123", "Amigo"));
        minhaAgenda.adicionarContato(new infocontato("Maria Eduarda", "21987654321", "Rua B, 456", "Familia"));
        minhaAgenda.adicionarContato(new infocontato("Carlos", "31987654321", "Rua C, 789", "Colega"));*/

        do{

            System.out.println("\n----------[AGENDA TELEFONICA]----------\n\n");
            System.out.println("[1] Adicionar contato\n" +
                               "[2] Exibir todos os contatos\n" +
                               "[3] Procurar contato\n" +
                               "[4] Alterar informacoes do contato\n" +
                               "[5] Remover contato\n" +
                               "[6] Salvar agenda de contatos\n" +
                               "[7] Recuperar agenda de contatos\n" +
                               "[8] Apagar todos os contatos\n" +
                               "[9] Sair");

            System.out.println("\n\nSelecione uma opcao: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch(opcao){
                case 1:
                    String nome, telefone, endereco, relacao;

                    System.out.println("\nDigite o nome: ");
                    nome = scan.nextLine();

                    System.out.println("\nDigite o telefone (11 digitos): "); 
                    telefone = scan.nextLine();

                    System.out.println("\nDigite o endereco: ");
                    endereco = scan.nextLine();

                    System.out.println("\nDigite a relacao: ");
                    relacao = scan.nextLine();

                    infocontato pessoa = new infocontato(nome, telefone, endereco, relacao);

                    minhaAgenda.adicionarContato(pessoa);
                    break;

                case 2:
                    minhaAgenda.exibirContatos();
                    break;

                case 3:
                    String procurado;
                    infocontato encontrado;

                    System.out.println("\nATENCAO: Caso o nome possua acento, digite-o sem acento!");
                    System.out.println("Digite o nome da pessoa que deseja procurar: ");
                    procurado = scan.nextLine();

                    encontrado = minhaAgenda.buscarPorNome(procurado);
                    if(encontrado == null){
                        System.out.println("\n[X] Contato nao encontrado!\n\n");
                    } else {
                        System.out.println("\nContato encontrado:\n\n");
                        System.out.println(encontrado.toString());
                    }

                    break;
                
                case 4:
                    String nome1;

                    System.out.println("\nATENCAO: Caso o nome possua acento, digite-o sem acento e de forma completa!");
                    System.out.println("\nDigite o nome do contato que deseja alterar os dados: ");
                    nome1 = scan.nextLine();

                    minhaAgenda.alterarContato(nome1);
                    break;
                
                case 5:
                    String nome2;

                    System.out.println("Digite o nome do contato que deseja excluir: ");
                    nome2 = scan.nextLine();

                    minhaAgenda.removerContato(nome2);
                    break;

                case 6:
                    minhaAgenda.salvarAgenda();
                    break;

                case 7:
                    System.out.println("\nAtencao: O arquivo de dados precisa ter o nome " + "dadosDaAgenda.txt!");
                    minhaAgenda.recuperarAgenda();
                    break;
                
                case 8:
                    minhaAgenda.apagarTodosContatos();
                    break;

                case 9:
                    System.out.println("\nPrograma encerrado!\n\n");
                    break;

                default:
                    System.out.println("\n[X] Selecione uma opcao valida!\n\n");
                    break;
            }

        }while(opcao != 9);

        scan.close();
    
    }

}