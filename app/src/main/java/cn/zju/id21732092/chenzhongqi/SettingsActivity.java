package cn.zju.id21732092.chenzhongqi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import cn.iipc.android.tweetlib.SubmitProgram;
import cn.iipc.android.tweetlib.YambaClient;
import cn.iipc.android.tweetlib.YambaClientException;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
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
            new SubmitProgram().doSubmit(this, "E2");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


//    private final class PostTask extends AsyncTask<String,void,String>{
//
//        @Override
//        protected String doInBackground(String... params) {
//            SharedPreferences prefs =
//                    PreferenceManager.getDefaultSharedPreferences(StatusActivity.this);
//            String username = prefs.getString("username","");
//            String password = prefs.getString("password","");
//            if(TextUtils.isEmpty(username)||TextUtils.isEmpty(password)){
//                startActivity(new Intent(StatusActivity.this,SettingsActivity.class));
//                return "Please update your username ad password";
//            }
//
//            YambaClient yambaCloud = new YambaClient(username,password);
//            try {
//                yambaCloud.postStatus(params[0]);
//                return "Successfully posted";
//            } catch (YambaClientException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
}
