package view;

import controller.ClienteController;
import model.entity.Cliente;

import java.util.Scanner;

public class ClienteView {

    private ClienteController clienteController;

    public ClienteView(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

    public void setController(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

    private final Scanner scanner = new Scanner(System.in);


    public void menuCliente() {

        int op;

        do {
            System.out.println("+==============================+");
            System.out.println("|          MENU CLIENTE        |");
            System.out.println("+==============================+");
            System.out.println("| [1] Cadastrar um cliente     |");
            System.out.println("| [0] Sair                     |");
            System.out.println("+==============================+");
            System.out.print("Escolha uma opção: ");
            try {

                op = Integer.parseInt(scanner.nextLine());

                switch (op) {
                    case 1 -> {
                        cadastrar();
                    }
                    case 0 -> {
                        System.out.println("Saindo...");
                    }
                    default -> {
                        System.out.println("Opção incorreta!");
                    }
                }
            } catch (NumberFormatException n){
                System.out.println("Apenas números!");
                op = -1;
            }
        } while (op != 0);
    }

    public void cadastrar() {
        int id = 0;
        try {
            System.out.print("Digite o ID: ");
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException n) {
            System.out.println("Apenas números!");
        }
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();

        boolean sucesso = clienteController.cadastrar(id, nome, telefone);

        if (sucesso) {
            System.out.println("Sucesso ao cadastrar cliente");
        } else {
            System.out.println("Erro ao cadastrar cliente");
        }
    }
}