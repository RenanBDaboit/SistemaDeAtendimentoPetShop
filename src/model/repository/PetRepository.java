package model.repository;

import model.entity.Pet;

import java.util.HashMap;

public class PetRepository {

    private final HashMap<Integer, Pet> pets = new HashMap<>();

    public void cadastrar(Pet pet) {
        pets.put(pet.getId(), pet);
    }

    public Pet buscarPorId(int id){
        return pets.get(id);
    }

    public HashMap<Integer, Pet> listar(){
        return pets;
    }
}
