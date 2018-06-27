package com.example.hahahaha.fitnessapp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {
    private JSONArray dairy;
    private Context context;

    public adapter(JSONArray array, Context context) {
        this.dairy = array;
        this.context = context;
        int i=dairy.length();
        while(i>-1){
            dairy.remove(i);
            i--;

        }

    }

    @NonNull
    @Override
    public adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_listitems_milk, parent, false);

        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private RelativeLayout rel;
        private Context context;
        private Button cart;
        private GridLayout grid;
        private Button add;
        private Button delete;
        private EditText num;
        private TextView price;
        private TextView name;

        public ViewHolder(View itemView, final Context context) {
            super(itemView);
            textView = itemView.findViewById(R.id.cart);
            this.context = context;

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setVisibility(View.GONE);

                    called(context);

                }
            });
        }

        private void called(Context context) {
//            Toast.makeText(context, " ended", Toast.LENGTH_SHORT).show();
            //AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);

            final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.dialog);
            cart = dialog.findViewById(R.id.cart);
            grid = dialog.findViewById(R.id.grid);
            add = dialog.findViewById(R.id.added);
            delete = dialog.findViewById(R.id.delete);
            num = dialog.findViewById(R.id.num);
            price = dialog.findViewById(R.id.price);
            name = dialog.findViewById(R.id.name);


            dialog.show();

            cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Toast.makeText( context1, "my custome dialog box", Toast.LENGTH_SHORT).show();
                    //dialog.cancel();
                    cart.setVisibility(View.GONE);
                    grid.setVisibility(View.VISIBLE);

                    add.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int number = Integer.valueOf(num.getText().toString());
                            int prices = Integer.valueOf(price.getText().toString());
                            String names = name.getText().toString();
                            if(getAdapterPosition()==1){
                                names="dahi";
                            }
                            number++;
                            AddToCart(number, prices, names);


                  String text=String.valueOf(number);
                            num.setText(text);


                        }
                    });
                    delete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int number = Integer.valueOf(num.getText().toString());
                            int prices = Integer.valueOf(price.getText().toString());
                            String names = name.getText().toString();
                            if(getAdapterPosition()==1){
                                names="dahi";
                            }

                            if (number == 1) {
                                delete.setText("del");
                            }
                            if (delete.getText() == "del") {
                                number = 0;
                                cart.setVisibility(View.VISIBLE);
                                grid.setVisibility(View.GONE);

                            }

                            number--;
                            AddToCart(number, prices, names);
                            String text=String.valueOf(number);
                            num.setText(text);
                        }
                    });

                }
            });


            //alertDialog.setTitle("SHOW");
       /* alertDialog.setNeutralButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "working", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.show();*/
        }

        public void AddToCart(int number, int price, String name) {

            int quantity=number;
            int rate=price;
            String productName=name;



                try {
                    if(dairy.length()>0) {
                        Boolean found=false;
                        int at=0;
                        for(int i=0;i<dairy.length();i++){

                            if (dairy.getJSONObject(i).getString("ProductName")==name) {
                                at=i;
                                Log.d("cart", "AddToCart: "+found);
                                found=true;

                                break;
                                }
                            else {
                                found=false;

                                }
                                }
                        Log.d("cart", "AddToCart:Mix: "+found);
                        if(found){
                            dairy.getJSONObject(at).put("quantity", number);
                            Log.d("cart", "AddToCart2: "+found);
                        }
                        else{
                            JSONObject d = new JSONObject();
                            d.put("quantity", number);
                            d.put("price", price);
                            d.put("ProductName", name);
                            dairy.put(dairy.length()-1,d);
                            Log.d("cart", "AddToCart3: "+found);
                        }
                        }
                    else{
                        JSONObject d = new JSONObject();
                        d.put("quantity", number);
                        d.put("price", price);
                        d.put("ProductName", name);
                        dairy.put(0,d);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            try {
                    for(int i=0;i<dairy.length();i++) {


                        Log.d("data", "Array: " + dairy.getJSONObject(i));
                    }
            } catch (JSONException e) {
                e.printStackTrace();
            }


            ;
        }
    }
}
