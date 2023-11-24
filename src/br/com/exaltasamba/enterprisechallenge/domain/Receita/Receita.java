package br.com.exaltasamba.enterprisechallenge.domain.Receita;

import java.time.LocalDate;

public class Receita {
    private int id;
    private int idPaciente;
    private int idMedico;
    private LocalDate dataEmissao;


    public Receita(int id, int idPaciente, int idMedico, LocalDate dataEmissao) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.dataEmissao = dataEmissao;
    }

    public Receita() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

}
