package com.example.mystartop1;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mystartop.R;


public class FirstActivity extends AppCompatActivity {
    EditText edt;
    ImageView btn;
    String url, tel;
    RequestQueue requestQueue;
    CheckBox ersal;
    ProgressDialog pdialog;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ersal = findViewById(R.id.checkBox);
        edt = findViewById(R.id.edPhoneNum);
        btn = findViewById(R.id.btnErsal);
        pdialog = new ProgressDialog(this);
        preferences = getSharedPreferences("pref" , MODE_PRIVATE);
        editor = preferences.edit();
        pdialog.setTitle("در حال ارسال کد");
        pdialog.setMessage("لطفا منتظر بمانید...");
        pdialog.setIcon(R.drawable.ic_baseline_add_alert_24);
        pdialog.setCancelable(true);

        if (preferences.getString("status" , "").equals("loggedin")){
            startActivity(new Intent(this , SecondActivity.class));
            finish();
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tel = edt.getText().toString().trim();
                if (!tel.isEmpty()) {
                    if (tel.length() == 11) {
                        if (tel.startsWith("09")) {
                            if (ersal.isChecked()) {
                                url = "https://raygansms.com/AutoSendCode.ashx?Username=mahsarz1379&Password=1273370521&Mobile=" + tel;
                                sendParameterGet();
                            }else {
                                Toast.makeText(FirstActivity.this, "لطفا با قوانین موافقت کنید.", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(FirstActivity.this, "لطفا شماره تلفن خود را صحیح وارد نمایید!", Toast.LENGTH_SHORT).show();
                        }

                        }else {
                        Toast.makeText(FirstActivity.this, "لطفا تعداد ارقام شماره تلفن خود را صحیح وارد نمایید!", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(FirstActivity.this, "لطفا شماره همراه خود را وارد نمایید.", Toast.LENGTH_SHORT).show();
                }




                }
        });




        requestQueue = Volley.newRequestQueue(this);
    }

    public  void sendParameterGet() {
        StringRequest request = new StringRequest(
                Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pdialog.dismiss();
                int result = Integer.parseInt(response);
                if (result == 8) {
                    Toast.makeText(FirstActivity.this, "مشکل وب سرویس", Toast.LENGTH_LONG).show();
                } else if (result > 2000) {
                    Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                    intent.putExtra("tel", tel);
                    startActivity(intent);
                    editor.putString("status" , "loggedin").commit();
                    finish();



                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pdialog.dismiss();
                        Toast.makeText(FirstActivity.this, "مشکل ارتباط با سرور", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        pdialog.show();
        requestQueue.add(request);
    }


}