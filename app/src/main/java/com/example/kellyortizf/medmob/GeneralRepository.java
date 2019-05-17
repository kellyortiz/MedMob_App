package com.example.kellyortizf.medmob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public class GeneralRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void cadastraUsuário(String nome, String cpf, String endereco, String cep, String dataNascimento, String telefone, String sexo){
        jdbcTemplate.update("INSERT INTO Cliente(Nome, CPF, Endereco, CEP, Data Nascimento, Telefone, Sexo) VALUES(?, ?, ?, ?, ?, ?, ?);",
                nome, cpf, endereco, cep, dataNascimento, telefone, sexo);
    }

    @Transactional
    public void cadastraLogin(String password, String email){
        jdbcTemplate.update("INSERT INTO Usuarios(Senha, Email) VALUES(?, ?);",
                password, email);
    }

    @Transactional
    public void cadastraRemedio(String nome, String dosagem, String adicional){
        jdbcTemplate.update("INSERT INTO Medicamento(Nome, Dosagem, Adicional) VALUES(?, ?, ?, ?);",
                nome, dosagem, adicional);
    }

    @Transactional
    public boolean realizaLogin(String email, String password){
       int count =  jdbcTemplate.queryForObject("SELECT Email, Senha FROM Usuarios WHERE Email = ? AND Senha = ?);",
               new Object[]{email, password}, Integer.class);
       if(count > 0){
           return true;
       } else {
           return false;
       }
    }

    @Transactional
    public void cadastraFichaMedica(String tipoSanguineo, boolean diabetes, boolean pressao, String alergias, String observacao){
        jdbcTemplate.update("INSERT INTO Medicamento(Tipo Sanguineo, Diabetes, Pressao, Alergias, Observacoes) VALUES(?, ?, ?, ?, ?);",
                tipoSanguineo, diabetes, pressao, alergias, observacao);
    }

}
