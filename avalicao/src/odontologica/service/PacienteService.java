package odontologica.service;

import odontologica.dao.IDao;
import odontologica.model.Paciente;

public class PacienteService {
    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente salvar(Paciente paciente){
        return pacienteIDao.salvar(paciente);
    }

    public Paciente buscar(int id){
        return pacienteIDao.buscar(id);
    }

    public void excluir(int id){
        pacienteIDao.excluir(id);
    }

    public Paciente modificar(Paciente paciente){
        return pacienteIDao.modificar(paciente);
    }
}
