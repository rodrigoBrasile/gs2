package br.com.exaltasamba.enterprisechallenge.domain.Medico;

public class Medico {

    private int id;
    private String nome;
    private String crm;
    private int idUsuario;

    public Medico(int id, String nome, String crm, int idUsuario) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
        this.idUsuario = idUsuario;
    }

    public Medico(String nome, String crm, int idUsuario) {
        this.nome = nome;
        this.crm = crm;
        this.idUsuario = idUsuario;
    }

    public Medico() {
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
