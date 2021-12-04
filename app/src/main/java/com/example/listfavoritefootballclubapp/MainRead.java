package com.example.listfavoritefootballclubapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView pListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Football> ListFootball = new
            ArrayList<Football>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListFootball);
        pListView = (ListView) findViewById(R.id.list_football);
        pListView.setAdapter(adapter_off);
        pListView.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        pListView.setClickable(true);
        ListFootball.clear();

        List<Football> football = db.ReadFootball();
        for (Football fb : football) {
            Football daftar = new Football();
            daftar.set_id(fb.get_id());
            daftar.set_club(fb.get_club());
            daftar.set_juara(fb.get_juara());
            daftar.set_liga(fb.get_liga());

            ListFootball.add(daftar);
            if ((ListFootball.isEmpty())) {
                Toast.makeText(MainRead.this, "No data found",
                        Toast.LENGTH_SHORT).show();
            } else {

            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = pListView.getItemAtPosition(i);
        Football detailFootball = (Football)o;
        String Sid = detailFootball.get_id();
        String SClub = detailFootball.get_club();
        String SJuara = detailFootball.get_juara();
        String SLiga = detailFootball.get_liga();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Iclub", SClub);
        goUpdel.putExtra("Ijuara", SJuara);
        goUpdel.putExtra("Iliga", SLiga);

        startActivity(goUpdel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListFootball.clear();
        pListView.setAdapter(adapter_off);
        List<Football> football = db.ReadFootball();
        for (Football fb : football) {
            Football daftar = new Football();
            daftar.set_id(fb.get_id());
            daftar.set_club(fb.get_club());
            daftar.set_juara(fb.get_juara());
            daftar.set_liga(fb.get_liga());
            ListFootball.add(daftar);
            if ((ListFootball.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
