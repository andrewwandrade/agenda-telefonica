# Agenda Telefonica - Trabalho 1
- Segundo trabalho de implementação de Paradigmas de Programação.

## Objetivo
- Implementar uma agenda telefônica utilizando uma lista ou um vetor de objetos. Ela deve permitir adicionar buscar, editar ou remover os contatos. Além disso, também deve ser possível salvar e recuperar dados da agenda de um arquivo.

## Estruturação de Arquivos

- infocontato.java: Define a classe contato com os atributos nome, telefone, endereço e relação e alguns métodos;
- agenda.java: Define a classe agenda, responsável por gerenciar a lista de contatos. As funcionalidades de adicionar/remover contatos, alteração de dados, salvar/recuperar agenda, por exemplo, são definidas nessa classe;
- principal.java: Armazena a main e permite a interação com o usuário, permitindo chamar cada um dos métodos definidos na classe agenda;
- dadosDaAgenda.txt: Responsável por armazenar os dados quando o usuário salva os contatos e, também, recupera-os.

## Funcionalidades

- Adicionar contatos;
- Exibir todos os contatos armazenados;
- Buscar contatos por nome;
- Filtrar contatos por endereço ou relação;
- Alterar informações de contatos;
- Remover algum contato específico da agenda;
- Salvar dados da agenda em um arquivo no formato txt;
- Recuperar os dados salvos anteriormente;
- Apagar todos os contatos.

## Observações

- O programa ignora acentos em nomes para facilitar a busca;
- É interessante que os números de telefone possuam 11 dígitos para serem formatados corretamente;
- Caso um contato já exista, ele será atualizado ao invés de ser duplicado.