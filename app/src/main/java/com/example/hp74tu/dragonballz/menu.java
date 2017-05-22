package com.example.hp74tu.dragonballz;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import static android.R.attr.id;

public class menu extends ListActivity {

    String classes[]={"Home","GOKU","GOHAN","VEGETA","SUPERSAIYEN","WALLPAPERS","me","Contact"};
    String classname[]={"HOME","GOKU","GOHAN","VEGETA","SUPERSAIYEN","WALLPAPERS","ME","CONTACT US"};
    TextView content;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        content = (TextView)findViewById(R.id.output);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,classname);


        // Assign adapter to classes
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // ListView Clicked item index
        //int itemPosition     = position;

        // ListView Clicked item value
        //String  itemValue    = (String) l.getItemAtPosition(position);
        String itemValue = classes[position].toLowerCase();

       // content.setText("Click : \n  Position :"+itemPosition+"  \n  ListItem : " +itemValue);

        try{
           Class ourclass = Class.forName("com.example.hp74tu.dragonballz." + itemValue);
            Intent open = new Intent(this, ourclass);
            startActivity(open);

        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }
}
