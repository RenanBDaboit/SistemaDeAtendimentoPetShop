package view;

import controller.ClienteController;
import controller.PetController;
import model.entity.Cliente;
import model.repository.ClienteRepository;
import model.repository.PetRepository;

import java.util.Scanner;

public class PetView {

    private PetController petController;
    private ClienteController clienteController;
    private PetRepository petRepository;
    private ClienteRepository clienteRepository;

    public PetView(PetController petController, ClienteController clienteController, PetRepository petRepository, ClienteRepository clienteRepository) {
        this.petController = petController;
        this.clienteController = clienteController;
        this.petRepository = petRepository;
        this.clienteRepository = clienteRepository;
    }

    public void setPetRepository(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public void setClienteRepository(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void setPetController(PetController petController) {
        this.petController = petController;
    }

    public void setClienteController(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

    private final Scanner scanner = new Scanner(System.in);


    public void menuPet() {

        int op;

        do {
            System.out.println("+==============================+");
            System.out.println("|           MENU PET           |");
            System.out.println("+==============================+");
            System.out.println("| [1] Cadastrar um pet         |");
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
        int idCliente = 0;

        try {
            System.out.print("Digite o ID: ");
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException n) {
            System.out.println("Apenas números!");
        }
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a espécie: ");
        String especie = scanner.nextLine();

        try {
            listarCliente();
            System.out.println("Digite o ID do dono");
            idCliente = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException n) {
            System.out.println("Apenas números!");
            idCliente = -1;
        }

        boolean sucesso = petController.cadastrar(id, nome, especie, idCliente);

        if (sucesso) {
            System.out.println("Sucesso ao cadastrar pet");
        } else {
            System.out.println("Erro ao cadastrar pet");
        }
    }

    public void listarCliente(){
        for (Cliente cliente : clienteRepository.listar().values()){
            System.out.println(cliente);
        }
    }
}