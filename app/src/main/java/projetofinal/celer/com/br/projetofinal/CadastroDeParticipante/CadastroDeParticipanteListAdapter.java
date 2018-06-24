package projetofinal.celer.com.br.projetofinal.CadastroDeParticipante;

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
 * Created by regia on 21/06/2018.
 */

public class CadastroDeParticipanteListAdapter extends ArrayAdapter<Participante> {

    Context context;
    int layout;
    List<Participante> participantes;

    public CadastroDeParticipanteListAdapter(@NonNull Context context, int resource, @NonNull List<Participante> objects) {
        super(context,resource,objects);
        this.context =context;
        this.layout = resource;
        this.participantes = objects;
    }

    @NonNull

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater
                = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View item = inflater.inflate(layout,null);
        TextView tvNomeDoParticipante = item.findViewById(R.id.cadastroDeParticipanteListItem_tvNomeDoUsuario);
        Participante participante= participantes.get(position);


        tvNomeDoParticipante.setText(participante.getNome());




        return item;
    }
}
