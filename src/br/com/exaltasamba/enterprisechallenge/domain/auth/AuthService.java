package br.com.exaltasamba.enterprisechallenge.domain.auth;

public class AuthService {

    private final UsuarioDao usuarioDAO;

    public AuthService(UsuarioDao usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario autentica(String username, String senha) {
        String hashSenha = AuthUtils.hash256(senha);
        Usuario usuario = usuarioDAO.findByUsername(username);

        if (usuario == null) {
            throw new AuthException("Usuário '" + username + "' não encontrado.");
        }

        if (!usuario.getHashSenha().equals(hashSenha)) {
            throw new AuthException("Senha do usuário '" + username + "' é inválida.");
        }

        return usuario;
    }

}
