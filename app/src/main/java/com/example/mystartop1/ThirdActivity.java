package com.example.mystartop1;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;
import android.os.Handler;

import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mystartop.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class ThirdActivity extends AppCompatActivity {
    ViewPager viewPager;
    int currentPage = 0, check = 0;
    RecyclerView myRecycler;
    List<Item> mItem = new ArrayList<>();
    ItemAdapter mAdapter;
    Timer timer;
    final long DELAY_MS = 0;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 4000;
    int images[] = {R.drawable.bigstock, R.drawable.conversion, R.drawable.shutterstock, R.drawable.big};
    String[] strings = {"آموزش تست a/b ", "بهینه سازی نرخ تبدیل",  "تکنیک های سئو", "تجزیه و تحلیل وب"};
    TextView txt, txtEng;
    ImageView img;
    Spinner spinner;
    MyCustomPagerAdapter myCustomPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        // getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        myCustomPagerAdapter = new MyCustomPagerAdapter(ThirdActivity.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        myRecycler = findViewById(R.id.recycler_view);
        txt = findViewById(R.id.tx);
        txtEng = findViewById(R.id.engDec);
        tabLayout.setupWithViewPager(viewPager, true);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 4) {
                    currentPage = 0;
                }
                txt.setText(strings[currentPage]);
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled

            @Override
            public void run() {
                handler.post(Update);
            }

        }, DELAY_MS, PERIOD_MS);
        mAdapter = new ItemAdapter(mItem, this);



        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //RecyclerView.LayoutManager gLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, false);
        myRecycler.setLayoutManager(mLayoutManager);

        RecyclerView.ItemDecoration iDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        myRecycler.addItemDecoration(iDecoration);

        myRecycler.setItemAnimator(new DefaultItemAnimator());

        myRecycler.setHasFixedSize(true);

        myRecycler.setAdapter(mAdapter);

        setData();


    }


    private void setData() {
        mItem.add(new Item("1","بازار آمازون", R.drawable.am, "Amazon Marketplace",R.drawable.matlab));
        mItem.add(new Item("2","بازاریابی محتوا", R.drawable.cv, "Content Marketing",R.drawable.matlab));
        mItem.add(new Item("3","بازاریابی دیجیتال", R.drawable.d, "Digital Marketing",R.drawable.matlab));
        mItem.add(new Item("4","بازاریابی ایمیل", R.drawable.em, "Email Marketing",R.drawable.matlab));
        mItem.add(new Item("5","بازاریابی فیس بوک", R.drawable.fs, "Facebook Marketing",R.drawable.matlab));
        mItem.add(new Item("6","بازاریابی گوگل پلاس", R.drawable.go, "Google Plus Marketing",R.drawable.matlab));
        mItem.add(new Item("7","بازاریابی اینستاگرام", R.drawable.ii, "Instagram Marketing",R.drawable.matlab));
        mItem.add(new Item("8","بازاریابی موبایل", R.drawable.mo, "Mobile Marketing",R.drawable.matlab));
        mItem.add(new Item("9","بازاریابی رسانه های اجتماعی", R.drawable.sd, "Social Media Marketing",R.drawable.matlab));
        mItem.add(new Item("10","بازاریابی توییتر", R.drawable.tt, "Twitter Marketing",R.drawable.matlab));
        mItem.add(new Item("11","بازاریابی یوتیوب", R.drawable.yo, "YouTube Marketing",R.drawable.matlab));

        mAdapter.notifyDataSetChanged();
    }


}






