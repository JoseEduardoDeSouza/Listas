package moblab.exemplolista;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by moblab on 15/07/16.
 */
public class adapterlistview extends BaseAdapter {

    private List<ItemListView> ListaItens;
    private LayoutInflater inflater;

    public adapterlistview(Context context, List<ItemListView> listaItens) {
        ListaItens = listaItens;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return ListaItens.size();
    }

    @Override
    public Object getItem(int posicao) {
        return ListaItens.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return posicao;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemSuporte itemsuporte;
        if (view == null) {
            view = inflater.inflate(R.layout.lista_itens, null);
            itemsuporte = new ItemSuporte();
            itemsuporte.textoview = (TextView) view.findViewById(R.id.texto_item);

            view.setTag(itemsuporte);

        } else {
            itemsuporte = (ItemSuporte) view.getTag();
        }



        ItemListView item = ListaItens.get(i);
        itemsuporte.textoview.setText(item.getTexto());
        return view;
    }
    private class ItemSuporte{
        public TextView textoview;

    }
}
