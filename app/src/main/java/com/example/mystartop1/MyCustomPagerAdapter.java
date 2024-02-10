package com.example.mystartop1;


import android.content.Context;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.TextView;


import androidx.viewpager.widget.PagerAdapter;

import com.example.mystartop.R;


public class MyCustomPagerAdapter extends PagerAdapter {

    Context context;
    int images[];
    LayoutInflater layoutInflater;
 ImageView imageView;


    public MyCustomPagerAdapter(Context context, int images[]) {
        this.context = context;
        this.images = images;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public MyCustomPagerAdapter() {
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.custom_layout, container, false);

        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        TextView textView =(TextView) itemView.findViewById(R.id.tx);
        imageView.setImageResource(images[position]);


        container.addView(itemView);

        //listening to image click
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "you clicked image " + (position + 1), Toast.LENGTH_LONG).show();
                if (position == 0){
                    context.startActivity(new Intent(context,UnitActivity.class));
                }
                if (position == 1){
                    context.startActivity(new Intent(context, optActivity.class));
                }
                if (position == 2){
                    context.startActivity(new Intent(context, seoActivity.class));
                }
                if (position == 3){
                    context.startActivity(new Intent(context, webaActivity.class));
                }

            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
