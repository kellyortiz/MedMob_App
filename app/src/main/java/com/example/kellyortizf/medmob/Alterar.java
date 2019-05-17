import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.kellyortizf.medmob.BancoController;
import com.example.kellyortizf.medmob.CriaBanco;
import com.example.kellyortizf.medmob.R;


public class Alterar extends Activity {
    EditText nomeUsuario;
    EditText autor;
    EditText editora;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alterarmeusdados);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BancoController(getBaseContext());

        nomeUsuario = (EditText)findViewById(R.id.editText);
        enderecoUsuario = (EditText)findViewById(R.id.editText2);
        telefone = (EditText)findViewById(R.id.editText3);
        cep = (EditText)findViewById(R.id.editText6);

        alterar = (Button)findViewById(R.id.button2);

        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        nomeUsuario.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.NOME)));
        enderecoUsuario.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.ENDERECO)));
        telefone.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.TELEFONE)));
        cep.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.CEP)));

    }
}