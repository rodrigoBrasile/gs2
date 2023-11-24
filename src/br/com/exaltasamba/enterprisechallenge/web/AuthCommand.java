package br.com.exaltasamba.enterprisechallenge.web;

import br.com.exaltasamba.enterprisechallenge.domain.auth.AuthService;
import br.com.exaltasamba.enterprisechallenge.domain.auth.Usuario;
import br.com.exaltasamba.enterprisechallenge.domain.auth.UsuarioDao;
import br.com.exaltasamba.enterprisechallenge.utils.JsonUtils;
import br.com.exaltasamba.enterprisechallenge.utils.JwtTokenUtil;

import java.util.Map;

public class AuthCommand {
    public String execute(String jsonString) {

        Map<String, String> jsonObject = JsonUtils.parse(jsonString);

        String username = jsonObject.get("username");
        String senha = jsonObject.get("senha");

        AuthService authService = new AuthService(new UsuarioDao());

        Usuario usuario = authService.autentica(username, senha);

        var usuarioDto = new UsuarioDto(usuario.getUsername(), usuario.getPerfil(), JwtTokenUtil.generateToken(usuario.getUsername()));
        return JsonUtils.serialize(usuarioDto);
    }
}
