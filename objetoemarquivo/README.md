# Sistema de Cadastro de Clientes

Este é um sistema simples de cadastro de clientes em Java, utilizando serialização para salvar e carregar dados de clientes em arquivos. O objetivo deste projeto é demonstrar como trabalhar com arquivos utilizando objetos em Java de maneira prática.

- Link do Notion com mais detalhes: `https://lizard-party-865.notion.site/Arquivo-em-Java-Maneira-Pr-tica-8c5ecf66f457444583b433b3c44dc693`

## Funcionalidades

- Cadastrar novos clientes.
- Mostrar todos os clientes cadastrados.
- Buscar clientes pelo CPF.
- Salvar e carregar automaticamente os clientes em um arquivo.

## Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **Serialização**: Para salvar e carregar dados de objetos em arquivos.

## Estrutura do Projeto

- `Cliente`: Classe que representa o cliente, com atributos como nome, CPF, idade e ID.
- `PessoaFisica`: Superclasse de `Cliente`, que contém atributos básicos como nome, idade e CPF.
- Métodos para manipular a lista de clientes:
  - `salvarClientes()`: Serializa e salva a lista de clientes no arquivo.
  - `carregarClientes()`: Desserializa e carrega a lista de clientes do arquivo.

## Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/davicardoso5524/Arquivo-em-Java

2. Compile e execute o programa em sua IDE Java ou via terminal:
```bash
`javac App.java`
`java App`

