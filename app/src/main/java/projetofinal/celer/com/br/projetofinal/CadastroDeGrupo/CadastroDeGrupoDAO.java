package projetofinal.celer.com.br.projetofinal.CadastroDeGrupo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


import projetofinal.celer.com.br.projetofinal.sqlite.BancoDados;

import static projetofinal.celer.com.br.projetofinal.CadastroDeGrupo.CadastroDeGrupo.*;

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
        values.put(NOME_DO_GRUPO, cadastroDeGrupo.getNomeDoGrupo());
        values.put(MONITOR_RESPONSAVEL, cadastroDeGrupo.getMonitorResponsavel());
        values.put(LOCAL_DE_ATUACAO, cadastroDeGrupo.getLocalDeAtuacao());
        values.put(DESCRICAO_DAS_ATIVIDADES, cadastroDeGrupo.getDescricaoDasAtividades());
        db.insert(TABELA, null, values);

        Log.i("appmain", "passou salvar");
        Log.i("lista", cadastroDeGrupo.getMonitorResponsavel());
    }


    public CadastroDeGrupo buscar(String id){

        String [] colunas = CadastroDeGrupo.COLUNAS;
        String [] where = new  String[]{id};

        Cursor c= db.query(CadastroDeGrupo.TABELA,colunas,
                "_id = ?",where,null,null,null,null);

        c.moveToFirst();
        CadastroDeGrupo cadas = new CadastroDeGrupo();
        cadas.setId(c.getLong(c.getColumnIndex(ID)));
        cadas.setNomeDoGrupo(c.getString(c.getColumnIndex(NOME_DO_GRUPO)));
        cadas.setMonitorResponsavel(c.getString(c.getColumnIndex(MONITOR_RESPONSAVEL)));
        cadas.setLocalDeAtuacao(c.getString(c.getColumnIndex(LOCAL_DE_ATUACAO)));
        cadas.setDescricaoDasAtividades(c.getString(c.getColumnIndex(DESCRICAO_DAS_ATIVIDADES)));
        return cadas;
    }

    public void alterar(CadastroDeGrupo cadastroDeGrupo) {

        String[] where = new String[]{String.valueOf(cadastroDeGrupo.getId())};
        ContentValues values = new ContentValues();

        values.put(NOME_DO_GRUPO, cadastroDeGrupo.getNomeDoGrupo());
        values.put(MONITOR_RESPONSAVEL, cadastroDeGrupo.getMonitorResponsavel());
        values.put(LOCAL_DE_ATUACAO, cadastroDeGrupo.getLocalDeAtuacao());
        values.put(DESCRICAO_DAS_ATIVIDADES, cadastroDeGrupo.getDescricaoDasAtividades());


        db.update(TABELA, values, "_id=?", where);
    }


    public List<CadastroDeGrupo> listar() {

        String[] colunas = COLUNAS;

        Cursor c = db.query(TABELA,
                colunas, null, null, null, null, null);


        List<CadastroDeGrupo> cadastroDeGrupos = new ArrayList<CadastroDeGrupo>();

        if (c.moveToFirst()) {

            do {

                CadastroDeGrupo cadas = new CadastroDeGrupo();
                cadas.setId(c.getLong(c.getColumnIndex(ID)));
                cadas.setNomeDoGrupo(c.getString(c.getColumnIndex(NOME_DO_GRUPO)));
                cadas.setMonitorResponsavel(c.getString(c.getColumnIndex(MONITOR_RESPONSAVEL)));
                cadas.setLocalDeAtuacao(c.getString(c.getColumnIndex(LOCAL_DE_ATUACAO)));
                cadas.setDescricaoDasAtividades(c.getString(c.getColumnIndex(DESCRICAO_DAS_ATIVIDADES)));


                cadastroDeGrupos.add(cadas);



            } while (c.moveToNext());
        }
        return cadastroDeGrupos;
    }

    public void excluir(String id) {

        String[] where = new String[]{id};
        db.delete(TABELA, "_id = ?", where);
    }
}








