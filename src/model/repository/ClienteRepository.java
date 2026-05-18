package model.repository;

import model.entity.Cliente;

import java.util.HashMap;

public class ClienteRepository {

    private final HashMap<Integer, Cliente> clientes = new HashMap<>();

    public void cadastrar(Cliente cliente){
        clientes.put(cliente.getId(), cliente);
    }

    public Cliente buscarPorId(int id){
        return clientes.get(id);
    }

    public HashMap<Integer, Cliente> listar(){
        return clientes;
    }
}
