import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/*
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;*/

public class principal{

    public static void main(String[] arg){
        agenda minhaAgenda = new agenda();
        Scanner scan = new Scanner(System.in);
        int opcao = 0;

        do{

            System.out.println("\n\n----------[AGENDA TELEFONICA]----------\n\n");
            System.out.println("[1] Adicionar contato\n" +
                               "[2] Exibir todos os contatos\n" +
                               "[3] Procurar contato\n" +
                               "[4] Alterar informacoes do contato\n" +
                               "[5] Remover contato\n" +
                               "[6] Salvar agenda de contatos\n" +
                               "[7] Recuperar agenda de contatos\n" +
                               "[8] Sair");

            System.out.println("\n\nSelecione uma opcao: ");
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

                    infocontato pessoa = new infocontato(nome, telefone, endereco, relacao);
                    minhaAgenda.adicionarContato(pessoa);

                    break;

                case 2:
                    minhaAgenda.exibirContatos();
                    break;

                case 3:
                    String procurado;
                    infocontato encontrado;

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
                    minhaAgenda.recuperarAgenda();
                    break;

                case 8:
                    System.out.println("\nPrograma encerrado!\n\n");
                    break;

                default:
                    System.out.println("\n[X] Selecione uma opcao valida!\n\n");
                    break;
            }

        }while(opcao != 8);

        scan.close();
    
    }

}