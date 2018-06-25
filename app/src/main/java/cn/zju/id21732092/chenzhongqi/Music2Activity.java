package cn.zju.id21732092.chenzhongqi;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.iipc.android.tweetlib.SubmitProgram;

public class Music2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private TextView text2;
    private ListView listview;
    private ArrayList<Music> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music2);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }
        setTitle("音乐");
        text2=(TextView)findViewById(R.id.pkgName);
        text2.setText(this.getPackageName());
        listview=(ListView)findViewById(R.id.listMusic);
        getList();
        MusicAdapter adapter=new MusicAdapter(this,R.layout.music_item,list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);

    }
    private MediaPlayer player=new MediaPlayer();

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        player.reset();
        try{
            player.setDataSource(list.get(i).uri);
            player.prepare();
            player.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(player.isPlaying())
            player.stop();
        player.release();
    }

    private void getList() {
        ContentResolver provider=getContentResolver();
        Cursor cursor=provider.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                new String[]{"title","duration","artist",MediaStore.Audio.Media.DATA},null,null,null);
        String s;
        while(cursor.moveToNext()){
            int t=Integer.parseInt(cursor.getString(1))/1000;
            s=String.format("%d:%d",t/60,t%60);
            list.add(new Music(cursor.getString(0),s,cursor.getString(2),cursor.getString(3)));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.music2_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.submit_item) {
            new SubmitProgram().doSubmit(this,"G1");
            return true;
        }

        if(id==R.id.stop_item){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}
