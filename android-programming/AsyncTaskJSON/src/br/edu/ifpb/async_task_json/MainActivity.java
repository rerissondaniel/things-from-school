package br.edu.ifpb.async_task_json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import br.edu.ifpb.util.JSONParser;

public class MainActivity extends Activity {

	private static final String SERVICE_URL = "http://200.129.68.181:8773/ForCode_SERVICE/list/institutions";
	private static final String INSTITUTION_TAG = "institution";
	private static final String INSTITUTION_COUNTRY_TAG = "country";
	private static final String INSTITUTION_CITY_TAG = "city";
	private static final String INSTITUTION_NAME_TAG = "name";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button = (Button) findViewById(R.id.button1); 
		
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new JSONParse().execute();
			}
		});
	}

	private class JSONParse extends AsyncTask<String, String, JSONArray> {

		private ProgressDialog progressDialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			progressDialog = new ProgressDialog(MainActivity.this);

			progressDialog.setMessage("Loading Institutions...");
			progressDialog.setIndeterminate(false);
			progressDialog.setCancelable(true);

			progressDialog.show();
		}

		@Override
		protected JSONArray doInBackground(String... params) {

			JSONArray json = JSONParser.getJSONFromUrl(SERVICE_URL);
			return json;
		}

		@Override
		protected void onPostExecute(JSONArray json) {
			super.onPostExecute(json);
			progressDialog.dismiss();

			try {
				JSONArray institutions = json;
				
				ListView listView = (ListView) findViewById(R.id.list_institutions);
				
				List<String> listAux = new ArrayList<String>();
				
				for (int i = 0; i < institutions.length(); i++) {
					listAux.add(institutions.getJSONObject(i).getString(
							INSTITUTION_NAME_TAG));
				}

				ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
						android.R.layout.simple_list_item_1, listAux);
				
				listView.setAdapter(adapter);
				
			} catch (JSONException e) {
				e.printStackTrace();
			}

		}

	}
}
