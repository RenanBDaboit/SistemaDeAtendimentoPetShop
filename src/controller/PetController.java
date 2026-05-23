package controller;

import model.repository.ClienteRepository;
import model.repository.PetRepository;
import model.service.PetService;

public class PetController {
    private final PetRepository petRepository;
    private final ClienteRepository clienteRepository;
    private final PetService service = new PetService();

    public PetController(PetRepository petRepository, ClienteRepository clienteRepository) {
        this.petRepository = petRepository;
        this.clienteRepository = clienteRepository;
    }

    public boolean cadastrar(int id, String nome, String especie, int idCliente) {
        return service.cadastrar(id, nome, especie, idCliente, clienteRepository, petRepository);
    }
}