package com.example.hp74tu.dragonballz;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static android.R.attr.id;

public class menu extends ListActivity {

    String classes[]={"home","example1","example2"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

       // setListAdapter(new ArrayAdapter<String>(menu.this,android.R.layout.simple_list_item_1,classes));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,classes);


        // Assign adapter to List
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String act = classes[position];
        try{
            Class ourclass = Class.forName("com.example.hp74tu." + act);
            Intent open = new Intent(menu.this, ourclass);

        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
