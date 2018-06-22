package projetofinal.celer.com.br.projetofinal.CadastroDeParticipante;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import projetofinal.celer.com.br.projetofinal.CadastroDeGrupo.CadastroDeGrupo;
import projetofinal.celer.com.br.projetofinal.CadastroDeGrupo.CadastroDeGrupoDAO;
import projetofinal.celer.com.br.projetofinal.CadastroDeGrupo.TelaDeCadastroDeGrupoListActivity;
import projetofinal.celer.com.br.projetofinal.R;

public class TelaDeCadastroDeParticipanteActivity extends Activity {
    EditText edtid, edtnome, edtendereco, edtIdade, edtRg, edtTelefone, edtCpf, edtEscolaridade, edtNumeroDeNis;
    Button btnLigar;

    CadastroDeParticipanteDAO dao;

    final int MENU_SALVAR = 1;
    final int MENU_BUSCAR = 2;
    final int MENU_ALTERAR = 3;
    final int MENU_EXCLUIR = 4;
    final int MENU_LISTAR = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_cadastro_de_participante);

        dao = new CadastroDeParticipanteDAO(this);

        edtid = findViewById(R.id.telaDeCadastroDeUsuario_edtId);
        edtnome = findViewById(R.id.TelaDeCadastroDeUsuario_edtNomeUsuario);
        edtTelefone = findViewById(R.id.telaDeCadastroDeUsuario_edtTelefone);
        edtendereco = findViewById(R.id.telaDeCadastroDeUsuario_edtEndereco);
        edtRg = findViewById(R.id.telaDeCadastroDeUsuario_edtRg);
        edtCpf = findViewById(R.id.telaDeCadastroDeUsuario_edtCpf);
        edtEscolaridade = findViewById(R.id.telaDeCadastroDeUsuario_edtEscolaridade);
        edtNumeroDeNis = findViewById(R.id.telaDeCadastroDeUsuario_edtNis);
        edtIdade = findViewById(R.id.telaDeCadastroDeUsuario_edtIdade);

        btnLigar = findViewById(R.id.telaDeCadastro_btnTelefone);

        Intent it = getIntent();
        Long id = it.getLongExtra(CadastroDeGrupo.ID, 0);

        if (id != 0) {
            edtid.setText(String.valueOf(id));
            buscarPaticipante();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,MENU_SALVAR,0,R.string.menu_salvar);
        menu.add(0,MENU_BUSCAR,0,R.string.menu_buscar);
        menu.add(0,MENU_ALTERAR,0,R.string.menu_alterar);
        menu.add(0,MENU_EXCLUIR,0,R.string.menu_excluir);
        menu.add(0,MENU_LISTAR,0,R.string.menu_listar);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU_SALVAR:
                salvarPaticipante();
                break;

            case MENU_BUSCAR:
                buscarPaticipante();
                break;

            case MENU_ALTERAR:
                alterarParticipante();
                break;

            case MENU_EXCLUIR:
                excluirParticipante();
                break;

            case MENU_LISTAR:
                listar();
                break;

        }
        return true;
    }

    public void salvarPaticipante() {
        Participante participante = new Participante();

        participante.setNome(edtnome.getText().toString());
        participante.setTelefone(edtTelefone.getText().toString());
        participante.setEndereco(edtendereco.getText().toString());


        participante.setRg(edtRg.getText().toString());
        participante.setCpf(edtCpf.getText().toString());
        participante.setIdade(edtIdade.getText().toString());
        participante.setIdade(edtEscolaridade.getText().toString());
        participante.setIdade(edtNumeroDeNis.getText().toString());

        dao.salvar(participante);
        finish();


    }
    public void buscarPaticipante(){

        Participante participante  = dao.buscar(edtid.getText().toString());

        edtnome.setText(participante.getNome());
        edtTelefone.setText(participante.getTelefone());
        edtendereco.setText(participante.getEndereco());
        edtRg.setText(participante.getRg());
        edtCpf.setText(participante.getCpf());
        edtIdade.setText(participante.getIdade());
        edtEscolaridade.setText(participante.getEscolaridade());
        edtNumeroDeNis.setText(participante.getNumeroDeNis());


        Log.i("appmain","passou buscar");

    }
    public void alterarParticipante(){

        Participante participante = new Participante();
       participante.setId(Long.valueOf(edtid.getText().toString()));
        participante.setNome(edtnome.getText().toString());

        participante.setEndereco(edtendereco.getText().toString());
        participante.setTelefone(edtTelefone.getText().toString());
        participante.setRg(edtRg.getText().toString());
        participante.setCpf(edtCpf.getText().toString());
        participante.setIdade(edtIdade.getText().toString());
        participante.setEscolaridade(edtEscolaridade.getText().toString());
       participante.setNumeroDeNis(edtNumeroDeNis.getText().toString());

        dao.alterar(participante);
        finish();

    }
    public void excluirParticipante(){

        dao.excluir(edtid.getText().toString());
        finish();
    }

    public void listar(){
        Intent it = new Intent(this, TelaDeCadastroDeParticipanteListActivity.class);
        // startActivity(it);
        startActivityForResult(it, 5);
    }


}
