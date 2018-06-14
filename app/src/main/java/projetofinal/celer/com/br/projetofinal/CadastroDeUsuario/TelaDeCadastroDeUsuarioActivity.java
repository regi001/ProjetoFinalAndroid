package projetofinal.celer.com.br.projetofinal.CadastroDeUsuario;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import projetofinal.celer.com.br.projetofinal.CadastroDeGrupo.CadastroDeGrupo;
import projetofinal.celer.com.br.projetofinal.CadastroDeGrupo.CadastroDeGrupoDAO;
import projetofinal.celer.com.br.projetofinal.CadastroDeGrupo.TelaDeCadastroDeGrupoListActivity;
import projetofinal.celer.com.br.projetofinal.CadastroDeLogin.TelaDeLoginActivity;
import projetofinal.celer.com.br.projetofinal.R;

public class TelaDeCadastroDeUsuarioActivity extends Activity {
    EditText edtid, edtnome, edtendereco, edtIdade, edtRg, edtTelefone, edtCpf, edtEscolaridade, edtNumeroDeNis;
    Button btnLigar;

    CadastroDeUsuarioDAO cadastroDeUsuarioDAO;
    CadastroDeGrupoDAO cadastroDeGrupoDAO;
    CadastroDeGrupo cadastroDeGrupo;

    final int MENU_SALVAR = 1;
    final int MENU_ALTERAR = 2;
    final int MENU_BUSCAR = 3;
    final int MENU_EXCLUIR = 4;
    final int MENU_LISTAR_USUARIOS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_cadastro_de_usuario);

        Intent it = getIntent();
        //String id = it.getStringExtra("_id");
        String id = String.valueOf(it.getLongExtra(CadastroDeGrupo.ID,0));

        edtid = findViewById(R.id.telaDeCadastroDeUsuario_edtId);
        edtnome = findViewById(R.id.TelaDeCadastroDeUsuario_edtNomeUsuario);
        edtTelefone = findViewById(R.id.telaDeCadastroDeUsuario_edtTelefone);
        edtendereco = findViewById(R.id.telaDeCadastroDeUsuario_edtEndereco);
        edtRg = findViewById(R.id.telaDeCadastroDeUsuario_edtRg);
        edtCpf = findViewById(R.id.telaDeCadastroDeUsuario_edtCpf);
        edtEscolaridade = findViewById(R.id.telaDeCadastroDeUsuario_edtEscolaridade);
        edtNumeroDeNis = findViewById(R.id.telaDeCadastroDeUsuario_edtNis);
        edtIdade = findViewById(R.id.telaDeCadastroDeUsuario_edtIdade);

        btnLigar =  findViewById(R.id.telaDeCadastro_btnTelefone);

        cadastroDeUsuarioDAO = new CadastroDeUsuarioDAO(this);
        cadastroDeGrupoDAO = new CadastroDeGrupoDAO(this);

     //   Intent it = getIntent();

     //   if(it != null) {
      //      String id = String.valueOf(it.getStringExtra(CadastroDeGrupo.ID));

        //    if (id != ""){
                cadastroDeGrupo = new CadastroDeGrupo();
                cadastroDeGrupo = cadastroDeGrupoDAO.buscar(id);
                Toast.makeText(this,id,Toast.LENGTH_LONG).show();
          //  }
        }

   // }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_SALVAR, 0, "salvar");
        menu.add(0, MENU_ALTERAR, 0, "alterar");
        menu.add(0, MENU_BUSCAR, 0, "buscar");
        menu.add(0, MENU_EXCLUIR, 0, "excluir");
        menu.add(0, MENU_LISTAR_USUARIOS, 0, "listar");
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
            case MENU_SALVAR:
                salvar();
                break;
            case MENU_ALTERAR:
                alterarUsuario();
                break;

            case MENU_EXCLUIR:
                excluirUsuario();

            case MENU_LISTAR_USUARIOS:
                listar();
        }
        return true;
    }

    public void salvar() {
        CadastroDeUsuario cadastroDeUsuario = new CadastroDeUsuario();
        cadastroDeUsuario.setNome(edtnome.getText().toString());
        cadastroDeUsuario.setCadastroDeGrupo(cadastroDeGrupo);
        cadastroDeUsuario.setEndereco(edtendereco.getText().toString());
        cadastroDeUsuario.setTelefone(edtTelefone.getText().toString());
        cadastroDeUsuario.setRg(edtRg.getText().toString());
        cadastroDeUsuario.setCpf(edtCpf.getText().toString());
        cadastroDeUsuario.setIdade(edtIdade.getText().toString());
        cadastroDeUsuario.setIdade(edtEscolaridade.getText().toString());
        cadastroDeUsuario.setIdade(edtNumeroDeNis.getText().toString());

        cadastroDeUsuarioDAO.salvar(cadastroDeUsuario);
        finish();
    }

    public void alterarUsuario() {
        CadastroDeUsuario cadastroDeUsuario = new CadastroDeUsuario();
        cadastroDeUsuario.setId(Long.valueOf(edtid.getText().toString()));
        cadastroDeUsuario.setNome(edtnome.getText().toString());
        cadastroDeUsuario.setCadastroDeGrupo(cadastroDeGrupo);
        cadastroDeUsuario.setEndereco(edtendereco.getText().toString());
        cadastroDeUsuario.setTelefone(edtTelefone.getText().toString());
        cadastroDeUsuario.setRg(edtRg.getText().toString());
        cadastroDeUsuario.setCpf(edtCpf.getText().toString());
        cadastroDeUsuario.setIdade(edtIdade.getText().toString());
        cadastroDeUsuario.setIdade(edtEscolaridade.getText().toString());
        cadastroDeUsuario.setIdade(edtNumeroDeNis.getText().toString());

        cadastroDeUsuarioDAO.alterar(cadastroDeUsuario);
        finish();
    }



    public void excluirUsuario(){

        cadastroDeUsuarioDAO.excluir(edtid.getText().toString());
        finish();

    }
    public void listar(){
        Intent it = new Intent(this, TelaDeCadastroDeGrupoListActivity.class);
        // startActivity(it);
        startActivityForResult(it, 5);
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


}


