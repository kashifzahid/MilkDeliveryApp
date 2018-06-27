package com.example.hahahaha.fitnessapp;



import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class SlideAdapter extends PagerAdapter{
    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==object);
    }
    public int[] images ={
            R.drawable.dairy1,
            R.drawable.dairy2,
            R.drawable.dairy3,
            R.drawable.dairy4


    };
    public String [] titles={
            "Gym Activity",
            "pushup",
            "something",
            "push gym some"
    };
    public int [] background_1={
            Color.rgb(170,230,70),
            Color.rgb(170,230,70),
            Color.rgb(170,230,70),
            Color.rgb(170,230,70)


    };
    @Override
    public int getCount() {
        return images.length ;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide,container,false);
        //RelativeLayout relativeLayout=view.findViewById(R.id.relLayout);
        RelativeLayout relativeLayout=view.findViewById(R.id.slideimg);

        //relativeLayout.setBackgroundColor(background_1[position]);

        relativeLayout.setBackgroundResource(images[position]);

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}

