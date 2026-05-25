package view;

import controller.AtendimentoController;
import controller.ClienteController;
import controller.PetController;
import model.repository.AtendimentoRepository;
import model.repository.ClienteRepository;
import model.repository.PetRepository;

import java.util.Scanner;

public class View {
    private final Scanner scanner = new Scanner(System.in);

    private final ClienteRepository clienteRepository = new ClienteRepository();
    private final PetRepository petRepository = new PetRepository();
    private final AtendimentoRepository atendimentoRepository = new AtendimentoRepository();

    private final ClienteController clienteController = new ClienteController(clienteRepository);
    private final PetController petController = new PetController(petRepository, clienteRepository);
    private final AtendimentoController atendimentoController = new AtendimentoController(atendimentoRepository, petRepository, clienteRepository);

    private final ClienteView clienteView = new ClienteView(clienteController);
    private final PetView petView = new PetView(petController, clienteController, petRepository, clienteRepository);
    private final AtendimentoView atendimentoView = new AtendimentoView(atendimentoController, atendimentoRepository, petRepository, clienteRepository);

    public void menuPrincipal() {
        int op = 0;

        do {
            System.out.println("+=====================================+");
            System.out.println("|            MENU PRINCIPAL           |");
            System.out.println("+=====================================+");
            System.out.println("| [1] Clientes                        |");
            System.out.println("| [2] Pets                            |");
            System.out.println("| [3] Atendimentos                    |");
            System.out.println("| [0] Sair                            |");
            System.out.println("+=====================================+");
            System.out.print("Escolha uma opção: ");
            try {
                op = Integer.parseInt(scanner.nextLine());

                switch (op) {
                    case 1 -> {
                        clienteView.menuCliente();
                    }
                    case 2 -> {
                        petView.menuPet();
                    }
                    case 3 -> {
                        atendimentoView.menuAtendimento();
                    }
                    case 0 -> {
                        System.out.println("Saindo...");
                    }
                    default -> {
                        System.out.println("Opção incorreta!");
                    }
                }

            } catch (NumberFormatException n) {
                System.out.println("Apenas números!");
            }
        }while (op != 0) ;
    }
}
