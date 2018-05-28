package projetofinal.celer.com.br.projetofinal;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class TelaDeCadastroActivity extends Activity {
    EditText edtNome, edtEmail, edtSenha;
    Button btnSalvar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_cadastro);

        edtNome = findViewById(R.id.telaDeCadastro_edtNome);
        edtEmail = findViewById(R.id.telaDeCadastro_edtEmail);
        edtSenha = findViewById(R.id.telaDeCadastro_edtSenha);


    }
}
