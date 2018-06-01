package projetofinal.celer.com.br.projetofinal.CadastroDeUsuario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import projetofinal.celer.com.br.projetofinal.CadastroDeGrupo.CadastroDeGrupo;
import projetofinal.celer.com.br.projetofinal.CadastroDeLogin.Cadastro;
import projetofinal.celer.com.br.projetofinal.sqlite.BancoDados;

/**
 * Created by regia on 01/06/2018.
 */

public class CadastroDeUsuarioDAO {
    SQLiteDatabase db;

    public CadastroDeUsuarioDAO(Context context) {
        db = BancoDados.getDB(context);
    }

    public void salvar(CadastroDeUsuario cadastroDeUsuario) {

        ContentValues values = new ContentValues();
        values.put(CadastroDeUsuario.NOME, cadastroDeUsuario.getNome());
        //o qe vi fazer ele concatenar com a outra tabela é o id
        values.put(CadastroDeUsuario.CADASTRO_DE_GRUPO, cadastroDeUsuario.getCadastroDeGrupo().getId());
        values.put(CadastroDeUsuario.ENDERECO, cadastroDeUsuario.getEndereco());
        values.put(CadastroDeUsuario.TELEFONE, cadastroDeUsuario.getTelefone());
        values.put(CadastroDeUsuario.RG, cadastroDeUsuario.getRg());
        values.put(CadastroDeUsuario.CPF, cadastroDeUsuario.getCpf());
        values.put(CadastroDeUsuario.IDADE, cadastroDeUsuario.getIdade());
        values.put(CadastroDeUsuario.ESCOLARIDADE, cadastroDeUsuario.getEscolaridade());
        values.put(CadastroDeUsuario.NUMERO_DE_NIS, cadastroDeUsuario.getNumeroDeNis());


        db.insert(CadastroDeUsuario.TABELA, null, values);
    }
    public void  alterar(CadastroDeUsuario cadastroDeUsuario){
        String id=String.valueOf(cadastroDeUsuario.getId());
        String[] where = new String[]{id};

        ContentValues values = new ContentValues();
        values.put(CadastroDeUsuario.NOME, cadastroDeUsuario.getNome());
        values.put(CadastroDeUsuario.CADASTRO_DE_GRUPO, cadastroDeUsuario.getCadastroDeGrupo().getId());
        values.put(CadastroDeUsuario.ENDERECO, cadastroDeUsuario.getEndereco());
        values.put(CadastroDeUsuario.TELEFONE, cadastroDeUsuario.getTelefone());
        values.put(CadastroDeUsuario.RG, cadastroDeUsuario.getRg());
        values.put(CadastroDeUsuario.CPF, cadastroDeUsuario.getCpf());
        values.put(CadastroDeUsuario.IDADE, cadastroDeUsuario.getIdade());
        values.put(CadastroDeUsuario.ESCOLARIDADE, cadastroDeUsuario.getEscolaridade());
        values.put(CadastroDeUsuario.NUMERO_DE_NIS, cadastroDeUsuario.getNumeroDeNis());


        db.update(CadastroDeUsuario.TABELA,values,CadastroDeUsuario.ID, where);
    }
    public CadastroDeUsuario buscar(String id, CadastroDeGrupo cadastroDeGrupo) {

        String[] colunas = CadastroDeUsuario.COLUNAS;
        String[] where = new String[]{id};

        //as informações vao para o cursor
        Cursor c = db.query(CadastroDeUsuario.TABELA, colunas,
                CadastroDeUsuario.ID + "= ?", where, null, null, null, null);

        // move os objetos para o inicio e começa ler o objetos
        c.moveToFirst();


        // pega os itens da sua respectiva coluna pelo cursor
        CadastroDeUsuario cadastroDeUsuario = new CadastroDeUsuario();
        cadastroDeUsuario.setId(c.getLong(c.getColumnIndex(CadastroDeUsuario.ID)));
        cadastroDeUsuario.setCadastroDeGrupo(cadastroDeGrupo);
        cadastroDeUsuario.setNome(c.getString(c.getColumnIndex(CadastroDeUsuario.NOME)));
        cadastroDeUsuario.setEndereco(c.getString(c.getColumnIndex(CadastroDeUsuario.ENDERECO)));
        cadastroDeUsuario.setTelefone(c.getString(c.getColumnIndex(CadastroDeUsuario.TELEFONE)));
        cadastroDeUsuario.setRg(c.getString(c.getColumnIndex(CadastroDeUsuario.RG)));
        cadastroDeUsuario.setCpf(c.getString(c.getColumnIndex(CadastroDeUsuario.CPF)));
        cadastroDeUsuario.setIdade(c.getString(c.getColumnIndex(CadastroDeUsuario.ID)));
        cadastroDeUsuario.setEscolaridade(c.getString(c.getColumnIndex(CadastroDeUsuario.ESCOLARIDADE)));
        cadastroDeUsuario.setNumeroDeNis(c.getString(c.getColumnIndex(CadastroDeUsuario.NUMERO_DE_NIS)));

        return cadastroDeUsuario;
    }
    public List<CadastroDeUsuario> listar(CadastroDeGrupo cadastroDeGrupo){

        String [] colunas = CadastroDeUsuario.COLUNAS;
        String [] where = new String[]{String.valueOf(cadastroDeGrupo.getId())};

        Cursor c= db.query(CadastroDeUsuario.TABELA, colunas,CadastroDeUsuario.CADASTRO_DE_GRUPO + "=?",where,null,null,null);

        List<CadastroDeUsuario> cadastroDeUsuarios = new ArrayList<CadastroDeUsuario>();
        if(c.moveToFirst()){
            do {
                CadastroDeUsuario cadastroDeUsuario = new CadastroDeUsuario();
                cadastroDeUsuario.setId(c.getLong(c.getColumnIndex(CadastroDeUsuario.ID)));
                cadastroDeUsuario.setCadastroDeGrupo(cadastroDeGrupo);
                cadastroDeUsuario.setNome(c.getString(c.getColumnIndex(CadastroDeUsuario.NOME)));
                cadastroDeUsuario.setEndereco(c.getString(c.getColumnIndex(CadastroDeUsuario.ENDERECO)));
                cadastroDeUsuario.setTelefone(c.getString(c.getColumnIndex(CadastroDeUsuario.TELEFONE)));
                cadastroDeUsuario.setRg(c.getString(c.getColumnIndex(CadastroDeUsuario.RG)));
                cadastroDeUsuario.setCpf(c.getString(c.getColumnIndex(CadastroDeUsuario.CPF)));
                cadastroDeUsuario.setIdade(c.getString(c.getColumnIndex(CadastroDeUsuario.ID)));
                cadastroDeUsuario.setEscolaridade(c.getString(c.getColumnIndex(CadastroDeUsuario.ESCOLARIDADE)));
                cadastroDeUsuario.setNumeroDeNis(c.getString(c.getColumnIndex(CadastroDeUsuario.NUMERO_DE_NIS)));

                cadastroDeUsuarios.add(cadastroDeUsuario);

            }while (c.moveToNext());
        }
        return cadastroDeUsuarios;
    }

    public void excluir(String id){
        String[] where = new String[]{id};
        db.delete(CadastroDeUsuario.TABELA,CadastroDeUsuario.ID +"=?", where);
    }

    }


