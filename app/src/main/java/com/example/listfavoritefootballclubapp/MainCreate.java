package com.example.listfavoritefootballclubapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainCreate extends AppCompatActivity {

    private MyDatabase db;
    private EditText EClub, EJuara, ELiga;
    private String SClub, SJuara, SLiga;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        EClub = (EditText) findViewById(R.id.create_club);
        EJuara = (EditText) findViewById(R.id.create_juara);
        ELiga = (EditText) findViewById(R.id.create_liga);

        Button btnCreate = (Button)
                findViewById(R.id.create_btn);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SClub = String.valueOf(EClub.getText());
                SJuara = String.valueOf(EJuara.getText());
                SLiga = String.valueOf(ELiga.getText());

                if (SClub.equals("")){
                    EClub.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama Club",
                            Toast.LENGTH_SHORT).show();
                }
                else if (SJuara.equals("")) {
                    EJuara.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Title Juara",
                            Toast.LENGTH_SHORT).show();
                }else if(SLiga.equals("")){
                    ELiga.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Liga", Toast.LENGTH_SHORT).show();
                }
                else {
                    EClub.setText("");
                    EJuara.setText("");
                    ELiga.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateFootball(new Football(null, SClub,
                            SJuara, SLiga));

                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
