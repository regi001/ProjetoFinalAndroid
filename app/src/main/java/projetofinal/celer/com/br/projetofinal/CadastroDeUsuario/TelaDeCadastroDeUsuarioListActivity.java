package projetofinal.celer.com.br.projetofinal.CadastroDeUsuario;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;


import java.util.List;

import projetofinal.celer.com.br.projetofinal.CadastroDeGrupo.CadastroDeGrupo;
import projetofinal.celer.com.br.projetofinal.CadastroDeGrupo.CadastroDeGrupoDAO;
import projetofinal.celer.com.br.projetofinal.R;

public class TelaDeCadastroDeUsuarioListActivity extends ListActivity{


    CadastroDeUsuarioDAO cadastroDeUsuarioDAO;
    CadastroDeGrupoDAO cadastroDeGrupoDAO;
    CadastroDeUsuarioListAdapter adapter;
    List<CadastroDeUsuario> cadastroDeUsuarios;
    CadastroDeGrupo cadastroDeGrupo;

    final int MENU_NOVO= 1;
    final int MENU_CANCELAR = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_cadastro_de_usuario_list);

        Intent it = getIntent();
        String id = it.getStringExtra(CadastroDeGrupo.ID);

        cadastroDeGrupoDAO = new CadastroDeGrupoDAO(this);
        CadastroDeGrupo cadastroDeGrupo = cadastroDeGrupoDAO.buscar(id);

        cadastroDeUsuarioDAO = new CadastroDeUsuarioDAO(this);
        cadastroDeUsuarios = cadastroDeUsuarioDAO.listar(cadastroDeGrupo);

        adapter = new CadastroDeUsuarioListAdapter(
                this, R.layout.activity_tela_de_cadastro_de_usuario_list_item, cadastroDeUsuarios);

        setListAdapter(adapter);
    }
/*
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // para recuperar os elemtos da lista

        CadastroDeUsuario cadastroDeUsuario= cadastroDeUsuarios.get(position);
        Intent it = new Intent(this, TelaDeCadastroDeUsuarioActivity.class);
        it.putExtra(CadastroDeUsuario.ID, cadastroDeUsuario.getId());
        startActivityForResult(it, 1);

    }
    */

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
                Intent it = new Intent(this,TelaDeCadastroDeUsuarioActivity.class);
                it.putExtra(CadastroDeGrupo.ID,cadastroDeGrupo.getId());
                startActivityForResult(it,1);
                break;

            case MENU_CANCELAR:

                break;


        }
        return true;
    }

    public void atualizarLista(){
        cadastroDeUsuarios.clear();

         cadastroDeUsuarios.addAll(cadastroDeUsuarioDAO.listar(cadastroDeGrupo));

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        atualizarLista();
    }
}



