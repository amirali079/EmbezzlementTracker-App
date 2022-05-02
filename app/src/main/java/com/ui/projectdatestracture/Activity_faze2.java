package com.ui.projectdatestracture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.ui.projectdatestracture.nodes.person;

import java.util.ArrayList;

public class Activity_faze2 extends AppCompatActivity {

    ListView lv ;

    ArrayList<person>list = new ArrayList<>();
    Adapter adapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faze2);
        lv = findViewById(R.id.lv);




        adapt();
    }

    private void adapt() {

        for(person p : activity_2.g.getMaznonin2().values())
            list.add(p);

       adapter = new Adapter(list , getLayoutInflater());
       lv.setAdapter(adapter);
       adapter.notifyDataSetChanged();


    }
}
