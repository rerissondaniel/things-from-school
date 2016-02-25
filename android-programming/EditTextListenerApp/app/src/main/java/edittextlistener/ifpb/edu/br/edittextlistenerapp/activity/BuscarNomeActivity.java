package edittextlistener.ifpb.edu.br.edittextlistenerapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import edittextlistener.ifpb.edu.br.edittextlistenerapp.R;
import edittextlistener.ifpb.edu.br.edittextlistenerapp.asynctask.BuscarNomeAsyncTask;
import edittextlistener.ifpb.edu.br.edittextlistenerapp.asynctask.BuscarNomeCallBack;

public class BuscarNomeActivity extends Activity implements TextWatcher, BuscarNomeCallBack {

    // Define o tamanho mínimo do texto para consulta no servidor.
    private static int TAMANHO_MINIMO_TEXTO = 4;

    private EditText nomeEditText;
    List<String> nomes;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Inicialização da activity e definição do layout.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_nome);

        // Recuperando o EditText e
        nomeEditText = (EditText) findViewById(R.id.nomeEditText);
        nomeEditText.addTextChangedListener(this);

        ListView nomesListView = (ListView) findViewById(R.id.nomesListView);
        nomes = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                nomes);

        nomesListView.setAdapter(adapter);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
        /*Default implementation*/
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        String nome = charSequence.toString();

        try {
            if (nome.length() >= TAMANHO_MINIMO_TEXTO) {
                // JSON
                JSONObject json = new JSONObject();
                json.put("fullName", nome);

                BuscarNomeAsyncTask buscarNomeAsyncTask = new BuscarNomeAsyncTask(this);
                buscarNomeAsyncTask.execute(json);
            }else{
                nomes.clear();
                adapter.notifyDataSetChanged();
            }

        } catch (JSONException e) {
            Log.e("EditTextListener", e.getMessage());
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {
        /*Default implementation*/
    }

    @Override
    public void backBuscarNome(List<String> names) {
        nomes.clear();
        nomes.addAll(names);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void errorBuscarNome(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG);
    }
}
