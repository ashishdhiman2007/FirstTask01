package com.example.deepakdhiman.firsttask01;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    ListView listView;
    Context context;
    VerticalListViewAdapter adapter;

    //Used directly in VerticalListViewAdapter getCount(),getItem(),getView() with help of ViewHolder
    public static List<String> name_array=new ArrayList<>();
    //Used directly in HorizontalListViewAdapter getCount(),getItem(),getView() with help of ViewHolder
    public static List<Integer> image_array=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;

        listView= (ListView) findViewById(R.id.listView);

        adapter=new VerticalListViewAdapter(context);

        //Adding strings to ArrayList
        name_array.add(" ITEM ONE");
        name_array.add(" ITEM TWO");
        name_array.add(" ITEM THREE");
        name_array.add(" ITEM FOUR");
        name_array.add(" ITEM FIVE");
        name_array.add(" ITEM SIX");
        name_array.add(" ITEM SEVEN");
        name_array.add(" ITEM EIGHT");
        name_array.add(" ITEM NINE");
        name_array.add(" ITEM TEN");

        //Adding Integer values to ArrayList
        image_array.add(R.drawable.one);
        image_array.add(R.drawable.two);
        image_array.add(R.drawable.three);
        image_array.add(R.drawable.four);
        image_array.add(R.drawable.five);
        image_array.add(R.drawable.six);
        image_array.add(R.drawable.seven);
        image_array.add(R.drawable.eight);
        image_array.add(R.drawable.nine);
        image_array.add(R.drawable.ten);

        listView.setAdapter(adapter);

        //To enable fast scrolling
        //Specifies whether fast scrolling is enabled or disabled.
        listView.setFastScrollEnabled(true);

    }


}
