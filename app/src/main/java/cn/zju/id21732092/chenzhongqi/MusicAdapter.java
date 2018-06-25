package cn.zju.id21732092.chenzhongqi;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MusicAdapter extends ArrayAdapter<Music> {
    private int rowResource;
    public MusicAdapter(Context context, int resource, List<Music> objects) {
        super(context, resource, objects);
        this.rowResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Music music=getItem(position);
        View view;
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(rowResource,parent,false);
        }else view =convertView;
        TextView txtName,txtDuration,txtAuthor;
        txtName=(TextView)view.findViewById(R.id.txtName);
        txtAuthor=(TextView)view.findViewById(R.id.txtAuthor);
        txtDuration=(TextView)view.findViewById(R.id.txtDuration);
        txtName.setText(music.name);
        txtAuthor.setText(music.author);
        txtDuration.setText(music.duration);
        return view;
    }
}
