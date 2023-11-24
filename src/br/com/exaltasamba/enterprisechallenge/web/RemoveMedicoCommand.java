package br.com.exaltasamba.enterprisechallenge.web;

import br.com.exaltasamba.enterprisechallenge.domain.Medico.MedicoDao;
import br.com.exaltasamba.enterprisechallenge.utils.JsonUtils;

import java.util.Map;

public class RemoveMedicoCommand {

    public void execute(String jsonString) {

        Map<String, String> jsonObject = JsonUtils.parse(jsonString);

        MedicoDao medicoDao = new MedicoDao();
        medicoDao.excluiMedico(Integer.parseInt(jsonObject.get("id")));

    }
}
