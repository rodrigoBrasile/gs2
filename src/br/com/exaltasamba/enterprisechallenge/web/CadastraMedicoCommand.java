package br.com.exaltasamba.enterprisechallenge.web;

import br.com.exaltasamba.enterprisechallenge.domain.Medico.Medico;
import br.com.exaltasamba.enterprisechallenge.domain.Medico.MedicoDao;
import br.com.exaltasamba.enterprisechallenge.utils.JsonUtils;

import java.util.Map;

public class CadastraMedicoCommand {
    public void execute(String jsonString) {

        Map<String, String> jsonObject = JsonUtils.parse(jsonString);

        MedicoDao medicoDao = new MedicoDao();

        Medico medico = new Medico(jsonObject.get("nome"), jsonObject.get("crm"), Integer.parseInt(jsonObject.get("idUsuario")));
        medicoDao.insereMedico(medico);

    }
}
