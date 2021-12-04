package com.example.listfavoritefootballclubapp;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Football> Football;

    public CustomListAdapter(Activity activity, List<Football> Football ){
        this.activity = activity;
        this.Football = Football;
    }

    @Override
    public int getCount(){
        return Football.size();
    }

    @Override
    public Object getItem(int juara){
        return Football.get(juara);
    }

    public long getItemId(int position){
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if(inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView == null){
            convertView = inflater.inflate(R.layout.custom_list, null);
        }

        TextView footballClub = (TextView) convertView.findViewById(R.id.football_club);
        TextView juara = (TextView) convertView.findViewById(R.id.juara);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.juaraImage);

        Football p = Football.get(position);
        footballClub.setText("Nama Tempat:" + p.get_club());
        juara.setText("Lokasi: " + p.get_juara());

        return convertView;
    }
}
