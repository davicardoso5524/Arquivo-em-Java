import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static final String ARQUIVO_CLIENTES = "clientes.ser";
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        carregarClientes();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- Sistema de Cadastro de Clientes -----");
            System.out.println("1. Cadastrar novo cliente");
            System.out.println("2. Mostrar todos os clientes");
            System.out.println("3. Buscar cliente por CPF");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;
                case 2:
                    mostrarClientes();
                    break;
                case 3:
                    buscarClientePorCpf(scanner);
                    break;
                case 4:
                    salvarClientes();
                    System.out.println("Sistema encerrado.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Método para cadastrar um novo cliente
    private static void cadastrarCliente(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        clientes.add(new Cliente(nome, cpf, idade));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    // Método para mostrar todos os clientes cadastrados
    private static void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("\nLista de clientes cadastrados:");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    // Método para buscar cliente pelo CPF
    private static void buscarClientePorCpf(Scanner scanner) {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                System.out.println("Cliente encontrado: " + cliente);
                return;
            }
        }
        System.out.println("Cliente com CPF " + cpf + " não encontrado.");
    }

    // Método para salvar a lista de clientes no arquivo
    private static void salvarClientes() {
        try (FileOutputStream fileOut = new FileOutputStream(ARQUIVO_CLIENTES);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(clientes);  // Serializa a lista de clientes
            System.out.println("Lista de clientes salva com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para carregar a lista de clientes do arquivo
    @SuppressWarnings("unchecked")
    private static void carregarClientes() {
        try (FileInputStream fileIn = new FileInputStream(ARQUIVO_CLIENTES);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            clientes = (ArrayList<Cliente>) in.readObject();  // Desserializa a lista de clientes
            System.out.println("Lista de clientes carregada com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum arquivo de clientes encontrado. Um novo será criado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
