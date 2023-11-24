package br.com.exaltasamba.enterprisechallenge.domain.Receita;

public class DetalheReceita {
    private int id;
    private int idReceita;
    private String remedio;
    private Float dosagem;
    private Float frequencia;
    private String prazo;


    public DetalheReceita(int id, int idReceita, String remedio, Float dosagem, Float frequencia, String prazo) {
        this.id = id;
        this.idReceita = idReceita;
        this.remedio = remedio;
        this.dosagem = dosagem;
        this.frequencia = frequencia;
        this.prazo = prazo;
    }

    public DetalheReceita() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public String getRemedio() {
        return remedio;
    }

    public void setRemedio(String remedio) {
        this.remedio = remedio;
    }

    public Float getDosagem() {
        return dosagem;
    }

    public void setDosagem(Float dosagem) {
        this.dosagem = dosagem;
    }

    public Float getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Float frequencia) {
        this.frequencia = frequencia;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }
}
