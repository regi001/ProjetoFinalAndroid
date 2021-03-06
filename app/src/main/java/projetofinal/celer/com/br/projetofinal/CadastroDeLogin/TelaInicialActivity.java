package projetofinal.celer.com.br.projetofinal.CadastroDeLogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import projetofinal.celer.com.br.projetofinal.CadastroDeGrupo.TelaDeCadastroDeGrupoActivity;
import projetofinal.celer.com.br.projetofinal.CadastroDeGrupo.TelaDeCadastroDeGrupoListActivity;
import projetofinal.celer.com.br.projetofinal.R;

public class TelaInicialActivity extends Activity {

    Button btnLogin,btnCadastrarLogin,btnGrupo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        btnLogin = findViewById(R.id.telaInicial_btnLogin);
        btnCadastrarLogin = findViewById(R.id.telaInicial_btnLogin);
        btnGrupo = findViewById(R.id.telaInicial_chamarCadastrargrupo);
    }

    public void login (View view){
        Intent it= new Intent(TelaInicialActivity.this,TelaDeLoginActivity.class);
        startActivity(it);


    }

    public void cadastrarLogin (View view){
        Intent it= new Intent(TelaInicialActivity.this,TelaDeCadastroActivity.class);
        startActivity(it);
    }
    public void cadastrarGrupo (View view){
        Intent it= new Intent(TelaInicialActivity.this,TelaDeCadastroDeGrupoListActivity.class);
        startActivity(it);
    }


}
