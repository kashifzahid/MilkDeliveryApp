package com.example.hahahaha.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONObject;

public class checkOut extends AppCompatActivity {
    private JSONObject data;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    public checkOut() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        recyclerView=findViewById(R.id.checkOutRecycler);
       recyclerView.addItemDecoration(new EqualSpacingItemDecoration(2,EqualSpacingItemDecoration.VERTICAL));
        //recyclerView.addItemDecoration(new EqualSpacingItemDecoration(0, EqualSpacingItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter =new CheckoutAdapter();
        recyclerView.setAdapter(adapter);

    }

    public checkOut(JSONObject data) {
        this.data = data;
    }
}
