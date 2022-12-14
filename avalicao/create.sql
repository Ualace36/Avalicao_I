DROP TABLE IF EXISTS paciente;
DROP TABLE IF EXISTS endereco;
CREATE TABLE IF NOT EXISTS endereco(
    id INT AUTO_INCREMENT PRIMARY KEY,
    rua VARCHAR(300) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    cidade VARCHAR(300) NOT NULL,
    bairro VARCHAR(300) NOT NULL
);
CREATE TABLE IF NOT EXISTS paciente(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(300) NOT NULL,
    sobrenome VARCHAR(300) NOT NULL,
    RG varchar(50) NOT NULL,
    DataCadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    idEndereco INT NOT NULL,
    FOREIGN KEY (idEndereco) REFERENCES endereco(id)
);