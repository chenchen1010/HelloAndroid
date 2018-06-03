package cn.zju.id21732092.chenzhongqi;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.CollationElementIterator;

import cn.iipc.android.tweetlib.SubmitProgram;
import cn.iipc.android.tweetlib.YambaClient;
import cn.iipc.android.tweetlib.YambaClientException;

public class StatusActivity extends AppCompatActivity{


    private EditText editStatus;
    private String TAG = "StatusActivity";
    private Button btnPost;
    private TextView pkgName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        editStatus = (EditText) findViewById(R.id.editStatus);
        btnPost = (Button) findViewById(R.id.btnPost);
        pkgName = (TextView) findViewById(R.id.txtPkg);

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status = editStatus.getText().toString();
                Log.d(TAG,"Be clicked with staus:" + status);
                new PostTask().execute(status);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hello, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            new SubmitProgram().doSubmit(this, "D2");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    private final class PostTask extends AsyncTask<String, Void, String> {


        private String username = "student";
        private String password = "password";

        @Override
        protected String doInBackground(String... params) {

            YambaClient yambaClloud = new YambaClient(username,password);
            try {
                yambaClloud.postStatus( params[0] );
                return "Successfully posted:"+params[0].length()+"chars";
            } catch (YambaClientException e) {
                e.printStackTrace();
                return "Failed to post to yamba service";
            }
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Toast.makeText(StatusActivity.this,result,Toast.LENGTH_LONG);

            pkgName.setText(result+" BY<"+getPackageName()+">");
            if(result.startsWith("Successfully")){
                editStatus.setText("");
            }
        }
    }
}
