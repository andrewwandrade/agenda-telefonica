import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class agenda{
    ArrayList<infocontato> contatos;

    public agenda(){
        contatos = new ArrayList<>();
    }

    public void adicionarContato(infocontato dados){
        
        dados.nome = removerAcentos(dados.nome);
        Scanner scan = new Scanner(System.in);

        for(int i=0; i<contatos.size(); i++){
            infocontato pessoa = contatos.get(i);
            if(pessoa.nome.equalsIgnoreCase(dados.nome)){
                pessoa.nome = dados.nome;
                pessoa.telefone = dados.telefone;
                pessoa.endereco = dados.endereco;
                pessoa.relacao = dados.relacao;
                System.out.println("\nContato existente! Os dados foram substituidos.\n");
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

        nomeContato = removerAcentos(nomeContato);
        Scanner scan = new Scanner(System.in);

        for(int i=0; i<contatos.size(); i++){
            infocontato pessoa = contatos.get(i);
            if(pessoa.nome.equalsIgnoreCase(nomeContato)){

                int op;

                System.out.println("\nO que deseja alterar?\n\n" + 
                                   "[1] Nome\n" + 
                                   "[2] Telefone\n" + 
                                   "[3] Endereco\n" + 
                                   "[4] Relacao\n" + 
                                   "[5] Todos os campos\n");

                System.out.println("\nSelecione uma opcao: ");
                op = scan.nextInt();    
                scan.nextLine();

                switch(op){
                    case 1:
                        System.out.println("Digite o novo nome: ");
                        pessoa.nome = scan.nextLine();
                        pessoa.nome = removerAcentos(pessoa.nome);
                        break;

                    case 2:
                        System.out.println("\nDigite o novo telefone (11 digitos): "); 
                        pessoa.telefone = scan.nextLine();
                        break;

                    case 3:
                        System.out.println("\nDigite o novo endereco: ");
                        pessoa.endereco = scan.nextLine();
                        break;

                    case 4:
                        System.out.println("\nDigite a nova relacao: ");
                        pessoa.relacao = scan.nextLine();
                        break;

                    case 5:
                        System.out.println("\nDigite o novo nome: ");
                        pessoa.nome = scan.nextLine();
                        pessoa.nome = removerAcentos(pessoa.nome);
                
                        System.out.println("\nDigite o novo telefone (11 digitos): "); 
                        pessoa.telefone = scan.nextLine();

                        System.out.println("\nDigite o novo endereco: ");
                        pessoa.endereco = scan.nextLine();

                        System.out.println("\nDigite a nova relacao: ");
                        pessoa.relacao = scan.nextLine();
                        break;

                    default:
                        System.out.println("\n[X] Opcao invalida!\n\n");
                        break;
                }
                System.out.println("\nContato alterado!\n\n");
                return;
            }
        }
        System.out.println("\n[X] Contato nao encontrado! Alteracao nao foi realizada.\n\n");
    }

    public void exibirContatos(){
        if(contatos.isEmpty()){
            System.out.println("\nA agenda nao possui nenhum contato!\n\n");
        } else {
            System.out.println("\nLista de Contatos:\n");
            for(int i=0; i<contatos.size(); i++){
                infocontato pessoa = contatos.get(i);
                System.out.println(pessoa.toString());
                System.out.println("\n");
            }
        }
    }

    public static String removerAcentos(String str) {
        return str.replaceAll("[áàãâä]", "a")
                .replaceAll("[éèêë]", "e")
                .replaceAll("[íìîï]", "i")
                .replaceAll("[óòôõö]", "o")
                .replaceAll("[úùûü]", "u")
                .replaceAll("[ç]", "c");
    }

    public infocontato buscarPorNome(String nomeContato){
        nomeContato = removerAcentos(nomeContato);  // Remover acentos do nome a ser buscado

        for(int i=0; i<contatos.size(); i++){
            infocontato pessoa = contatos.get(i);
            // Remover acentos também do nome do contato
            String nomeContatoSalvo = removerAcentos(pessoa.nome);  

            if(nomeContatoSalvo.toLowerCase().contains(nomeContato.toLowerCase())){
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

    public void apagarTodosContatos() {
        contatos.clear();
        System.out.println("\nTodos os contatos foram excluidos!\n\n");
    }

}