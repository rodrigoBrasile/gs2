package br.com.exaltasamba.enterprisechallenge.web;

import br.com.exaltasamba.enterprisechallenge.domain.Medico.Medico;
import br.com.exaltasamba.enterprisechallenge.domain.Medico.MedicoDao;
import br.com.exaltasamba.enterprisechallenge.utils.JsonUtils;

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


public class CadastraMedicoCommand {
    public void execute(String jsonString) {

        Map<String, String> jsonObject = JsonUtils.parse(jsonString);

        MedicoDao medicoDao = new MedicoDao();

        Medico medico = new Medico(jsonObject.get("nome"), jsonObject.get("crm"), Integer.parseInt(jsonObject.get("idUsuario")));
        medicoDao.insereMedico(medico);

    }
}
