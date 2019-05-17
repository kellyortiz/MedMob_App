package com.example.kellyortizf.medmob;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginController {

    @Autowired
    GeneralRepository repository;

    String email;
    String senha;
    String confirmacao;

    public void onClickEntrar(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        EditText textoEmail = view.findViewById(R.id.email);
        this.email = textoEmail.getText().toString();

        EditText textoSenha = view.findViewById(R.id.textosenha);
        this.senha = textoSenha.getText().toString();


        if (repository.realizaLogin(email, senha)){
            //Login Realizado
        } else {
            //Login falhou!!
        }
    }

    public void onClickRegistraLogin(View view){

        EditText textoEmail = view.findViewById(R.id.editText);
        this.email = textoEmail.getText().toString();

        EditText textoSenha = view.findViewById(R.id.cadastroSenha);
        this.senha = textoSenha.getText().toString();

        EditText textoConfirmacao = view.findViewById(R.id.editText3);
        this.confirmacao = textoConfirmacao.getText().toString();

        if(senha == confirmacao){
            repository.cadastraLogin(senha, email);
        } else{
            // senhas não batem!!
        }
    }
}
