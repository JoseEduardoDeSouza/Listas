package moblab.exemplolista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listaView;
    List<ItemListView> listaItemView;
    adapterlistview adaptador;
    public void adicionarItem(View botao){
        EditText campoTexto = (EditText)findViewById(R.id.editText);
        String textoitem = campoTexto.getText().toString();
        ItemListView itemLista = new ItemListView();
        itemLista.setTexto(textoitem);

        listaItemView.add(itemLista);
        adaptador = new adapterlistview(this, listaItemView);
        listaView.setAdapter(adaptador);


        listaView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Log.d("MOBLAB - ID do Item", String.valueOf(i));
                listaItemView.remove(i);
                adaptador = new adapterlistview(MainActivity.this, listaItemView);
                listaView.setAdapter(adaptador);
                adaptador.notifyDataSetChanged();
                return true;
            }
        });
        
        adaptador.notifyDataSetChanged();

        campoTexto.setText("");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaItemView = new ArrayList<ItemListView>();

        this.listaView = (ListView)findViewById(R.id.lista_itens);
        this.adaptador = new adapterlistview(this, this.listaItemView);

        this.listaView.setAdapter(this.adaptador);

    }

}
