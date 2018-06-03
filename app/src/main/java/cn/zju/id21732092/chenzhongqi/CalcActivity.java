package cn.zju.id21732092.chenzhongqi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import cn.iipc.android.tweetlib.SubmitProgram;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener {




    private Button btnC_0;
    private Button btnC_1;
    private Button btnC_2;
    private Button btnC_3;
    private Button btnC_4;
    private Button btnC_5;
    private Button btnC_6;
    private Button btnC_7;
    private Button btnC_8;
    private Button btnC_9;
    private Button btnC_add;
    private Button btnC_mul;
    private Button btnC_minus;
    private Button btnC_div;
    private Button btnC_equal;
    private Button btnC_delete;
    private TextView tv;
    private static final String TAG = "CalcActivity";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        
        btnC_0 = (Button) findViewById(R.id.c_0);
        btnC_1 = (Button) findViewById(R.id.c_1);
        btnC_2 = (Button) findViewById(R.id.c_2);
        btnC_3 = (Button) findViewById(R.id.c_3);
        btnC_4 = (Button) findViewById(R.id.c_4);
        btnC_5 = (Button) findViewById(R.id.c_5);
        btnC_6 = (Button) findViewById(R.id.c_6);
        btnC_7 = (Button) findViewById(R.id.c_7);
        btnC_8 = (Button) findViewById(R.id.c_8);
        btnC_9 = (Button) findViewById(R.id.c_9);
        btnC_div = (Button) findViewById(R.id.c_div);
        btnC_minus = (Button) findViewById(R.id.c_minus);
        btnC_mul = (Button) findViewById(R.id.c_mul);
        btnC_equal = (Button) findViewById(R.id.c_equal);
        btnC_add = (Button) findViewById(R.id.c_add);
        btnC_delete = (Button) findViewById(R.id.c_delete);
        tv = (TextView) findViewById(R.id.tv);
        btnC_0.setOnClickListener(this);
        btnC_1.setOnClickListener(this);
        btnC_2.setOnClickListener(this);
        btnC_3.setOnClickListener(this);
        btnC_4.setOnClickListener(this);
        btnC_5.setOnClickListener(this);
        btnC_6.setOnClickListener(this);
        btnC_7.setOnClickListener(this);
        btnC_8.setOnClickListener(this);
        btnC_9.setOnClickListener(this);
        btnC_add.setOnClickListener(this);
        btnC_minus.setOnClickListener(this);
        btnC_mul.setOnClickListener(this);
        btnC_equal.setOnClickListener(this);
        btnC_delete.setOnClickListener(this);
        btnC_div.setOnClickListener(this);

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
            new SubmitProgram().doSubmit(this,"C1");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.c_0 :
                tv.append((String)((Button)view).getText());
                Log.d(TAG,"btn0");
                break;
            case R.id.c_1 :
                tv.append((String)((Button)view).getText());
                Log.d(TAG,"btn0");
                break;
            case R.id.c_2 :
                tv.append((String)((Button)view).getText());
                Log.d(TAG,"btn0");
                break;
            case R.id.c_3 :
                tv.append((String)((Button)view).getText());
                Log.d(TAG,"btn0");
                break;
            case R.id.c_4 :
                tv.append((String)((Button)view).getText());
                Log.d(TAG,"btn0");
                break;
            case R.id.c_5 :
                tv.append((String)((Button)view).getText());
                Log.d(TAG,"btn0");
                break;
            case R.id.c_6 :
                tv.append((String)((Button)view).getText());
                Log.d(TAG,"btn0");
                break;
            case R.id.c_7 :
                tv.append((String)((Button)view).getText());
                Log.d(TAG,"btn0");
                break;
            case R.id.c_8 :
                tv.append((String)((Button)view).getText());
                Log.d(TAG,"btn0");
                break;
            case R.id.c_9 :
                tv.append((String)((Button)view).getText());
                Log.d(TAG,"btn0");
                break;
            case R.id.c_delete :
                tv.setText("");
                Log.d(TAG,"btn0");
                break;

        }

    }
}
