import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class principal{

    public static void main(String[] arg){
        agenda minhaAgenda = new agenda();
        Scanner scan = new Scanner(System.in);
        int opcao = 0;

        do{

            System.out.println("\n----------[AGENDA TELEFONICA]----------\n\n");
            System.out.println("[1] Adicionar contato\n" +
                               "[2] Exibir todos os contatos\n" +
                               "[3] Buscar contato\n" +
                               "[4] Filtrar dados de contatos\n" +
                               "[5] Alterar informacoes do contato\n" +
                               "[6] Remover contato\n" +
                               "[7] Salvar agenda de contatos\n" +
                               "[8] Recuperar agenda de contatos\n" +
                               "[9] Apagar todos os contatos\n" +
                               "[10] Sair");

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

                    System.out.println("\nDigite o endereco (Logradouro, Numero): ");
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

                    int opcaoCase4;

                    System.out.println("\nSeleciona o filtro desejado:\n");
                    System.out.println("[1] Endereco\n" +
                                       "[2] Relacao");
                    
                    System.out.println("\nDigite uma opcao: ");
                    opcaoCase4 = scan.nextInt();
                    scan.nextLine();

                    switch(opcaoCase4){
                        case 1:
                            String enderecoFiltro;

                            System.out.print("\nDigite o endereco (Sem o numero da casa): ");
                            enderecoFiltro = scan.nextLine();
                            minhaAgenda.buscaAvancada(enderecoFiltro, opcaoCase4);

                            break;

                        case 2:
                            String relacaoFiltro;

                            System.out.print("\nDigite a relacao: ");
                            relacaoFiltro = scan.nextLine();
                            minhaAgenda.buscaAvancada(relacaoFiltro, opcaoCase4);

                            break;

                        default:
                            System.out.println("\n[X] Digite uma opcao valida!\n");
                            break;
                    }

                    break;
                
                case 5:
                    String nome1;

                    System.out.println("\nATENCAO: Caso o nome possua acento, digite-o sem acento e de forma completa!");
                    System.out.println("\nDigite o nome do contato que deseja alterar os dados: ");
                    nome1 = scan.nextLine();

                    minhaAgenda.alterarContato(nome1);
                    break;
                
                case 6:
                    String nome2;

                    System.out.println("\nDigite o nome do contato que deseja excluir: ");
                    nome2 = scan.nextLine();

                    minhaAgenda.removerContato(nome2);
                    break;

                case 7:
                    minhaAgenda.salvarAgenda();
                    break;

                case 8:
                    System.out.println("\nAtencao: O arquivo de dados precisa ter o nome " + "dadosDaAgenda.txt!");
                    minhaAgenda.recuperarAgenda();
                    break;
                
                case 9:
                    minhaAgenda.apagarTodosContatos();
                    break;

                case 10:
                    System.out.println("\nPrograma encerrado!\n\n");
                    break;

                default:
                    System.out.println("\n[X] Selecione uma opcao valida!\n\n");
                    break;
            }

        }while(opcao != 10);

        scan.close();
    
    }

}