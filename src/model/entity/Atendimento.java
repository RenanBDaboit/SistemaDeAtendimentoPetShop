package model.entity;

public class Atendimento {

    private int id;
    private Pet pet;
    private String servico;
    private double valor;
    public enum Status{
        AGENDADO,
        EM_ATENDIMENTO,
        FINALIZADO,
        CANCELADO
    }
    
    public Status status;

    public Atendimento(Pet pet, int id, String servico, double valor, Status status) {
        this.pet = pet;
        this.id = id;
        this.servico = servico;
        this.valor = valor;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "id=" + id +
                ", pet=" + pet +
                ", servico='" + servico + '\'' +
                ", valor=" + valor +
                ", status=" + status +
                '}';
    }
}
