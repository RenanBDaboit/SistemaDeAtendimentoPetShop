package controller;

import model.entity.Atendimento;
import model.entity.Cliente;
import model.entity.Pet;
import model.repository.AtendimentoRepository;
import model.repository.ClienteRepository;
import model.repository.PetRepository;
import model.service.AtendimentoService;

import java.util.HashMap;

public class AtendimentoController {

    private final AtendimentoRepository atendimentoRepository;
    private final PetRepository petRepository;
    private final AtendimentoService atendimentoService = new AtendimentoService();
    private final ClienteRepository clienteRepository;

    public AtendimentoController(AtendimentoRepository atendimentoRepository, PetRepository petRepository, ClienteRepository clienteRepository) {
        this.atendimentoRepository = atendimentoRepository;
        this.petRepository = petRepository;
        this.clienteRepository = clienteRepository;

    }

    public boolean cadastrar(int id, int idPet, String servico, double valor, Atendimento.Status status) {
        return atendimentoService.cadastrar(id, idPet, servico, valor, petRepository, atendimentoRepository);
    }

    public boolean atualizarStatus(int id, Atendimento.Status status) {
        return atendimentoService.atualizarStatus(id, status);
    }

    public HashMap<Integer, Atendimento> listarAtendimento() {
        return atendimentoRepository.listar();
    }

    public HashMap<Integer, Cliente> listarCliente() {
        return clienteRepository.listar();
    }

    public HashMap<Integer, Pet> listarPet() {
        return petRepository.listar();
    }

    public boolean remover(int id) {
        return atendimentoService.remover(id, atendimentoRepository);
    }
}