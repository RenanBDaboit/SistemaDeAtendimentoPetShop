package model.service;

import model.entity.Cliente;
import model.entity.Pet;
import model.repository.ClienteRepository;
import model.repository.PetRepository;

public class PetService {

    public boolean cadastrar(int id, String nome, String especie, int idCliente, ClienteRepository clienteRepository, PetRepository repository){

        boolean clienteExitente = false;
        Cliente clienteCadastrar = null;

        for (Pet pet : repository.listar().values()){
            if (pet.getId() == id){
                return false;
            }
        }

        if (nome.isBlank()){
            return false;
        }

        if (especie.isBlank()){
            return false;
        }

        for (Cliente cliente : clienteRepository.listar().values()){
            if (cliente.getId() == idCliente){
                clienteExitente = true;
                clienteCadastrar = cliente;
            }
        }

        if (!clienteExitente){
            return false;
        }

        repository.cadastrar(new Pet(id, nome, especie, clienteCadastrar));
        return true;
    }
}
