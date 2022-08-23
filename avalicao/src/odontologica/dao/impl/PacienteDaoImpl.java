package odontologica.dao.impl;

import odontologica.dao.ConfiguracaoJDBC;
import odontologica.dao.IDao;
import odontologica.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PacienteDaoImpl implements IDao<Paciente> {
    private ConfiguracaoJDBC configuracaoJDBC;
    final static Logger log = Logger.getLogger(PacienteDaoImpl.class);

    public PacienteDaoImpl(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    @Override
    public Paciente salvar(Paciente paciente) {
        log.debug("Adicionando um novo paciente");
        Connection connection = configuracaoJDBC.conectarBD();
        Statement statement = null;
        String query = String.format("INSERT INTO paciente(nome,sobrenome,RG,idEndereco) VALUES('%s','%s','%s','%s')",
                paciente.getNome(),paciente.getSobrenome(),paciente.getRG(),paciente.getIdEndereco());
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
                paciente.setId(resultSet.getInt(1));

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Paciente buscar(int id) {
        log.debug("Buscando o paciente " + id);
        Connection connection = configuracaoJDBC.conectarBD();
        Statement statement = null;
        String query = String.format("SELECT * FROM paciente WHERE id='%s'",
                id);
        Paciente paciente = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next())
                paciente = new Paciente(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getInt(6)
                );
            if(paciente == null){
                throw new Exception("Paciente não encontrado!");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public void excluir(int id) {
        log.debug("Excluindo o paciente " + id);
        Connection connection = configuracaoJDBC.conectarBD();
        Statement statement = null;
        String query = String.format("DELETE FROM paciente where id='%s'",
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
    public Paciente modificar(Paciente paciente) {
        log.debug("Modificando os dados do paciente " + paciente.getId());
        Connection connection = configuracaoJDBC.conectarBD();
        Statement statement = null;
        String query = String.format("UPDATE paciente SET nome='%s',sobrenome='%s',RG='%s',idEndereco='%s' WHERE id='%s'",
                paciente.getNome(),paciente.getSobrenome(),paciente.getRG(),paciente.getIdEndereco(),paciente.getId());
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }

}
