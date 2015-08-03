package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Office365Utils
{
	// TODO
	private static final String TENANT_ID = "TODO";
	private static final String CLIENT_ID = "TODO";
	private static final String CLIENT_SECRET = "TODO";
	private static final String RESOURCE_ID = "https://TODO-my.sharepoint.com";

	public static String getAuthCodeUrl()
	{
		String url = "https://login.microsoftonline.com/" + TENANT_ID + "/oauth2/authorize?response_type=code&client_id=" + CLIENT_ID;
		return url;
	}

	public static String getAccessToken(String authCode) throws Exception
	{
		String url = "https://login.microsoftonline.com/" + TENANT_ID + "/oauth2/token";
		String request = "grant_type=authorization_code" 
				+ "&client_id=" + CLIENT_ID 
				+ "&code=" + authCode 
				+ "&resource=" + encode(RESOURCE_ID) 
				+ "&client_secret=" + encode(CLIENT_SECRET);
		String response = post(url, request);
		JsonObject responseJson = toJsonObject(response);
		String accessToken = responseJson.get("access_token").getAsString();
		return accessToken;
	}

	private static String encode(String value) throws UnsupportedEncodingException
	{
		return URLEncoder.encode(value, "UTF-8");
	}

	private static String post(String url, String request) throws Exception
	{
		URL readerUrl = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) readerUrl.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setConnectTimeout(10000);
		connection.setReadTimeout(0);
		connection.setUseCaches(false);
		connection.setDefaultUseCaches(false);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		OutputStreamWriter statuswriter = new OutputStreamWriter(connection.getOutputStream());
		statuswriter.write(request);
		statuswriter.flush();
		statuswriter.close();
		BufferedReader readbr = new BufferedReader(new InputStreamReader((connection.getInputStream())));
		String output = readbr.readLine();
		connection.disconnect();
		if (output == null)
		{
			return null;
		}
		return output;
	}

	private static JsonObject toJsonObject(String json)
	{
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(json).getAsJsonObject();
		return jsonObject;
	}
}
