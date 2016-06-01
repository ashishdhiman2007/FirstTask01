package com.example.deepakdhiman.firsttask01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import it.sephiroth.android.library.widget.HListView;

/**
 * Created by DEEPAK DHIMAN on 5/30/2016.
 */
public class VerticalListViewAdapter extends BaseAdapter{
    Context context;
    LayoutInflater inflater;

    //To store row position
    int listPosition;

    public VerticalListViewAdapter(Context context) {
        this.context = context;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //We are using name_array for vertical list
    @Override
    public int getCount() {
        return MainActivity.name_array.size();
    }

    @Override
    public Object getItem(int position) {
        return MainActivity.name_array.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        listPosition = position;
        rowView = inflater.inflate(R.layout.vertical_listview_row,parent, false);

        TextView txtCompleted;
        txtCompleted = (TextView) rowView.findViewById(R.id.txtCompletedItem);
        txtCompleted.setText(MainActivity.name_array.get(position));

        HListView horizontalListview;
        horizontalListview = (HListView) rowView.findViewById(R.id.hListView1);


        HorizontalListViewAdapter horizontalListViewAdapter = new HorizontalListViewAdapter(context,listPosition);
        horizontalListview.setAdapter(horizontalListViewAdapter);
        return rowView;

    }

}
