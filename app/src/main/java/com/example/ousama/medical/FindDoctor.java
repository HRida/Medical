package com.example.ousama.medical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FindDoctor extends AppCompatActivity {

    private ListView ls;
    private Button btGetMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        Intent i1 = getIntent();
        DBHelper db = new DBHelper(this);
        ls = (ListView)findViewById(R.id.ls);
        btGetMap = (Button)findViewById(R.id.btGetMap);
        ArrayList<Doctor> doctors = db.findDoctor(i1.getStringExtra("specialist"), Region.name);
        ls.setAdapter(new ArrayAdapter<Doctor>(this, android.R.layout.simple_list_item_1, doctors));

        btGetMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(FindDoctor.this, MapsActivity.class);
                startActivity(i1);
            }
        });

    }
}
