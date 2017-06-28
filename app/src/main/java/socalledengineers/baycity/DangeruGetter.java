package socalledengineers.baycity;

import android.util.Log;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;

/**
 * Created by Slack Crow on 6/27/2017.
 */

public class DangeruGetter {
    public ArrayList<String> getThreadList(String board, Integer limit) throws IOException, org.json.JSONException
    {
        String address = "https:////boards.dangeru.us/api.php?type=index&board="+board+"&ln="+limit.toString();
        // reference https://stackoverflow.com/questions/34691175/how-to-send-httprequest-and-get-json-response-in-android

        HttpURLConnection urlConnection = null;
        URL url = new URL(address);
        urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(10000);
        urlConnection.setConnectTimeout(15000);

        urlConnection.setDoOutput(true);

        urlConnection.connect();

        BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));

        char[] buffer = new char[1024];

        String jsonString = new String();

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
        }
        br.close();

        // reference ends
        Log.d("JSONReceived", sb.toString());
        JSONObject jsonObj = new JSONObject(sb.toString());
        JSONArray jsonArr = jsonObj.getJSONArray("meta");
        return null;
    }
}
