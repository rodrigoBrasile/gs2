package br.com.exaltasamba.enterprisechallenge.web;

import br.com.exaltasamba.enterprisechallenge.domain.Medico.Medico;
import br.com.exaltasamba.enterprisechallenge.domain.Medico.MedicoDao;
import br.com.exaltasamba.enterprisechallenge.utils.JsonUtils;

import java.util.List;
import java.util.Map;

public class ListaMedicosCommand {
    public String execute(String jsonString) {
        MedicoDao medicoDao = new MedicoDao();
        List<Medico> medicos = medicoDao.listaMedicos();
        return JsonUtils.serialize(medicos);
    }
}
