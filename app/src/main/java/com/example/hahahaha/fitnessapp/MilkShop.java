package com.example.hahahaha.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MilkShop extends AppCompatActivity {
    private ViewPager viewPager;
    private SlideAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter myadapter;
    private Button check;
    private TextView textView;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk_shop);
        viewPager=findViewById(R.id.viewpager);
        adapter=new SlideAdapter(this);


        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new EqualSpacingItemDecoration(2, EqualSpacingItemDecoration.HORIZONTAL));
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        JSONArray dairy=makeJson();





        myadapter=new adapter(dairy,this);
        recyclerView.setAdapter(myadapter);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout =  findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(viewPager, true);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            public void onPageSelected(int position) {
                // Check if this is the page you want.
                if(position==3){
                    //Toast.makeText(this, "yes new page", Toast.LENGTH_SHORT).show();



                }
            }
        });


    }



    private JSONArray makeJson() {
        JSONObject milk=new JSONObject();
        try{
            milk.put("name","milk");
            milk.put("price",120);
            milk.put("quantity",1);
            milk.put("type","Dairy");
            milk.put("measure","Litre");
        }catch(JSONException e){
            e.printStackTrace();
        }
        JSONObject yougart=new JSONObject();

        try {
            yougart.put("name","yougart");
            yougart.put("price","130");
            yougart.put("quantity",1);
            yougart.put("type","Dairy");
            yougart.put("measure","Kg");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONArray dairy=new JSONArray();
        try {
            dairy.put(0,milk);
            dairy.put(1,yougart);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  dairy;

    }
}
