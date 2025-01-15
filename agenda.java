import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class agenda{
    ArrayList<infocontato> contatos;

    public agenda(){
        contatos = new ArrayList<>();
    }

    public void adicionarContato(infocontato dados){
        
        dados.setNome(removerAcentos(dados.getNome()));
        Scanner scan = new Scanner(System.in);

        for(int i=0; i<contatos.size(); i++){
            infocontato pessoa = contatos.get(i);
            if(pessoa.getNome().equalsIgnoreCase(dados.getNome())){
                pessoa.setNome(dados.getNome());
                pessoa.setTelefone(dados.getTelefone());
                pessoa.setEndereco(dados.getEndereco());
                pessoa.setRelacao(dados.getRelacao());
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
            if(pessoa.getNome().equalsIgnoreCase(nomeContato)){
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
            if(pessoa.getNome().equalsIgnoreCase(nomeContato)){

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
                        pessoa.setNome(scan.nextLine());
                        pessoa.setNome(removerAcentos(pessoa.getNome()));
                        break;

                    case 2:
                        System.out.println("\nDigite o novo telefone (11 digitos): "); 
                        pessoa.setTelefone(scan.nextLine());
                        break;

                    case 3:
                        System.out.println("\nDigite o novo endereco: ");
                        pessoa.setEndereco(scan.nextLine());
                        break;

                    case 4:
                        System.out.println("\nDigite a nova relacao: ");
                        pessoa.setRelacao(scan.nextLine());
                        break;

                    case 5:
                        System.out.println("\nDigite o novo nome: ");
                        pessoa.setNome(scan.nextLine());
                        pessoa.setNome(removerAcentos(pessoa.getNome()));
                
                        System.out.println("\nDigite o novo telefone (11 digitos): "); 
                        pessoa.setTelefone(scan.nextLine());

                        System.out.println("\nDigite o novo endereco: ");
                        pessoa.setEndereco(scan.nextLine());

                        System.out.println("\nDigite a nova relacao: ");
                        pessoa.setRelacao(scan.nextLine());
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

    public static String removerAcentos(String str){
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
            String nomeContatoSalvo = removerAcentos(pessoa.getNome());  

            if(nomeContatoSalvo.toLowerCase().contains(nomeContato.toLowerCase())){
                return pessoa;
            }
        }
        return null;
    }

    public void buscaAvancada(String filtro, int opcaoBusca){
        // 1 - endereco, 2 - relacao

        for(int i=0; i<contatos.size(); i++){
            infocontato pessoa = contatos.get(i);

            switch(opcaoBusca){
                case 1:
                    String enderecoContato = pessoa.getEndereco().split(",")[0].trim();
                    if(enderecoContato.toLowerCase().contains(filtro.toLowerCase())){
                        System.out.println(pessoa.toString());
                        System.out.println("\n");
                    }
                    break;

                case 2:
                    if(pessoa.getRelacao().toLowerCase().contains(filtro.toLowerCase())){
                        System.out.println(pessoa.toString());
                        System.out.println("\n");
                    }
                    break;

                default:
                    System.out.println("\n[X] Digite uma opcao valida!\n");
                    break;
            }

        }

        System.out.println("\nBusca finalizada!\n");

    }

    public void salvarAgenda(){
        File arquivo = new File ("dadosDaAgenda.txt");

        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo))){

            for(int i=0; i<contatos.size(); i++){
                infocontato pessoa = contatos.get(i);
                escritor.write(pessoa.getNome() + ";" + 
                            pessoa.getTelefone() + ";" + 
                            pessoa.getEndereco() + ";" + 
                            pessoa.getRelacao());
                escritor.newLine();
            }

            System.out.println("\nOs dados da agenda foram salvos!\n\n");

        } catch(IOException erro) {
            System.out.println("\n[X] Erro ao salvar os dados da agenda: " + erro.getMessage());
        }

    }

    public void recuperarAgenda(){

        File arquivo = new File ("dadosDaAgenda.txt");

        try(BufferedReader reader = new BufferedReader(new FileReader(arquivo))){
            String linhaDoArquivo;
            while((linhaDoArquivo = reader.readLine()) != null){
                String[] dados = linhaDoArquivo.split(";");
                infocontato contato = new infocontato(dados[0], dados[1], dados[2], dados[3]);
                contatos.add(contato);
            }
            System.out.println("\nOs dados da agenda foram carregados!\n\n");
        } catch(IOException erro) {
            System.out.println("\n[X] Erro ao carregar os dados da agenda: " + erro.getMessage());
        }

    }

    public void apagarTodosContatos(){
        contatos.clear();
        System.out.println("\nTodos os contatos foram excluidos!\n\n");
    }

}