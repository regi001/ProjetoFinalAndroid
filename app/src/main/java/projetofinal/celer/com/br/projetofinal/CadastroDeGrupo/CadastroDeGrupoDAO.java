package projetofinal.celer.com.br.projetofinal.CadastroDeGrupo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import projetofinal.celer.com.br.projetofinal.CadastroDeLogin.Cadastro;
import projetofinal.celer.com.br.projetofinal.sqlite.BancoDados;

/**
 * Created by regia on 30/05/2018.
 */

public class CadastroDeGrupoDAO {

    SQLiteDatabase db;

    public CadastroDeGrupoDAO(Context context) {
        db = BancoDados.getDB(context);
    }
    public void salvar(CadastroDeGrupo cadastroDeGrupo) {
        ContentValues values = new ContentValues();

        values.put(CadastroDeGrupo.NOME_DO_GRUPO,cadastroDeGrupo.getNomeDoGrupo());
        values.put(CadastroDeGrupo.LOCAL_DE_ATUACAO,cadastroDeGrupo.getLocalDeAtuacao());
        values.put(CadastroDeGrupo.DESCRICAO_DAS_ATIVIDADES,cadastroDeGrupo.getDescricaoDasAtividades());

        db.insert(CadastroDeGrupo.TABELA, null, values);

        Log.i("appmain","passou salvar");
        Log.i("lista",cadastroDeGrupo.getMonitorResponsavel());
    }



    public CadastroDeGrupo buscar(String id) {

        String[] colunas = CadastroDeGrupo.COLUNAS;
        String[] where = new String[]{id};

        Cursor c = db.query(CadastroDeGrupo.TABELA, colunas, "_id =?", where, null, null, null, null);
        c.moveToFirst();

        CadastroDeGrupo cadastroDeGrupo = new CadastroDeGrupo();

        cadastroDeGrupo.setId(Long.valueOf(c.getString(c.getColumnIndex(CadastroDeGrupo.ID))));
        cadastroDeGrupo.setNomeDoGrupo(c.getString(c.getColumnIndex(CadastroDeGrupo.NOME_DO_GRUPO)));
        cadastroDeGrupo.setMonitorResponsavel(c.getString(c.getColumnIndex(CadastroDeGrupo.MONITOR_RESPONSAVEL)));
        cadastroDeGrupo.setLocalDeAtuacao(c.getString(c.getColumnIndex(CadastroDeGrupo.LOCAL_DE_ATUACAO)));
        cadastroDeGrupo.setDescricaoDasAtividades(c.getString(c.getColumnIndex(CadastroDeGrupo.DESCRICAO_DAS_ATIVIDADES)));

        Log.i("appmain","passou buscar");

       return cadastroDeGrupo;
    }

    public void alterar(CadastroDeGrupo cadastroDeGrupo) {

        String[] where = new String[]{String.valueOf(cadastroDeGrupo.getId())};
        ContentValues values = new ContentValues();

        values.put(CadastroDeGrupo.NOME_DO_GRUPO,cadastroDeGrupo.getNomeDoGrupo());
        values.put(CadastroDeGrupo.LOCAL_DE_ATUACAO,cadastroDeGrupo.getLocalDeAtuacao());
        values.put(CadastroDeGrupo.DESCRICAO_DAS_ATIVIDADES,cadastroDeGrupo.getDescricaoDasAtividades());



        db.update(CadastroDeGrupo.TABELA, values, "_id=?", where);
    }

    public void excluir(String id) {

        String[] where = new String[]{id};
        db.delete(CadastroDeGrupo.TABELA, "_id = ?", where);
    }

    public List<CadastroDeGrupo> listar() {

        String[] colunas = CadastroDeGrupo.COLUNAS;
        Cursor c = db.query(CadastroDeGrupo.TABELA, colunas, null, null, null, null, null);
        List<CadastroDeGrupo> cadastroDeGrupos = new ArrayList<CadastroDeGrupo>();

        if (c.moveToFirst()) ;
        do {
            CadastroDeGrupo cadastroDeGrupo = new CadastroDeGrupo();


            cadastroDeGrupo.setId(Long.valueOf(c.getString(c.getColumnIndex(CadastroDeGrupo.ID))));
            cadastroDeGrupo.setNomeDoGrupo(c.getString(c.getColumnIndex(CadastroDeGrupo.NOME_DO_GRUPO)));
            cadastroDeGrupo.setMonitorResponsavel(c.getString(c.getColumnIndex(CadastroDeGrupo.MONITOR_RESPONSAVEL)));
            cadastroDeGrupo.setLocalDeAtuacao(c.getString(c.getColumnIndex(CadastroDeGrupo.LOCAL_DE_ATUACAO)));
            cadastroDeGrupo.setDescricaoDasAtividades(c.getString(c.getColumnIndex(CadastroDeGrupo.DESCRICAO_DAS_ATIVIDADES)));

            cadastroDeGrupos.add(cadastroDeGrupo);

            Log.i("lista", cadastroDeGrupo.getId() + cadastroDeGrupo.getNomeDoGrupo());
        } while (c.moveToNext());
        return cadastroDeGrupos;
    }





    }
