package controller;

import model.repository.ClienteRepository;
import model.service.ClienteService;

public class ClienteController {

    private final ClienteRepository repository;
    private final ClienteService service = new ClienteService();

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    public boolean cadastrar(int id, String nome, String telefone) {
        return service.cadastrar(id, nome, telefone, repository);
    }
}
