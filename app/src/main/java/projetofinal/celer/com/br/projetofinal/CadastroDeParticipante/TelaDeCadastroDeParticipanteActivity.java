package projetofinal.celer.com.br.projetofinal.CadastroDeParticipante;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        edtid = findViewById(R.id.telaDeCadastroDeParticipante_edtId);
        edtnome = findViewById(R.id.telaDeCadastroDeParticipante_edtNomeUsuario);
        edtTelefone = findViewById(R.id.telaDeCadastroDeParticipante_edtTelefone);
        edtendereco = findViewById(R.id.telaDeCadastroDeParticipante_edtEndereco);
        edtRg = findViewById(R.id.telaDeCadastroDeParticipante_edtRg);
        edtCpf = findViewById(R.id.telaDeCadastroDeParticipante_edtCpf);
        edtEscolaridade = findViewById(R.id.telaDeCadastroDeParticipante_edtEscolaridade);
        edtNumeroDeNis = findViewById(R.id.telaDeCadastroDeParticipante_edtNis);
        edtIdade = findViewById(R.id.telaDeCadastroDeParticipante_edtIdade);

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

        Toast.makeText(getBaseContext(),R.string.Toat_msgSalvar,Toast.LENGTH_LONG).show();
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

        Toast.makeText(getBaseContext(),R.string.Toat_msgBuscar,Toast.LENGTH_LONG).show();
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
        Toast.makeText(getBaseContext(),R.string.Toat_msgAlterar,Toast.LENGTH_LONG).show();
        finish();

    }
    public void excluirParticipante(){

        dao.excluir(edtid.getText().toString());
        Toast.makeText(getBaseContext(),R.string.Toat_msgExcluir,Toast.LENGTH_LONG).show();
        finish();
    }

    public void listar(){
        Intent it = new Intent(this, TelaDeCadastroDeParticipanteListActivity.class);
        // startActivity(it);
        startActivityForResult(it, 5);
        Toast.makeText(getBaseContext(),R.string.Toat_msgListar,Toast.LENGTH_LONG).show();
    }
    public void ligar (View view){
        fazerLigacao();
    }
    public void fazerLigacao(){
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{"Manifest.permission.CALL_PHONE"},1);
        }else{
            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:"+edtTelefone.getText().toString())));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if ((grantResults.length>0)&&(grantResults[0]== PackageManager.PERMISSION_GRANTED)){
                    fazerLigacao();
                }
                break;
        }
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
