package projetofinal.celer.com.br.projetofinal;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

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
        values.put(Cadastro.NOME, cadastro.getNome());
        values.put(Cadastro.SENHA, cadastro.getSenha());
        values.put(Cadastro.EMAIL, cadastro.getEmail());
        db.insert(Cadastro.TABELA, null, values);
    }



    public Cadastro buscar(String nome, String email, String senha) {

        String[] colunas = Cadastro.COLUNAS;
        String[] where = new String[]{nome};

        Cursor c = db.query(Cadastro.TABELA, colunas, "nome =?", where, null, null, null, null);
        c.moveToFirst();

        Cadastro cadastro = new Cadastro();

        cadastro.setNome(c.getString(c.getColumnIndex(Cadastro.NOME)));
        cadastro.setEmail(c.getString(c.getColumnIndex(Cadastro.EMAIL)));
        cadastro.setSenha(c.getString(c.getColumnIndex(Cadastro.SENHA)));

        return cadastro;
    }

    public void alterar(Cadastro cadastro) {

        String[] where = new String[]{String.valueOf(cadastro.getNome())};
        ContentValues values = new ContentValues();

        values.put(Cadastro.NOME, cadastro.getNome());
        values.put(Cadastro.EMAIL, cadastro.getEmail());
        values.put(Cadastro.SENHA, cadastro.getSenha());


        db.update(Cadastro.TABELA, values, "nome=?", where);
    }

    public void excluir(String nome) {

        String[] where = new String[]{nome};
        db.delete(Cadastro.TABELA, "nome = ?", where);
    }

    public List<Cadastro> listar() {

        String[] colunas = Cadastro.COLUNAS;
        Cursor c = db.query(Cadastro.TABELA, colunas, null, null, null, null, null);
        List<Cadastro> cadastros = new ArrayList<Cadastro>();

        if (c.moveToFirst()) ;
        do {
            Cadastro cadastro = new Cadastro();


            cadastro.setNome(c.getString(c.getColumnIndex(Cadastro.NOME)));

            cadastro.setEmail(c.getString(c.getColumnIndex(Cadastro.EMAIL)));
            cadastro.setSenha(c.getString(c.getColumnIndex(Cadastro.SENHA)));

            cadastros.add(cadastro);

            Log.i("lista", cadastro.getNome() + cadastro.getNome());
        } while (c.moveToNext());
        return cadastros;
    }


 public boolean validarCadastro(String nome,String email, String senha){
     String[] colunas = Cadastro.COLUNAS;
     String[] where = new String[]{nome};

     Cursor c = db.query(Cadastro.TABELA, colunas, "nome =?", where, null, null, null, null);
     c.moveToFirst();

     Cadastro cadastro = new Cadastro();

     cadastro.setNome(c.getString(c.getColumnIndex(Cadastro.NOME)));
     cadastro.setEmail(c.getString(c.getColumnIndex(Cadastro.EMAIL)));
     cadastro.setSenha(c.getString(c.getColumnIndex(Cadastro.SENHA)));

     if (senha.equals(cadastro.getSenha()) ){
         
             return true;
     }else {

         return false;
     }


 }



}






