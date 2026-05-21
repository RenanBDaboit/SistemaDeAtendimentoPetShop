package model.service;

import model.entity.Cliente;
import model.repository.ClienteRepository;

public class ClienteService {

    public boolean cadastrar(int id, String nome, String telefone, ClienteRepository repository){

        for (Cliente cliente : repository.listar().values()){
            if (cliente.getId() == id){
                return false;
            }
            if (cliente.getTelefone().equals(telefone)){
                return false;
            }
        }

        if (nome.isBlank()){
            return false;
        }

        repository.cadastrar(new Cliente(id, nome, telefone));
        return true;
    }
}
