package projetofinal.celer.com.br.projetofinal.CadastroDeLogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import projetofinal.celer.com.br.projetofinal.sqlite.BancoDados;

/**
 * Created by regia on 28/05/2018.
 */

public class CadastroDAO {
    SQLiteDatabase db;


    public CadastroDAO(Context context) {
        db = BancoDados.getDB(context);
    }

    public void salvar(Cadastro cadastro) {
        ContentValues values = new ContentValues();
        values.put(Cadastro.USUARIO, cadastro.getUsuario());
        values.put(Cadastro.SENHA, cadastro.getSenha());
        values.put(Cadastro.EMAIL, cadastro.getEmail());
        db.insert(Cadastro.TABELA, null, values);
    }



    public Cadastro buscar(String usuario) {

        String[] colunas = Cadastro.COLUNAS;
        String[] where = new String[]{usuario};

        Cursor c = db.query(Cadastro.TABELA, colunas, "usuario =?", where, null, null, null, null);
        c.moveToFirst();

        Cadastro cadastro = new Cadastro();

        cadastro.setUsuario(c.getString(c.getColumnIndex(Cadastro.USUARIO)));
        cadastro.setEmail(c.getString(c.getColumnIndex(Cadastro.EMAIL)));
        cadastro.setSenha(c.getString(c.getColumnIndex(Cadastro.SENHA)));

        return cadastro;
    }

    public void alterar(Cadastro cadastro) {

        String[] where = new String[]{String.valueOf(cadastro.getUsuario())};
        ContentValues values = new ContentValues();

        values.put(Cadastro.USUARIO, cadastro.getUsuario());
        values.put(Cadastro.EMAIL, cadastro.getEmail());
        values.put(Cadastro.SENHA, cadastro.getSenha());


        db.update(Cadastro.TABELA, values, "nome=?", where);
    }

    public void excluir(String usuario) {

        String[] where = new String[]{usuario};
        db.delete(Cadastro.TABELA, "usuario = ?", where);
    }

    public List<Cadastro> listar() {

        String[] colunas = Cadastro.COLUNAS;
        Cursor c = db.query(Cadastro.TABELA, colunas, null, null, null, null, null);
        List<Cadastro> cadastros = new ArrayList<Cadastro>();

        if (c.moveToFirst()) ;
        do {
            Cadastro cadastro = new Cadastro();


            cadastro.setUsuario(c.getString(c.getColumnIndex(Cadastro.USUARIO)));

            cadastro.setEmail(c.getString(c.getColumnIndex(Cadastro.EMAIL)));
            cadastro.setSenha(c.getString(c.getColumnIndex(Cadastro.SENHA)));

            cadastros.add(cadastro);

            Log.i("lista", cadastro.getUsuario() + cadastro.getUsuario());
        } while (c.moveToNext());
        return cadastros;
    }


 public boolean validarCadastro(String usuario,String email, String senha){
     String[] colunas = Cadastro.COLUNAS;
     String[] where = new String[]{usuario};

     Cursor c = db.query(Cadastro.TABELA, colunas, "usuario =?", where, null, null, null, null);
     c.moveToFirst();

     Cadastro cadastro = new Cadastro();

     cadastro.setUsuario(c.getString(c.getColumnIndex(Cadastro.USUARIO)));
     cadastro.setEmail(c.getString(c.getColumnIndex(Cadastro.EMAIL)));
     cadastro.setSenha(c.getString(c.getColumnIndex(Cadastro.SENHA)));

     if (usuario.equals(cadastro.getUsuario()) ) return true;
     else {

         return false;
     }


 }



}






