package com.example.mystartop1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mystartop.R;

import java.util.Timer;

public class SecondActivity extends AppCompatActivity {

    EditText edt;
    TextView txtTimer;
    Timer timer;
    int check = 0;
    long timerCount = 180000;
  Button btn;
    String url, code;
    RequestQueue requestQueue;
    ProgressDialog pdialog;
    SharedPreferences preferences1;
    SharedPreferences.Editor editor1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        edt = findViewById(R.id.edt);
        btn = findViewById(R.id.btn);
        txtTimer = findViewById(R.id.txt_timer);
        pdialog = new ProgressDialog(this);
        preferences1 = getSharedPreferences("pref", MODE_PRIVATE);
        editor1 = preferences1.edit();
        pdialog.setTitle("در حال ارسال کد");
        pdialog.setMessage("لطفا منتظر بمانید...");
        pdialog.setIcon(R.drawable.ic_baseline_add_alert_24);
        pdialog.setCancelable(true);
        requestQueue = Volley.newRequestQueue(this);

        if (preferences1.getString("stattus", "").equals("logggedin")) {
            startActivity(new Intent(this, ThirdActivity.class));
            finish();
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recieveData = getIntent();
                String tel = recieveData.getStringExtra("tel");
                code = edt.getText().toString().trim();

                if (check == 1) {
                    check = 0;
                    url = "https://raygansms.com/AutoSendCode.ashx?Username=mahsarz1379&Password=1273370521&Mobile=" + tel;
                    sendParameterGet();
                } else if (code.isEmpty()) {
                    Toast.makeText(SecondActivity.this, "لطفا کد را وارد نمایید", Toast.LENGTH_SHORT).show();
                } else {
                    url = "https://raygansms.com/login/CheckSendCode.ashx?Username=mahsarz1379&Password=1273370521&Mobile=" + tel + "&code=" + code;
                    sendParameterGet();
                }


            }
        });


    }

    private void sendParameterGet() {
        StringRequest request = new StringRequest(
                Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pdialog.dismiss();
                if (response.equals("true")) {
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    startActivity(intent);
                    editor1.putString("stattus", "logggedin").commit();
                    finish();


                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pdialog.dismiss();
                        Toast.makeText(SecondActivity.this, "مشکل ارتباط با سرور", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        pdialog.show();
        requestQueue.add(request);
    }



}