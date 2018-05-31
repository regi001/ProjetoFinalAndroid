package projetofinal.celer.com.br.projetofinal.CadastroDeGrupo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import projetofinal.celer.com.br.projetofinal.R;

/**
 * Created by regia on 31/05/2018.
 */

public class CadastroDeGrupoListAdapter extends ArrayAdapter <CadastroDeGrupo> {

    Context context;
    int layout;
    List<CadastroDeGrupo> cadastroDeGrupos;

    public CadastroDeGrupoListAdapter(@NonNull Context context, int resource, @NonNull List<CadastroDeGrupo> objects) {
        super(context,resource,objects);
        this.context =context;
        this.layout = resource;
        this.cadastroDeGrupos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater
                = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View item = inflater.inflate(layout,null);
        TextView tvNomeDoGrupo = item.findViewById(R.id.cadastroDeGrupoListItem_tvNomeDoGrupo);
        CadastroDeGrupo cadastroDeGrupo= cadastroDeGrupos.get(position);


        tvNomeDoGrupo.setText(cadastroDeGrupo.getNomeDoGrupo());




        return item;
    }

}
