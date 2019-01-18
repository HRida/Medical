package com.example.ousama.medical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spSpecialist, spRegion;
    private Button btFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spSpecialist = (Spinner)findViewById(R.id.spSpecialist);
        spRegion = (Spinner)findViewById(R.id.spRegion);
        btFind = (Button)findViewById(R.id.btFind);

        Med m1 = new Med(this);
        m1.updateSpecialists(spSpecialist);
        m1.updateRegions(spRegion);

        spRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Region.name = ((TextView)view).getText().toString();
                Region.longitute = Med.AllLocations.get(position).getLon();
                Region.latitude = Med.AllLocations.get(position).getLat();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String specialist = spSpecialist.getSelectedItem().toString();
                Intent i1 = new Intent(MainActivity.this, FindDoctor.class);
                i1.putExtra("specialist", specialist);
                startActivity(i1);
            }
        });


    }
}
