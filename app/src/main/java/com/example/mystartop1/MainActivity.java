package com.example.mystartop1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mystartop.R;


public class MainActivity extends AppCompatActivity {
TextView textView;
boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.image);
        textView = findViewById(R.id.txtAbout);
       Button button = findViewById(R.id.next);
        Glide.with(this)
                .load("https://media.giphy.com/media/98uBZTzlXMhkk/giphy.gif")
                .into(imageView);

        /*from raw folder*/
        Glide.with(this)
                .load(R.raw.marketingstrategy)
                .into(imageView);
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.blink);
        textView.startAnimation(animation);
        button.startAnimation(animation);



     /*  new Handler().postDelayed(new Runnable() {
            @Override
           public void run() {
               startActivity(intent);
               finish();
            }
      } , 4500);*/
    }

    public void aboutUsVoid(View view) {
        View app_v = getLayoutInflater().inflate(R.layout.aboutus , null);
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setView(app_v);
        AlertDialog alertDialog = builder1.create();
        alertDialog.show();
    }
    @Override
    public void onBackPressed() {


        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "لطفا کلید بازگشت را مجددا فشار دهید", Toast.LENGTH_SHORT).show();


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);

    }


    public void nextPageVoid(View view) {
        Intent intent = new Intent(this , FirstActivity.class);
        startActivity(intent);
    }
}