package projetofinal.celer.com.br.projetofinal.CadastroDeLogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import projetofinal.celer.com.br.projetofinal.CadastroDeGrupo.TelaDeCadastroDeGrupoListActivity;

import projetofinal.celer.com.br.projetofinal.R;


public class TelaDeLoginActivity extends Activity {
EditText edtUsuario, edtLogin, edtSenha;
Button btnConfirmar;
TextView tvCadastrarConta;
CadastroDAO cadastroDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_login);

         cadastroDAO = new CadastroDAO(this);

        edtUsuario = findViewById(R.id.TelaDeLogin_edtUsuario);
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
        });



    }

    public void entrar(View view) {
        String usuario = edtUsuario.getText().toString();
        String email = edtLogin.getText().toString();
        String senha = edtSenha.getText().toString();


        if (cadastroDAO.validarCadastro(usuario)) {
            Intent it = new Intent(this
                    , TelaDeCadastroDeGrupoListActivity.class);
            startActivity(it);

            Log.i("appmain", "passou pelo if");
        } else {
            Log.i("appmain", "passou pelo else");
            finish();


        }
    }

        public void cancelar(View view){
                finish();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("appmain","passou resume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("appmain","passou start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("appmain","passou pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("appmain","passou stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("appmain","passou destroy");
    }
}

