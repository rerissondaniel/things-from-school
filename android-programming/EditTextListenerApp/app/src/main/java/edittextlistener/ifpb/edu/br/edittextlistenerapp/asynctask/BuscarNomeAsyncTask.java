package edittextlistener.ifpb.edu.br.edittextlistenerapp.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edittextlistener.ifpb.edu.br.edittextlistenerapp.entity.User;
import edittextlistener.ifpb.edu.br.edittextlistenerapp.entity.UserQuery;
import edittextlistener.ifpb.edu.br.edittextlistenerapp.util.HttpService;
import edittextlistener.ifpb.edu.br.edittextlistenerapp.util.Response;

/**
 * Created by Rhavy on 24/02/2016.
 */
public class BuscarNomeAsyncTask extends AsyncTask<UserQuery, Void, Response> {

    public static final String TAG = "BuscarNomeAsyncTask";

    BuscarNomeCallBack callBack;

    public BuscarNomeAsyncTask(BuscarNomeCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    protected Response doInBackground(UserQuery... queries) {


        Response response = null;

        UserQuery gsonQuery = queries[0];

        try {
            response = HttpService.sendJSONPostResquest(new Gson().toJson(gsonQuery), "get-byname");
        } catch (IOException e) {
            Log.e("EditTextListener", e.getMessage());
        }

        return response;
    }

    @Override
    protected void onPostExecute(final Response response) {
        if (response.getStatusCodeHttp() > HttpURLConnection.HTTP_MULT_CHOICE) {
            callBack.errorBuscarUsuario(response.getContentValue());
        } else {
            Gson gson = new Gson();
            List<User> userList = new ArrayList<>(
                    Arrays.asList(gson.fromJson(response.getContentValue(), User[].class)));
            callBack.backBuscarUsuario(userList);
        }
    }
}
