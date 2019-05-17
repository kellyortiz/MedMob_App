package com.example.kellyortizf.medmob;

import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import org.springframework.beans.factory.annotation.Autowired;

import static android.content.ContentValues.TAG;


public class CadastroController {

    @Autowired
    GeneralRepository repository;

    String sexo;
    String nome;
    String cpf;
    String dataNascimento;
    String telefone;
    String endereco;
    String cep;


    public void btnSend(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        EditText textoNome = view.findViewById(R.id.campo_nome);
        this.nome = textoNome.getText().toString();

        EditText textoEndereco = view.findViewById(R.id.editText6);
        this.endereco = textoEndereco.getText().toString();

        EditText data = view.findViewById(R.id.campoDataNasc);
        this.dataNascimento = data.getText().toString();

        EditText tel = view.findViewById(R.id.editText4);
        this.telefone = data.getText().toString();

        EditText cepText = view.findViewById(R.id.editText5);
        this.cep = data.getText().toString();

        EditText cpfText = view.findViewById(R.id.campo_cpf);
        this.cpf = data.getText().toString();


        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton_feminino:
                if (checked)
                    this.sexo = "Feminino";
                break;
            case R.id.radioButton_masculino:
                if (checked)
                    this.sexo = "Masculino";
                break;
        }

        repository.cadastraUsuário(nome, cpf, endereco, cep, dataNascimento, telefone, sexo);
    }
}