package edittextlistener.ifpb.edu.br.edittextlistenerapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnItemClick;
import edittextlistener.ifpb.edu.br.edittextlistenerapp.R;
import edittextlistener.ifpb.edu.br.edittextlistenerapp.adapter.UserAdapter;
import edittextlistener.ifpb.edu.br.edittextlistenerapp.asynctask.BuscarNomeAsyncTask;
import edittextlistener.ifpb.edu.br.edittextlistenerapp.asynctask.BuscarNomeCallBack;
import edittextlistener.ifpb.edu.br.edittextlistenerapp.entity.User;
import edittextlistener.ifpb.edu.br.edittextlistenerapp.entity.UserQuery;

public class BuscarNomeActivity extends Activity implements TextWatcher, BuscarNomeCallBack {

    // Define o tamanho mínimo do texto para consulta no servidor.
    private static int TAMANHO_MINIMO_TEXTO = 4;

    private EditText nomeEditText;
    List<String> nomes;
    UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Inicialização da activity e definição do layout.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_nome);
        ButterKnife.bind(this);


        // Recuperando o EditText e
        nomeEditText = (EditText) findViewById(R.id.nomeEditText);
        nomeEditText.addTextChangedListener(this);

        ListView lvUsers = (ListView) findViewById(R.id.nomesListView);

        adapter = new UserAdapter(this);

        lvUsers.setAdapter(adapter);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
        /*Default implementation*/
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        String nome = charSequence.toString();

        if (nome.length() >= TAMANHO_MINIMO_TEXTO) {
            UserQuery query = new UserQuery();
            query.setFullName(nome);

            BuscarNomeAsyncTask buscarNomeAsyncTask = new BuscarNomeAsyncTask(this);
            buscarNomeAsyncTask.execute(query);
        } else {
            adapter.updateData(new ArrayList<User>());
        }
    }

    @OnItemClick(R.id.nomesListView)
    protected void showUser(int position) {
        User user = adapter.getmUsers().get(position);

        Intent intent = new Intent(BuscarNomeActivity.this, UserDetailActivity.class);
        intent.putExtra("user", user);

        startActivity(intent);
    }

    @Override
    public void afterTextChanged(Editable editable) {
        /*Default implementation*/
    }

    @Override
    public void backBuscarUsuario(List<User> users) {
        adapter.updateData(users);
    }

    @Override
    public void errorBuscarUsuario(String error) {
        adapter.updateData(new ArrayList<User>());

        Toast.makeText(this, error, Toast.LENGTH_LONG);
    }
}
