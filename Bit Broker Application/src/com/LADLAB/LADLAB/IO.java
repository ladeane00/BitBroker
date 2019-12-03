package com.LADLAB.LADLAB;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class IO {

private String token;

//STANDARD CODE FOR JSON READING

public IO(String t) {
token=t;
}

public void setToken(String t) {
token=t;
}

public String HttpGet(String commandString, boolean hasParameters) {
//String token = "8594~yEcMAEbTKkNSNJhCM05dLUDYolu24XpQ0Y8V52VBRkoWgOof4FNgIFFZV7KDZGW1";
String output = null;
String line;

try {
URL url;
if(hasParameters) {
url = new URL("https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest" + commandString + "&CMC_PRO_API_KEY=" + token);
} else {
url = new URL("https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest" + commandString + "?CMC_PRO_API_KEY=" + token);
}
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("GET");
conn.setRequestProperty("Accept", "application/json");
if (conn.getResponseCode() != 200) {
throw new RuntimeException("Failed : HTTP error code : "
+ conn.getResponseCode());
}
BufferedReader br = new BufferedReader(new InputStreamReader(
(conn.getInputStream())));

@SuppressWarnings("resource")
FileWriter writer = new FileWriter("res/bitInfo.txt", true);
Main.clearTheFile("res/bitInfo.txt");
while ((line = br.readLine()) != null) {
	writer.write(line);
 	writer.write("\r\n");
}
conn.disconnect();
} catch(MalformedURLException e) {
e.printStackTrace();
} catch(IOException e) {
e.printStackTrace();
}

return output;
}

}