package jeopardyReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class webRequest {	
	
	private String urlString = new String();
	private String responseText = new String();
	
	public void loadPage() throws Exception{

		URL url = new URL(urlString);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("GET");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String output;
		StringBuffer response = new StringBuffer();
		
		while ((output = in.readLine()) != null) {
			response.append(output);
		}
		in.close();
		
		responseText = response.toString();
		
	}
	
	public void  setUrlString(String userUrl) {
		
		urlString = userUrl;
		
	}
	
	public String getResponseText() {
		
		return responseText;
		
	}
		
	
}
