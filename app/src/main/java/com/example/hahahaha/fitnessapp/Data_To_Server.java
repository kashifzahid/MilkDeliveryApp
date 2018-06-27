package com.example.hahahaha.fitnessapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Data_To_Server {
    private static final String url="http://192.168.10.2:8080";
    private Context context;

    public Data_To_Server(Context con) {
        this.context=con;

    }
    public  void sendData(){
        JsonObjectRequest request3=new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(context, "SUCCESSFFUL", Toast.LENGTH_LONG).show();
                Log.i("success", "Successsfull :yes yes");
                try {
                    Log.i("yep","ok"+response.getString("id"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }

        });
        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(request3);
    }
}
