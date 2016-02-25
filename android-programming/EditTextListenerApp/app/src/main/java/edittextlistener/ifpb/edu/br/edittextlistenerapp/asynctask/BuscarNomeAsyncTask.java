package edittextlistener.ifpb.edu.br.edittextlistenerapp.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import edittextlistener.ifpb.edu.br.edittextlistenerapp.util.HttpService;
import edittextlistener.ifpb.edu.br.edittextlistenerapp.util.Response;

/**
 * Created by Rhavy on 24/02/2016.
 */
public class BuscarNomeAsyncTask extends AsyncTask<JSONObject, Void, Response> {

    public static final String TAG = "BuscarNomeAsyncTask";

    BuscarNomeCallBack callBack;

    public BuscarNomeAsyncTask(BuscarNomeCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    protected Response doInBackground(JSONObject... jsons) {


        Response response = null;

        JSONObject json = jsons[0];

        try {
            response = new HttpService().sendJSONPostResquest(json, "get-byname");
        } catch (IOException e) {
            Log.e("EditTextListener", e.getMessage());
        }

        return response;
    }

    @Override
    protected void onPostExecute(Response response) {
        if (response.getStatusCodeHttp() > HttpURLConnection.HTTP_MULT_CHOICE) {
            callBack.errorBuscarNome(response.getContentValue());
        } else {

            try {
                JSONArray jsonArray = new JSONArray(response.getContentValue());
                List<String> names = new ArrayList<>();

                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = jsonObject.getString("fullName");
                    names.add(name);
                }

                callBack.backBuscarNome(names);

            } catch (JSONException e) {
                callBack.errorBuscarNome(e.getMessage());
                Log.e(TAG, e.getMessage());
            }
        }
    }
}
