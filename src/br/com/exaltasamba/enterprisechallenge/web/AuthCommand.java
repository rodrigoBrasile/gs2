package br.com.exaltasamba.enterprisechallenge.web;

import br.com.exaltasamba.enterprisechallenge.domain.auth.AuthService;
import br.com.exaltasamba.enterprisechallenge.domain.auth.Usuario;
import br.com.exaltasamba.enterprisechallenge.domain.auth.UsuarioDao;
import br.com.exaltasamba.enterprisechallenge.utils.JsonUtils;
import br.com.exaltasamba.enterprisechallenge.utils.JwtTokenUtil;

import java.util.Map;

/**
 * O padrão de design Command é uma alternativa eficaz para lidar com a ausência de um framework MVC (Model-View-Controller).
 * Ele proporciona uma maneira estruturada de encapsular solicitações como objetos, permitindo a parametrização de clientes
 * com diferentes solicitações, fila de comandos e suporte a operações desfazer.
 *
 * Ao utilizar o padrão Command, é possível separar a lógica de controle das ações do usuário (Controller) em objetos
 * Command, que encapsulam as operações a serem executadas. Isso promove a modularidade e facilita a extensibilidade do
 * código, permitindo a adição fácil de novos comandos sem modificar o código existente.
 *
 * Além disso, o Command permite a criação de uma arquitetura mais flexível e reutilizável, especialmente quando um
 * framework MVC completo não está disponível. Ele promove a separação de preocupações, facilitando a manutenção e
 * testabilidade do código.
 *
 * Recomenda-se o uso do padrão Command como uma abordagem pragmática para implementar um sistema de controle de fluxo
 * em situações em que a estrutura MVC completa não é viável ou desejada.
 */

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
