package projetofinal.celer.com.br.projetofinal.CadastroDeLogin;

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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import projetofinal.celer.com.br.projetofinal.R;

public class TelaDeCadastroActivity extends Activity {
    EditText edtid, edtUsuario, edtEmail, edtSenha;
    Button btnSalvar, btnCancelar, btnEmail;
    CadastroDAO dao;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_cadastro);

        dao = new CadastroDAO(this);

        edtid = findViewById(R.id.telaDeCadastro_edtId);
        edtUsuario = findViewById(R.id.telaDeCadastro_edtNome);
        edtEmail = findViewById(R.id.telaDeCadastro_edtEmail);
        edtSenha = findViewById(R.id.telaDeCadastro_edtSenha);

        Intent it = getIntent();
        String usuario = it.getStringExtra(Cadastro.USUARIO);


        btnSalvar = findViewById(R.id.telaDeCadastro_btnSalvar);
        btnCancelar = findViewById(R.id.telaDeCadastro_btnCancelar);
        btnEmail =  findViewById(R.id.telaDeCadastro_btnEmail);
    }
    // pega o evento do botão cancelar e fecha a tela
    public void cancelar (View view){
        finish();
    }


public void salvar (View view){
    Cadastro cadastro= new Cadastro();

    cadastro.setUsuario(edtUsuario.getText().toString());
    cadastro.setEmail(edtEmail.getText().toString());
    cadastro.setSenha(edtSenha.getText().toString());

    dao.salvar(cadastro);
    Log.i("appmain","passou salvar" );
    Log.i("salvar",cadastro.getUsuario());
    Log.i("salvar",cadastro.getEmail());
    Log.i("salvar",cadastro.getSenha());
    finish();
}
    public void buscarCadatro(){

       Cadastro cadastro = dao.buscar(edtUsuario.getText().toString());

        edtUsuario.setText(cadastro.getUsuario());
       edtEmail.setText(cadastro.getEmail());
       edtSenha.setText(cadastro.getSenha());

    }

    public void email (View view){
        email();
    }
    public void email(){
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{"Manifest.permission.INTERNET"},1);
        }else{
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://"+edtEmail.getText().toString())));
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

