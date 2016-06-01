package com.example.deepakdhiman.firsttask01;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by DEEPAK DHIMAN on 5/30/2016.
 */
public class HorizontalListViewAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    int listPosition;


    public HorizontalListViewAdapter(Context context, int listPosition)
    {
        this.context = context;
        this.listPosition = listPosition;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return MainActivity.image_array.size();
    }

    @Override
    public Object getItem(int position) {
        return MainActivity.image_array.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View rowView = convertView;
        rowView = inflater.inflate(R.layout.horizontal_listview_row,parent, false);
        ImageView imageView;
        imageView =(ImageView)rowView.findViewById(R.id.imageView);
        imageView.setImageBitmap(decodeFile(MainActivity.image_array.get(position)));
        return rowView;

    }
    public Bitmap decodeFile(int resId) {
        try {
            // decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(context.getResources(), resId, o);
            // Find the correct scale value. It should be the power of 2.
            final int REQUIRED_SIZE = 70;
            int width_tmp = o.outWidth, height_tmp = o.outHeight;
            int scale = 1;
            while (true) {
                if (width_tmp / 2 < REQUIRED_SIZE
                        || height_tmp / 2 < REQUIRED_SIZE)
                    break;
                width_tmp /= 2;
                height_tmp /= 2;
                scale++;
            }

            // decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeResource(context.getResources(), resId, o2);
        } catch (Exception e) {

        }
        return null;
    }
}