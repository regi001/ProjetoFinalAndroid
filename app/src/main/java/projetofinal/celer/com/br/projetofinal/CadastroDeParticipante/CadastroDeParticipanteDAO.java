package projetofinal.celer.com.br.projetofinal.CadastroDeParticipante;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;




import projetofinal.celer.com.br.projetofinal.sqlite.BancoDados;

import static projetofinal.celer.com.br.projetofinal.CadastroDeParticipante.Participante.COLUNAS;
import static projetofinal.celer.com.br.projetofinal.CadastroDeParticipante.Participante.TABELA;

/**
 * Created by regia on 21/06/2018.
 */

public class CadastroDeParticipanteDAO {
    SQLiteDatabase db;


    public CadastroDeParticipanteDAO(Context context) {
        db = BancoDados.getDB(context);
    }

    public void salvar(Participante participante) {

        ContentValues values = new ContentValues();
        values.put(Participante.NOME, participante.getNome());


        values.put(Participante.ENDERECO, participante.getEndereco());
        values.put(Participante.TELEFONE, participante.getTelefone());
        values.put(Participante.RG, participante.getRg());
        values.put(Participante.CPF, participante.getCpf());
        values.put(Participante.IDADE, participante.getIdade());
        values.put(Participante.ESCOLARIDADE, participante.getEscolaridade());
        values.put(Participante.NUMERO_DE_NIS, participante.getNumeroDeNis());


        db.insert(Participante.TABELA, null, values);
    }

    public void  alterar(Participante participante){
        String id=String.valueOf(participante.getId());
        String[] where = new String[]{id};

        ContentValues values = new ContentValues();
        values.put(Participante.NOME, participante.getNome());

        values.put(Participante.ENDERECO, participante.getEndereco());
        values.put(Participante.TELEFONE, participante.getTelefone());
        values.put(Participante.RG, participante.getRg());
        values.put(Participante.CPF, participante.getCpf());
        values.put(Participante.IDADE, participante.getIdade());
        values.put(Participante.ESCOLARIDADE, participante.getEscolaridade());
        values.put(Participante.NUMERO_DE_NIS, participante.getNumeroDeNis());


        db.update(Participante.TABELA,values,"_id=?", where);
    }
    public Participante buscar(String id){

        String [] colunas = Participante.COLUNAS;
        String [] where = new  String[]{id};

        Cursor c= db.query(Participante.TABELA,colunas,"_id = ?",where,null,null,null,null);

        c.moveToFirst();
        Participante participante = new Participante();
        participante.setId(c.getLong(c.getColumnIndex(Participante.ID)));

        participante.setNome(c.getString(c.getColumnIndex(Participante.NOME)));
        participante.setEndereco(c.getString(c.getColumnIndex(Participante.ENDERECO)));
        participante.setTelefone(c.getString(c.getColumnIndex(Participante.TELEFONE)));
        participante.setRg(c.getString(c.getColumnIndex(Participante.RG)));
        participante.setCpf(c.getString(c.getColumnIndex(Participante.CPF)));
        participante.setIdade(c.getString(c.getColumnIndex(Participante.ID)));
        participante.setEscolaridade(c.getString(c.getColumnIndex(Participante.ESCOLARIDADE)));
        participante.setNumeroDeNis(c.getString(c.getColumnIndex(Participante.NUMERO_DE_NIS)));

        return participante;

    }

    public List<Participante> listar() {

        String[] colunas = COLUNAS;

        Cursor c = db.query(TABELA,
                colunas, null, null, null, null, null);


        List<Participante> participantes = new ArrayList<Participante>();

        if (c.moveToFirst()) {

            do {

                Participante participante = new Participante();
                participante.setId(c.getLong(c.getColumnIndex( Participante.ID)));

                participante.setNome(c.getString(c.getColumnIndex( Participante.NOME)));
                participante.setEndereco(c.getString(c.getColumnIndex( Participante.ENDERECO)));
                participante.setTelefone(c.getString(c.getColumnIndex( Participante.TELEFONE)));
                participante.setRg(c.getString(c.getColumnIndex( Participante.RG)));
                participante.setCpf(c.getString(c.getColumnIndex( Participante.CPF)));
                participante.setIdade(c.getString(c.getColumnIndex( Participante.ID)));
                participante.setEscolaridade(c.getString(c.getColumnIndex( Participante.ESCOLARIDADE)));
                participante.setNumeroDeNis(c.getString(c.getColumnIndex( Participante.NUMERO_DE_NIS)));

                participantes.add(participante);


            } while (c.moveToNext());
        }
        return participantes;
    }

    public void excluir(String id) {

        String[] where = new String[]{id};
        db.delete(Participante.TABELA, "_id = ?", where);
    }

}
