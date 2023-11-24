package br.com.exaltasamba.enterprisechallenge.domain.auth;

public class Usuario {

    private int id;

    private String username;
    private String hashSenha;
    private String perfil;

    public Usuario(int id, String username, String hashSenha, String perfil) {
        this.id = id;
        this.username = username;
        this.hashSenha = hashSenha;
        this.perfil = perfil;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public String getPerfil() {
        return perfil;
    }
}
