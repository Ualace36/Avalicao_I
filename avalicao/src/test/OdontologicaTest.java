package test;

import odontologica.dao.ConfiguracaoJDBC;
import odontologica.dao.impl.EnderecoDaoImpl;
import odontologica.dao.impl.PacienteDaoImpl;
import odontologica.model.Endereco;
import odontologica.model.Paciente;
import odontologica.service.EnderecoService;
import odontologica.service.PacienteService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Date;

public class OdontologicaTest {
    private static Logger loger = Logger.getLogger(OdontologicaTest.class);
    ConfiguracaoJDBC configuracaoJDBC = new ConfiguracaoJDBC();
    private PacienteService pacienteService = new PacienteService(new PacienteDaoImpl(configuracaoJDBC));
    private EnderecoService enderecoService = new EnderecoService(new EnderecoDaoImpl(configuracaoJDBC));

    @Test
    public void testes() throws SQLException {
        configuracaoJDBC.reset();
        loger.debug("Testando os salvamento no banco de dados");
        pacienteService.salvar(new Paciente("Joao", "silva", "8482828/FT", new Date(),enderecoService.salvar(new Endereco("Rua rogerio da silva", "85A", "Terra do nunca", "Laranjeiras")).getId()));
        pacienteService.salvar(new Paciente("Mario", "costa", "84858458/FT", new Date(),enderecoService.salvar(new Endereco("Rua rogerio da costa", "88A", "Terra do nunca", "Laranjeiras")).getId()));
        pacienteService.salvar(new Paciente("Emanuel", "Lima", "89728/FT", new Date(),enderecoService.salvar(new Endereco("Rua carlos da silva", "21B", "Terra do nunca", "Laranjeiras")).getId()));

        int id = pacienteService.salvar(new Paciente("MARIA", "silva", "948528/FT", new Date(),enderecoService.salvar(new Endereco("Rua rogerio da silva", "85B", "Terra do nunca", "Laranjeiras")).getId())).getId();

        System.out.println(pacienteService.buscar(id).toString());

        pacienteService.excluir(id);

        pacienteService.buscar(id);


        System.out.println(pacienteService.buscar(1).toString());
        System.out.println(enderecoService.buscar(1).toString());
        System.out.println(pacienteService.buscar(2).toString());
        System.out.println(enderecoService.buscar(2).toString());
        System.out.println(pacienteService.buscar(3).toString());
        System.out.println(enderecoService.buscar(3).toString());
    }
}
