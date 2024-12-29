import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/*
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;*/

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

public class agenda{
    ArrayList<infocontato> contatos;

    public agenda(){
        contatos = new ArrayList<>();
    }

    public void adicionarContato(infocontato dados){

        for(int i=0; i<contatos.size(); i++){
            infocontato pessoa = contatos.get(i);
            if(pessoa.nome.equalsIgnoreCase(dados.nome)){
                alterarContato(dados.nome);
                return;
            }
        }

        contatos.add(dados);
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

        Scanner scan = new Scanner(System.in);

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
            if(pessoa.nome.toLowerCase().contains(nomeContato.toLowerCase())){
                return pessoa;
            }
        }
        return null;
    }

    public void salvarAgenda(){
        File arquivo = new File ("dadosDaAgenda.txt");

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo))) {

            for(int i=0; i<contatos.size(); i++){
                infocontato pessoa = contatos.get(i);
                escritor.write(pessoa.nome + ";" + 
                            pessoa.telefone + ";" + 
                            pessoa.endereco + ";" + 
                            pessoa.relacao);
                escritor.newLine();
            }

            System.out.println("\nOs dados da agenda foram salvos!\n\n");

        } catch (IOException erro) {
            System.out.println("\n[X] Erro ao salvar os dados da agenda: " + erro.getMessage());
        }

    }

    public void recuperarAgenda(){

        File arquivo = new File ("dadosDaAgenda.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linhaDoArquivo;
            while ((linhaDoArquivo = reader.readLine()) != null) {
                String[] dados = linhaDoArquivo.split(";");
                infocontato contato = new infocontato(dados[0], dados[1], dados[2], dados[3]);
                contatos.add(contato);
            }
            System.out.println("\nOs dados da agenda foram carregados!\n\n");
        } catch (IOException erro) {
            System.out.println("\n[X] Erro ao carregar os dados da agenda: " + erro.getMessage());
        }

    }

}

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

            System.out.println("\n\nDigite uma opcao: ");
            opcao = scan.nextInt();
            scan.nextLine();

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