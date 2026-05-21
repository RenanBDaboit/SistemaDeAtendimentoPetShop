package model.repository;

import model.entity.Atendimento;

import java.util.HashMap;

public class AtendimentoRepository {

    private final HashMap<Integer, Atendimento> atendimentos = new HashMap<>();
    
    public void salvar(Atendimento atendimento){
        atendimentos.put(atendimento.getId(), atendimento);
    }

    public HashMap<Integer, Atendimento> listar(){
        return atendimentos;
    }

    public void remover(int id){
        atendimentos.remove(id);
    }
}
