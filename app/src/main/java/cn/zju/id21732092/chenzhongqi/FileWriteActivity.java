package cn.zju.id21732092.chenzhongqi;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import cn.iipc.android.tweetlib.SubmitProgram;

public class FileWriteActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1,button2,button3;
    private TextView textMsg;

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE" };
    public static void verifyStoragePermissions(Activity activity) {

        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_write);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        textMsg = (TextView) findViewById(R.id.textMsg);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        verifyStoragePermissions(this);

    }

    @Override
    public void onClick(View view) {
        if(view == button1){
            fileTestWrite(getFilesDir().getPath());
        }else if(view==button2){
            fileTestWrite(Environment.getExternalStorageDirectory().getPath());
        }else if(view==button3){
            fileTestWrite(getExternalFilesDir(null).getPath());
        }


    }

    private void fileTestWrite(String dir) {
        String fn = dir + "/hello.txt";

        try {
            textMsg.setText(textMsg.getText()+"\nWrite to:"+fn);
            PrintWriter o = new PrintWriter(new BufferedWriter(new FileWriter(fn)));
            o.println(fn);
            o.close();
        } catch (IOException e) {
            e.printStackTrace();
            textMsg.setText(textMsg.getText()+"\nWrite to: "+e.toString());
        }
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
            new SubmitProgram().doSubmit(this,"E1");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
