package com.example.student.a2018010803;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Student on 2018/1/9.
 */

public class MyAdapter extends BaseAdapter {
    boolean chks[];
    Context context;
    ArrayList<Map<String,Object>> mylist=new ArrayList();
    public MyAdapter(Context context,ArrayList<Map<String,Object>> mylist,boolean chks[])
    {
        this.context=context;
        this.mylist=mylist;
        this.chks=chks;
    }
    @Override
    public int getCount() {

        return mylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View v, ViewGroup viewGroup) {
        ViewHolder viewHolder;//m3
        if (v==null)//m2
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.test, null);
            viewHolder=new ViewHolder();//m3
            viewHolder.tv = v.findViewById(R.id.textView);
            viewHolder.tv2 = v.findViewById(R.id.textView2);
            viewHolder.img=v.findViewById(R.id.imageView);
            viewHolder.chk=v.findViewById(R.id.checkBox);
        }
        else
        {
            viewHolder=(ViewHolder)v.getTag();
        }

//        TextView tv = v.findViewById(R.id.textView);
//        TextView tv2 = v.findViewById(R.id.textView2);
//        ImageView img=v.findViewById(R.id.imageView);
//        CheckBox chk=v.findViewById(R.id.checkBox);

        viewHolder.tv.setText(mylist.get(position).get("city").toString());
        viewHolder.tv.setText(mylist.get(position).get("code").toString());
        viewHolder.img.setImageResource((Integer)mylist.get(position).get("img"));
        viewHolder.chk.setOnCheckedChangeListener(null);//m4
        viewHolder.chk.setChecked(chks[position]);
        viewHolder.chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chks[position]=b;
            }
        });
        v.setTag(viewHolder);
        return v;
    }
    static class ViewHolder//m3
    {
        TextView tv;
        TextView tv2;
        ImageView img;
        CheckBox chk;
    }

}
