package odontologica.model;

import java.util.Date;

public class Paciente {
    int id;
    String nome;
    String sobrenome;
    String RG;
    Date date;
    int idEndereco;

    public Paciente(int id, String nome, String sobrenome, String RG, Date date, int idEndereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.RG = RG;
        this.date = date;
        this.idEndereco = idEndereco;
    }

    public Paciente(String nome, String sobrenome, String RG, Date date, int idEndereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.RG = RG;
        this.date = date;
        this.idEndereco = idEndereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", RG='" + RG + '\'' +
                ", date=" + date +
                ", idEndereco=" + idEndereco +
                '}';
    }
}
