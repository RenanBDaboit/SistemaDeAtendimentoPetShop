package model.service;

import model.entity.Atendimento;
import model.entity.Pet;
import model.repository.AtendimentoRepository;
import model.repository.PetRepository;

public class AtendimentoService {

    public boolean cadastrar(int id, int idPet, String servico, double valor, Atendimento.Status status, PetRepository petRepository, AtendimentoRepository repository){

        boolean petExistente = false;
        Pet petCadastrar = null;

        for (Atendimento atendimento : repository.listar().values()){
            if (atendimento.getId() == id){
                return false;
            }
        }

        for (Pet pet : petRepository.listar().values()){
            if (pet.getId() == idPet){
                petExistente = true;
                petCadastrar = pet;
            }
        }

        if (!petExistente){
            return false;
        }

        if (servico.isBlank()){
            return false;
        }

        if (valor < 0){
            return false;
        }

        repository.salvar(new Atendimento(petCadastrar, id, servico, valor, status));
        return true;
    }

    public boolean atualizarStatus(int id, Atendimento.Status status, AtendimentoRepository repository){

        boolean idExistente = false;


        for (Atendimento atendimento :repository.listar().values()){
            if (atendimento.getId() == id){
                idExistente = true;
                if (atendimento.getStatus().equals(Atendimento.Status.CANCELADO) && status.equals(Atendimento.Status.FINALIZADO)){
                    return false;
                }
                if (atendimento.getStatus().equals(Atendimento.Status.FINALIZADO) && status.equals(Atendimento.Status.CANCELADO)){
                    return false;
                }
            }
        }

        if (!idExistente){
            return false;
        }

        repository.atualizarStatus(id, status);
        return true;
    }

    public boolean atualizar(int id, int idPet, String servico, double valor, Atendimento.Status status, PetRepository petRepository, AtendimentoRepository repository){

        boolean idExistente = false;
        boolean petExistente = false;
        Pet petCadastrar = null;

        for (Atendimento atendimento : repository.listar().values()){
            if (atendimento.getId() == id){
                idExistente = true;
            }
        }

        for (Pet pet : petRepository.listar().values()){
            if (pet.getId() == idPet){
                petExistente = true;
                petCadastrar = pet;
            }
        }

        if (!idExistente){
            return false;
        }

        if (!petExistente){
            return false;
        }

        if (servico.isBlank()){
            return false;
        }

        if (valor < 0){
            return false;
        }

        repository.atualizar(new Atendimento(petCadastrar, id, servico, valor, status));
        return true;
    }

    public boolean cancelar(int id, AtendimentoRepository repository){

        boolean idExistente = false;

        for (Atendimento atendimento : repository.listar().values()){
            if (atendimento.getId() == id && !(atendimento.getStatus().equals(Atendimento.Status.FINALIZADO))) {
                idExistente = true;
            }
        }

        if (!idExistente){
            return false;
        }

        repository.listar().get(id).setStatus(Atendimento.Status.CANCELADO);
        return true;
    }

    public boolean finalizar(int id, AtendimentoRepository repository){

        boolean idExistente = false;

        for (Atendimento atendimento : repository.listar().values()){
            if (atendimento.getId() == id && !(atendimento.getStatus().equals(Atendimento.Status.CANCELADO))) {
                idExistente = true;
            }
        }

        if (!idExistente){
            return false;
        }

        repository.listar().get(id).setStatus(Atendimento.Status.FINALIZADO);
        return true;
    }

    public boolean remover(int id, AtendimentoRepository repository){

        boolean idExistente = false;

        for (Atendimento atendimento : repository.listar().values()){
            if (atendimento.getId() == id && !(atendimento.getStatus().equals(Atendimento.Status.EM_ATENDIMENTO))) {
                idExistente = true;
            }
        }

        if (!idExistente){
            return false;
        }

        repository.remover(id);
        return true;
    }
}
