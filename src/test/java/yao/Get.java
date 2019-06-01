package yao;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author pangkun
 * @date 2019/5/8 上午10:08
 */
public class Get {
    public static void main(String[] args) throws IOException, JSONException {
        URLConnection urlConnection = new URL("http://127.0.0.1:8080/yao/get").openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setConnectTimeout(3000);
        httpURLConnection.setReadTimeout(3000);
        httpURLConnection.setRequestProperty("token", "123456789124704bbb63e90a7a17a747ab8bb04b5edd0461894b68238bd69f118635677b51f");
        httpURLConnection.addRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
        httpURLConnection.addRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.connect();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String s = "";
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
        }
    }
}
