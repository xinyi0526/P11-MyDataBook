package com.myapplicationdev.android.p12_mydatabook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class CustomAdapter extends BaseAdapter {

    private Context mContext;
    private  String[] item;
    private int[] icon;

    public CustomAdapter( Context context, String[] text, int[] iconId){
        this.mContext = context;
        this.item = text;
        this.icon = iconId;


    }

    @Override
    public int getCount() {
        return item.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);
        TextView title;
        ImageView i1;
        i1 = (ImageView) rowView.findViewById(R.id.imageView);
        title = (TextView) rowView.findViewById(R.id.textView);
        title.setText(item[position]);
        i1.setImageResource(icon[position]);

        return rowView;
    }





}
