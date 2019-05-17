package com.example.kellyortizf.medmob;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import org.springframework.beans.factory.annotation.Autowired;


public class CadastroController {

    @Autowired
    GeneralRepository repository;

    public void btnSend(View view) {

        String sexo;
        String nome;
        String cpf;
        String dataNascimento;
        String telefone;
        String endereco;
        String cep;


        boolean checked = ((RadioButton) view).isChecked();

        EditText textoNome = view.findViewById(R.id.campo_nome);
        nome = textoNome.getText().toString();

        EditText textoEndereco = view.findViewById(R.id.editText6);
        endereco = textoEndereco.getText().toString();

        EditText data = view.findViewById(R.id.campoDataNasc);
        dataNascimento = data.getText().toString();

        EditText tel = view.findViewById(R.id.editText4);
        telefone = data.getText().toString();

        EditText cepText = view.findViewById(R.id.editText5);
        cep = data.getText().toString();

        EditText cpfText = view.findViewById(R.id.campo_cpf);
        cpf = data.getText().toString();


        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton_feminino:
                if (checked)
                    sexo = "Feminino";
                break;
            case R.id.radioButton_masculino:
                if (checked)
                    sexo = "Masculino";
                break;
        }

        repository.cadastraUsuário(nome, cpf, endereco, cep, dataNascimento, telefone, sexo);
    }


    public void onClickRemedio(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        String nomeRemedio;
        String dosagem;
        String adicional;

        EditText textoNomeRemedio = view.findViewById(R.id.nome_medicamento);
        nomeRemedio = textoNomeRemedio.getText().toString();

        EditText textoDosagem = view.findViewById(R.id.textView25);
        dosagem = textoDosagem.getText().toString();

        EditText textoAdicional = view.findViewById(R.id.textView29);
        adicional = textoAdicional.getText().toString();


        repository.cadastraRemedio(nomeRemedio, dosagem, adicional);
    }

}
