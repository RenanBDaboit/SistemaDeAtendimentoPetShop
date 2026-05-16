package model.entity;

public class Pet {

    private int id;
    private String nome;
    private String especie;
    private Cliente cliente;

    public Pet(int id, String nome, String especie, Cliente cliente) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.cliente = cliente;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


}
