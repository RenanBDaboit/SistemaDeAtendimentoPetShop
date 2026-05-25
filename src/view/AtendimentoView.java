package view;

import controller.AtendimentoController;
import model.entity.Atendimento;
import model.entity.Cliente;
import model.entity.Pet;
import model.repository.AtendimentoRepository;
import model.repository.ClienteRepository;
import model.repository.PetRepository;

import java.util.Scanner;

public class AtendimentoView {

    private final Scanner scanner = new Scanner(System.in);

    private AtendimentoController atendimentoController;

    private AtendimentoRepository atendimentoRepository;
    private PetRepository petRepository;
    private ClienteRepository clienteRepository;

    public AtendimentoView(AtendimentoController atendimentoController, AtendimentoRepository atendimentoRepository, PetRepository petRepository, ClienteRepository clienteRepository) {
        this.atendimentoController = atendimentoController;
        this.atendimentoRepository = atendimentoRepository;
        this.petRepository = petRepository;
        this.clienteRepository = clienteRepository;
    }

    public void setAtendimentoController(AtendimentoController atendimentoController) {
        this.atendimentoController = atendimentoController;
    }

    public void setAtendimentoRepository(AtendimentoRepository atendimentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
    }

    public void setPetRepository(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public void setClienteRepository(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void menuAtendimento() {

        int op;

        do {
            System.out.println("+==============================+");
            System.out.println("|        MENU ATENDMENTO       |");
            System.out.println("+==============================+");
            System.out.println("| [1] Realizar um atendimento  |");
            System.out.println("| [2] Listar atendimentos      |");
            System.out.println("| [3] Atualizar status         |");
            System.out.println("| [4] Remover entrega          |");
            System.out.println("| [0] Sair                     |");
            System.out.println("+==============================+");
            System.out.print("Escolha uma opção: ");
            try {

                op = Integer.parseInt(scanner.nextLine());

                switch (op) {
                    case 1 -> {
                        cadastrar();
                    }
                    case 2 -> {
                        listarAtendimento();
                    }
                    case 3 -> {
                        atualizarStatus();
                    }
                    case 4 -> {
                        remover();
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
        int idPet = 0;
        double valor = 0;

        try {
            System.out.print("Digite o ID: ");
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException n) {
            System.out.println("Apenas números!");
            id = -1;
        }

        try {
            listarPet();
            System.out.print("Digite o ID do pet: ");
            idPet = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException n) {
            System.out.println("Apenas números!");
            idPet = -1;
        }

        System.out.print("Digite o serviço: ");
        String servico = scanner.nextLine();

        try {
            System.out.print("Digite o valor: ");
            valor = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException n) {
            System.out.println("Apenas números!");
            valor = -1;
        }

        boolean sucesso = atendimentoController.cadastrar(id, idPet, servico, valor, Atendimento.Status.AGENDADO);

        if (sucesso) {
            System.out.println("Sucesso ao cadastrar atendimento");
        } else {
            System.out.println("Erro ao cadastrar atendimento");
        }
    }

    public void listarAtendimento(){
        for (Atendimento atendimento : atendimentoRepository.listar().values()){
            System.out.println(atendimento);
        }
    }

    public void listarPet(){
        for (Pet pet : petRepository.listar().values()){
            System.out.println(pet);
        }
    }

    public void atualizarStatus() {
        int id;
        int novoStatus;
        Atendimento.Status status;

        try {
            listarAtendimento();
            System.out.print("Digite o ID: ");
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException n) {
            System.out.println("Apenas números!");
            id = -1;
        }

        try {
            System.out.println("Selecione o status:");
            System.out.println("1. AGENDADO");
            System.out.println("2. EM ATENDIMENTO");
            System.out.println("3. FINALIZADO");
            System.out.println("4. CANCELADO");
            novoStatus = Integer.parseInt(scanner.nextLine());

            switch (novoStatus){
                case 1:
                    status = Atendimento.Status.AGENDADO;
                    break;

                case 2:
                    status = Atendimento.Status.EM_ATENDIMENTO;
                    break;

                case 3:
                    status = Atendimento.Status.FINALIZADO;
                    break;

                case 4:
                    status = Atendimento.Status.CANCELADO;
                    break;

                default:
                    throw new NumberFormatException();
            }

        } catch (NumberFormatException n) {
            System.out.println("Selecione uma opção correta");
            status = null;
        }

        boolean sucesso = atendimentoController.atualizarStatus(id, status);

        if (sucesso){
            System.out.println("Sucesso ao alterar status do atendimento");
        }
        else {
            System.out.println("Inválida a troca de status");
        }
    }

    public void remover(){
        int id;

        try {
            listarAtendimento();
            System.out.print("Digite o ID: ");
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException n) {
            System.out.println("Apenas números!");
            id = -1;
        }

        atendimentoController.remover(id);
    }
}