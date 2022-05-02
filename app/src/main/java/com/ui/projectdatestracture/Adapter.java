package com.ui.projectdatestracture;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ui.projectdatestracture.nodes.person;

import java.util.ArrayList;
import java.util.HashMap;

public class Adapter extends BaseAdapter {

    LayoutInflater inflater;
    ArrayList< person> list;

    public Adapter(ArrayList<person> list , LayoutInflater inflater) {
        this.inflater = inflater;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public person getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = inflater.inflate(R.layout.item,null,false);

        TextView tvw = v.findViewById(R.id.tvw);
        TextView im1 = v.findViewById(R.id.im1);
        TextView im2 = v.findViewById(R.id.im2);

        tvw.setText(list.get(position).getName()+" "+list.get(position).getFamily()+"-"+list.get(position).getBirthdayPlace()+"-"+list.get(position).getWorkPlace());

        return v;
    }
}
