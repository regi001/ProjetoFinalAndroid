package projetofinal.celer.com.br.projetofinal.CadastroDeUsuario;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import projetofinal.celer.com.br.projetofinal.R;

/**
 * Created by regia on 08/06/2018.
 */

public class TelaDeCadastroDeUsuarioListAdapter extends ArrayAdapter <CadastroDeUsuario> {
    Context context;
    int layout;
    List <CadastroDeUsuario> cadastroDeUsuarios;

    public TelaDeCadastroDeUsuarioListAdapter(@NonNull Context context, int resource, @NonNull List<CadastroDeUsuario> objects) {
        super(context, resource, objects);
        this.context=context;
        this.layout=resource;
        this.cadastroDeUsuarios = objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater
                = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item = inflater.inflate(layout,null);

        TextView tvNomeUsuario = item.findViewById(R.id.cadastroDeUsuarioListItem_tvNomeDoUsuario);

        CadastroDeUsuario cadastroDeUsuario = cadastroDeUsuarios.get(position);

        tvNomeUsuario.setText(cadastroDeUsuario.getNome());


        return item;
    }

}
