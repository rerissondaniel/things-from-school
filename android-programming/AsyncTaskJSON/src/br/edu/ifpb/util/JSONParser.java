package br.edu.ifpb.util;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;

public class JSONParser {

	public static JSONArray getJSONFromUrl(String url) {
		DefaultHttpClient httpClient;
		HttpGet httpGet;
		HttpResponse httpResponse;
		HttpEntity entity;

		InputStream inputStream = null; 
		
		JSONArray jsonObject = null;

		try {
			httpClient = new DefaultHttpClient();
			httpGet = new HttpGet(url);
			
			httpResponse = httpClient.execute(httpGet);
			entity = httpResponse.getEntity();
			
			inputStream = entity.getContent();
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		try {
			jsonObject = new JSONArray(strFromInputStream(inputStream));
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		
		return jsonObject;
	}

	public static String strFromInputStream(InputStream inputStream) {
		StringBuilder builder = new StringBuilder();
		BufferedReader bufferedReader;
		String content = null;

		try {
			bufferedReader = new BufferedReader(new InputStreamReader(
					inputStream, "utf-8"), 8);

			while ((content = bufferedReader.readLine()) != null) {
				builder.append(content + "n");
			}

			inputStream.close();
			

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
}
