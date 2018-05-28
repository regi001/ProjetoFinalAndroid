package projetofinal.celer.com.br.projetofinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaDeLoginActivity extends Activity {
EditText edtLogin, edtSenha;
Button btnConfirmar;
TextView tvCadastrarConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_login);

        edtLogin = findViewById(R.id.TelaDeLogin_edtLogin);
        edtSenha = findViewById(R.id.TelaDeLogin_edtSenha);
        btnConfirmar = findViewById(R.id.TelaDeLogin_btnEntrar);
        tvCadastrarConta = findViewById(R.id.TelaDeLogin_tvCadstrarNovaConta);

        tvCadastrarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(TelaDeLoginActivity.this,TelaDeCadastroActivity.class);
                startActivity(it);
            }
        });{


        }
    }
}
