package com.example.student.a2018010803;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    //String str[]={"aa","bb","cc","dd","ee"};//af2
    ArrayList<Map<String,Object>> mylist=new ArrayList();//af4
    boolean chks[]=new boolean[8];//af6
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HashMap<String, Object> m1 = new HashMap<>();//af4
        m1.put("city", "台北");
        m1.put("code", "02");
        m1.put("img", R.drawable.tpe);
        mylist.add(m1);
        HashMap<String, Object> m2 = new HashMap<>();
        m2.put("city", "台中");
        m2.put("code", "04");
        m2.put("img", R.drawable.tc);
        mylist.add(m2);
        HashMap<String, Object> m3 = new HashMap<>();
        m3.put("city", "台南");
        m3.put("code", "06");
        m3.put("img", R.drawable.tn);
        mylist.add(m3);
        HashMap<String, Object> m4 = new HashMap<>();
        m4.put("city", "高雄");
        m4.put("code", "07");
        m4.put("img", R.drawable.kh);
        mylist.add(m4);

        HashMap<String, Object> m5 = new HashMap<>();//af5
        m5.put("city", "台北2");
        m5.put("code", "022");
        m5.put("img", R.drawable.tpe);
        mylist.add(m1);
        HashMap<String, Object> m6 = new HashMap<>();
        m6.put("city", "台中2");
        m6.put("code", "042");
        m6.put("img", R.drawable.tc);
        mylist.add(m6);
        HashMap<String, Object> m7 = new HashMap<>();
        m7.put("city", "台南2");
        m7.put("code", "062");
        m7.put("img", R.drawable.tn);
        mylist.add(m7);
        HashMap<String, Object> m8 = new HashMap<>();
        m8.put("city", "高雄2");
        m8.put("code", "072");
        m8.put("img", R.drawable.kh);
        mylist.add(m8);
        lv = findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter();
        lv.setAdapter(adapter);

    }
    public void click1(View v)
    {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<chks.length;i++)
        {
            if (chks[i])
            {
                sb.append(mylist.get(i).get("city") + ",");
            }

        }
        Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_SHORT).show();//不能放在迴圈裡會造成讀取２次
    }


    ss MyAdapter extends BaseAdapter {

            @Override
            public int getCount() {
                //return 5;//af1
                //return str.length;//af2
                return mylist.size();//af5
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
            public View getView(final int position, View view, ViewGroup viewGroup) {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);//af3
                Log.d("GetView","position"+position);//af5 checkbox只要往下或往上移剛剛所勾選的就會消失
                View v = inflater.inflate(R.layout.test, null);//af3

                //TextView tv=new TextView(MainActivity.this);//af2
                //TextView tv=v.findViewById(R.id.textView);//af3
                //tv.setText("hello" + position);//af1
                //tv.setText(str[position]);//af2
                //return tv;//af2
                //return v;//af3

                TextView tv = v.findViewById(R.id.textView);//af4
                tv.setText(mylist.get(position).get("city").toString());
                TextView tv2 = v.findViewById(R.id.textView2);
                tv.setText(mylist.get(position).get("code").toString());
                ImageView img=v.findViewById(R.id.imageView);
                img.setImageResource((Integer)mylist.get(position).get("img"));
                CheckBox chk=v.findViewById(R.id.checkBox);//af6-1
                chk.setChecked(chks[position]);//af6-3
                chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        chks[position]=b;//af6-2
                    }
                });
                return v;
            }

        }


    }

