package yao;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author pangkun
 * @date 2019/5/21 下午3:41
 */
public class Delete {
    public static void main(String[] args) throws IOException, JSONException {
        URLConnection urlConnection = new URL("http://127.0.0.1:8080/yao/delete").openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setConnectTimeout(3000);
        httpURLConnection.setReadTimeout(3000);
        httpURLConnection.setRequestProperty("token", "12345678901782d60a859f3f3cdd1bfc38f8619d35ee65e5f117d1de644c6a1f697f330ebeb");
        httpURLConnection.addRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
        httpURLConnection.addRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.connect();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream()));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","sdfs" );
        bufferedWriter.write(jsonObject.toString());
        bufferedWriter.flush();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String s = "";
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
        }
    }
}
