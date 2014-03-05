package com.preact.preactandroid;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

public class EventLogger {

	private static final String API_URL = "https://api.preact.io/api/v2/events";
	private String projectCode;
	private String apiSecret;

	static private final String TAG = "PreactAndroid";

	public EventLogger(String code, String secret) {
		this.projectCode = code;
		this.apiSecret = secret;
	}

	public void logEvent(String event_json) {
		new LogEventTask().execute(event_json);
	}

	class LogEventTask extends AsyncTask<String, Void, String> {

		protected String doInBackground(String... event_json) {
			// instantiates httpclient to make request
			DefaultHttpClient httpclient = new DefaultHttpClient();

			// url with the post data
			HttpPost httpPost = new HttpPost(API_URL);

			// passes the results to a string builder/entity
			try {
				StringEntity se = new StringEntity(event_json[0]);

				// sets the post request as the resulting string
				httpPost.setEntity(se);

				// sets a request header so the page receving the request
				// will know what to do with it
				httpPost.setHeader("Accept", "application/json");
				httpPost.setHeader("Content-type", "application/json");

				String authorizationString = Base64.encodeToString((projectCode
						+ ":" + apiSecret).getBytes(), Base64.NO_WRAP);
				httpPost.setHeader("Authorization", "Basic "
						+ authorizationString);

				System.out.print(httpPost);

				// Handles what is returned from the page
				ResponseHandler<String> responseHandler = new BasicResponseHandler();
				return httpclient.execute(httpPost, responseHandler);

			} catch (ClientProtocolException exception) {
				exception.printStackTrace();
			} catch (IOException exception) {
				exception.printStackTrace();
			}

			return "Error logging";
		}

		@Override
		protected void onPostExecute(String result) {
			Log.d(TAG, result);
		}

	}
}