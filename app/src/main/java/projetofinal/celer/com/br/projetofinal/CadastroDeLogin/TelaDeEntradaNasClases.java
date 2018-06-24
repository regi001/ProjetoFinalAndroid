package projetofinal.celer.com.br.projetofinal.CadastroDeLogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import projetofinal.celer.com.br.projetofinal.CadastroDeGrupo.TelaDeCadastroDeGrupoListActivity;
import projetofinal.celer.com.br.projetofinal.CadastroDeParticipante.TelaDeCadastroDeParticipanteListActivity;
import projetofinal.celer.com.br.projetofinal.R;

public class TelaDeEntradaNasClases extends Activity {

Button btnGrupo, btnParticipante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_entrada_nas_clases);

        btnGrupo = findViewById(R.id.TelaDeEntrarNasClasses_btnGrupo);
        btnParticipante = findViewById(R.id.TelaDeEntrarNasClasses_btnParticipante);


    }

    public void CadastrarGrupo(View View){
        Intent it = new Intent(this, TelaDeCadastroDeGrupoListActivity.class);
        startActivity(it);
    }

    public void CadastrarParticipante(View View){
        Intent it = new Intent(this, TelaDeCadastroDeParticipanteListActivity.class);
        startActivity(it);
    }
}
