package odontologica.service;

import odontologica.dao.IDao;
import odontologica.model.Endereco;

public class EnderecoService {
    private IDao<Endereco> enderecoIDao;

    public EnderecoService(IDao<Endereco> enderecoIDao) {
        this.enderecoIDao = enderecoIDao;
    }

    public Endereco salvar(Endereco endereco){
        return enderecoIDao.salvar(endereco);
    }

    public Endereco buscar(int id){
        return enderecoIDao.buscar(id);
    }

    public void excluir(int id){
        enderecoIDao.excluir(id);
    }

    public Endereco modificar(Endereco endereco){
        return enderecoIDao.modificar(endereco);
    }
}
