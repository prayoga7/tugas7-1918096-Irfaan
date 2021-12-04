package com.example.listfavoritefootballclubapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainUpdel extends AppCompatActivity {

    private MyDatabase db;
    private String Sid, SClub, SJuara, SLiga;
    private EditText EClub, EJuara, ELiga;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        SClub = i.getStringExtra("Iclub");
        SJuara = i.getStringExtra("Ijuara");
        SLiga = i.getStringExtra("Iliga");
        EClub = (EditText) findViewById(R.id.edit_club);
        EJuara = (EditText) findViewById(R.id.edit_juara);
        ELiga = (EditText) findViewById(R.id.edit_liga);

        EClub.setText(SClub);
        EJuara.setText(SJuara);
        ELiga.setText(SLiga);

        Button btnUpdate = (Button) findViewById(R.id.edit_btn);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SClub = String.valueOf(EClub.getText());
                SJuara = String.valueOf(EJuara.getText());
                if (SClub.equals("")){
                    EClub.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama Club",
                            Toast.LENGTH_SHORT).show();
                } else if (SJuara.equals("")){
                    EJuara.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi title Juara",
                            Toast.LENGTH_SHORT).show();
                } else if (SLiga.equals("")){
                    EJuara.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi Liga",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateFootball(new Football(Sid, SClub,
                            SJuara,SLiga));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        Button btnDelete = (Button) findViewById(R.id.del_btn);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteFootball(new Football(Sid, SClub,
                        SJuara, SLiga));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
