package user;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author pangkun
 * @date 2019/5/5 下午12:35
 */
public class Register {
    public static void main(String[] args) throws IOException, JSONException {
        URLConnection urlConnection = new URL("http://127.0.0.1:8080/user/register").openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setConnectTimeout(3000);
        httpURLConnection.setRequestProperty("token","13100001111ef23" );
        httpURLConnection.setReadTimeout(3000);
        httpURLConnection.addRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
        httpURLConnection.addRequestProperty("Content-Type", "application/json");
        httpURLConnection.connect();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream()));
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","123" );
        jsonObject.put("password", "456");
        bufferedWriter.write(jsonObject.toString());
        bufferedWriter.flush();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String s = "";
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
        }
    }
}
