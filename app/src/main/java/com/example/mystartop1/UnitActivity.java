package com.example.mystartop1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.example.mystartop.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class UnitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);
        ImageView imageView = findViewById(R.id.imgTitle);
        /*Animation animation = AnimationUtils.loadAnimation(this,  R.anim.fade);
        imageView.startAnimation(animation);*/
    }
}