package socalledengineers.baycity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DangeruGetter _apiWrapper;
    ArrayList<String> _boardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ArrayList<String> _boardList = new ArrayList<String>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _apiWrapper = new DangeruGetter();
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v){
            EditText boardName = (EditText) findViewById(R.id.editText);
            String boardNameString = boardName.getText().toString();
            networkStuffDoer doNetwork = new networkStuffDoer();
            doNetwork.execute(boardNameString);
            TextView tView = (TextView) findViewById(R.id.textView);
        }
        });
    }
    private class networkStuffDoer extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String[] params) {
            try {
                _boardList =_apiWrapper.getThreadList(params[0], 10);
            }
            catch (IOException e){
                System.out.println("Fetch Error");
            }
            catch(org.json.JSONException e){
                System.out.println("JSON Error");
            }
            return "null";
        }

        @Override
        protected void onPostExecute(String message) {
        }
    }
}
