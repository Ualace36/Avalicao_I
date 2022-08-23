package odontologica.dao.impl;

import odontologica.dao.ConfiguracaoJDBC;
import odontologica.dao.IDao;
import odontologica.model.Endereco;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EnderecoDaoImpl implements IDao<Endereco> {
    private ConfiguracaoJDBC configuracaoJDBC;
    final static Logger log = Logger.getLogger(EnderecoDaoImpl.class);

    public EnderecoDaoImpl(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    @Override
    public Endereco salvar(Endereco endereco) {
        log.debug("Adicionando um novo endereço");
        Connection connection = configuracaoJDBC.conectarBD();
        Statement statement = null;
        String query = String.format("INSERT INTO endereco(rua,numero,cidade,bairro) VALUES('%s','%s','%s','%s')",
                endereco.getRua(),endereco.getNumero(),endereco.getCidade(),endereco.getBairro());
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
                endereco.setId(resultSet.getInt(1));

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return endereco;
    }

    @Override
    public Endereco buscar(int id) {
        log.debug("Buscando o endereco " + id);
        Connection connection = configuracaoJDBC.conectarBD();
        Statement statement = null;
        String query = String.format("SELECT * FROM endereco WHERE id='%s'",
                id);
        Endereco endereco = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()){
                endereco = new Endereco(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                );
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return endereco;
    }

    @Override
    public void excluir(int id) {
        log.debug("Excluindo o endereço " + id);
        Connection connection = configuracaoJDBC.conectarBD();
        Statement statement = null;
        String query = String.format("DELETE FROM endereco where id='%s'",
                id);
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Endereco modificar(Endereco endereco) {
        log.debug("Modificando os dados do endereço " + endereco.getId());
        Connection connection = configuracaoJDBC.conectarBD();
        Statement statement = null;
        String query = String.format("UPDATE endereco SET rua='%s',numero='%s',cidade='%s',bairro='%s' WHERE id='%s'",
            endereco.getRua(), endereco.getNumero(),endereco.getCidade(),endereco.getBairro());
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return endereco;
    }
}
