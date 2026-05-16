package model.entity;

public class Atendimento {

    private int id;
    private Pet pet;
    private String servico;
    private double valor;
    private String status;

    public Atendimento(Pet pet, int id, String servico, double valor, String status) {
        this.pet = pet;
        this.id = id;
        this.servico = servico;
        this.valor = valor;
        this.status = "Em andamento";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
