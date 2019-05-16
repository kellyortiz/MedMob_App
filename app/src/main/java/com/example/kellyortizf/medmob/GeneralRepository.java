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


}
