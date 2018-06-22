package projetofinal.celer.com.br.projetofinal.CadastroDeParticipante;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.List;



import projetofinal.celer.com.br.projetofinal.R;

public class TelaDeCadastroDeParticipanteListActivity extends ListActivity {


    CadastroDeParticipanteListAdapter adapter;
    List<Participante> participantes;
    CadastroDeParticipanteDAO dao;

    final int MENU_NOVO = 1;
    final int MENU_CANCELAR = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_cadastro_de_participante_list);

        dao = new CadastroDeParticipanteDAO(this);
       participantes = dao.listar();

        adapter = new CadastroDeParticipanteListAdapter(
                this, R.layout.activity_tela_de_cadastro_de_participante_list_item,participantes);

        setListAdapter(adapter);

    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // para recuperar os elemtos da lista
        Participante participante = participantes.get(position);

        Intent it = new Intent(this, TelaDeCadastroDeParticipanteActivity.class);
        it.putExtra(Participante.ID, participante.getId());
        startActivityForResult(it, 1);

    }
    public  void novo(){
        Intent it = new Intent(this, TelaDeCadastroDeParticipanteActivity.class);
        // startActivity(it);
        startActivityForResult(it, 1);
    }


    public void cancelar(){
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0,MENU_NOVO,0,R.string.menu_novo);
        menu.add(0,MENU_CANCELAR,0,R.string.menu_cancelar);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU_NOVO:
                novo();

                break;

            case MENU_CANCELAR:
                cancelar();
                break;
        }
        return true;
    }

    public void atualizarLista() {

        participantes.clear();
        participantes.addAll(dao.listar());
        adapter.notifyDataSetChanged();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        atualizarLista();

    }
}