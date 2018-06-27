package com.example.hahahaha.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.hahahaha.fitnessapp.R.id.name;

public class Cart extends AppCompatActivity {
    private Button AddCart;
    private GridLayout grid;
    private Button add;
    private Button delete;
    private EditText num;
    private TextView price;
    private TextView name;
    private JSONArray dairy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        dairy=new JSONArray();


        AddCart = findViewById(R.id.cart);
        grid = findViewById(R.id.grid);
        add = findViewById(R.id.added);
        delete = findViewById(R.id.delete);
        num = findViewById(R.id.num);
        price = findViewById(R.id.price);
        name = findViewById(R.id.name);


        AddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCart.setVisibility(View.GONE);
                grid.setVisibility(View.VISIBLE);

                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int number = Integer.valueOf(num.getText().toString());
                        int prices = Integer.valueOf(price.getText().toString());
                        String names = name.getText().toString();
                        number++;
                        AddToCart(number, prices, names);


                        num.setText(number);


                    }
                });
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int number = Integer.valueOf(num.getText().toString());
                        int prices = Integer.valueOf(price.getText().toString());
                        String names = name.getText().toString();

                        if (number == 1) {
                            delete.setText("del");
                        }
                        if (delete.getText() == "del") {
                            number = 0;
                            AddCart.setVisibility(View.VISIBLE);
                            grid.setVisibility(View.GONE);

                        }

                        number--;
                        AddToCart(number, prices, names);
                        num.setText(number);
                    }
                });

            }
        });

    }
        private void AddToCart ( int number, int prices, String names){
            int quantity = number;
            int rate = prices;
            String productName = names;



            try {
                if (dairy.length() > 0) {
                    for (int i = 0; i < dairy.length(); i++) {

                        if (dairy.getJSONObject(i).has(names)) {
                            dairy.getJSONObject(i).put("quantity", number);

                            break;


                        } else if (!dairy.getJSONObject(i).has(names)) {
                            for (int j = 1; j < dairy.length(); j++) {
                                if (!dairy.getJSONObject(j).has(names)) {

                                }

                            }


                        }


                    }
                } else {
                    JSONObject d = new JSONObject();
                    d.put("quantity", number);
                    d.put("price", prices);
                    d.put("ProductName", name);
                    dairy.put(0, d);
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }



