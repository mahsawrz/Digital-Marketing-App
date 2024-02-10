package com.example.mystartop1;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mystartop.R;
import com.example.mystartop1.amazon.cheraamazon;
import com.example.mystartop1.amazon.forosh;
import com.example.mystartop1.amazon.haml;
import com.example.mystartop1.amazon.rotbe;
import com.example.mystartop1.amazon.shive;
import com.example.mystartop1.amazon.sood;
import com.example.mystartop1.digital.google;
import com.example.mystartop1.digital.link;
import com.example.mystartop1.digital.overview;
import com.example.mystartop1.digital.pin;
import com.example.mystartop1.digital.social;
import com.example.mystartop1.email.block;
import com.example.mystartop1.email.contents;
import com.example.mystartop1.email.etela;
import com.example.mystartop1.email.harz;
import com.example.mystartop1.email.list;
import com.example.mystartop1.facebook.fan;
import com.example.mystartop1.facebook.page;
import com.example.mystartop1.facebook.post;
import com.example.mystartop1.facebook.profile;
import com.example.mystartop1.facebook.target;
import com.example.mystartop1.facebook.trick;
import com.example.mystartop1.google.binesh;
import com.example.mystartop1.google.bussines;
import com.example.mystartop1.google.community;
import com.example.mystartop1.google.liink;
import com.example.mystartop1.google.opage;
import com.example.mystartop1.insta.install;
import com.example.mystartop1.insta.send;
import com.example.mystartop1.insta.strategy;
import com.example.mystartop1.insta.tmpActivity;
import com.example.mystartop1.insta.tool;
import com.example.mystartop1.mobile.app;
import com.example.mystartop1.mobile.dark;
import com.example.mystartop1.mobile.fanavari;
import com.example.mystartop1.mobile.mstrategy;
import com.example.mystartop1.mobile.shabake;
import com.example.mystartop1.mohtava.content;
import com.example.mystartop1.mohtava.customer;
import com.example.mystartop1.mohtava.email;
import com.example.mystartop1.mohtava.magazine;
import com.example.mystartop1.mohtava.mobile;
import com.example.mystartop1.mohtava.web;
import com.example.mystartop1.resane.blog;
import com.example.mystartop1.resane.image;
import com.example.mystartop1.resane.introduction;
import com.example.mystartop1.resane.society;
import com.example.mystartop1.resane.video;
import com.example.mystartop1.twitter.followers;
import com.example.mystartop1.twitter.hashtag;
import com.example.mystartop1.twitter.shohrat;
import com.example.mystartop1.twitter.tabdil;
import com.example.mystartop1.twitter.usefull;
import com.example.mystartop1.youtube.creative;
import com.example.mystartop1.youtube.daramad;
import com.example.mystartop1.youtube.img;
import com.example.mystartop1.youtube.safety;
import com.example.mystartop1.youtube.tarfand;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    List<Item> itemList;
    Context mContext;
    ListView listView;
    String item;
    Intent intent;
    ImageView Imstar;



    public ItemAdapter(List<Item> itemList, Context mContext) {
        this.itemList = itemList;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View aView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(aView);

    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(MyViewHolder holder,int position) {

        Item aItem = itemList.get(position);
        intent = ((Activity) mContext).getIntent();

        holder.aAvatar.setImageResource(aItem.getPhoto());
        holder.aName.setText(aItem.getName());
        holder.engDec.setText(aItem.getEngdes());
        holder.img.setImageResource(aItem.getImg());







       holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             switch (position){
                 case 0:{
                     View app_v = View.inflate(mContext,R.layout.one,null);
                     AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                     builder1.setView(app_v);
                     AlertDialog alertDialog = builder1.create();
                     alertDialog.show();
                     listView = app_v.findViewById(R.id.lst1);
                     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                         @Override
                         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                              item = listView.getItemAtPosition(i).toString().trim();
                              if (item.equals("چرا آمازون؟")){
                                  mContext.startActivity(new Intent(mContext , cheraamazon.class));
                              }
                             if (item.equals("چه چیزی بفروشیم؟")){
                                 mContext.startActivity(new Intent(mContext , forosh.class));
                             }
                             if (item.equals("روش های حمل و نقل")){
                                 mContext.startActivity(new Intent(mContext , haml.class));
                             }
                             if (item.equals("بالاترین سود را دریافت کنید")){
                                 mContext.startActivity(new Intent(mContext , sood.class));
                             }
                             if (item.equals("رتبه آمازون شما")){
                                 mContext.startActivity(new Intent(mContext , rotbe.class));
                             }
                             if (item.equals("بهترین شیوه ها")){
                                 mContext.startActivity(new Intent(mContext , shive.class));
                             }
                         }
                     });
                     break;
                 }
                 case 1:{
                     View app_v = View.inflate(mContext,R.layout.two,null);
                     AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                     builder1.setView(app_v);
                     AlertDialog alertDialog = builder1.create();
                     alertDialog.show();
                     listView = app_v.findViewById(R.id.lst2);
                     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                         @Override
                         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                             item = listView.getItemAtPosition(i).toString().trim();
                             if (item.equals("مشتری هدف")){
                                 mContext.startActivity(new Intent(mContext , customer.class));
                             }
                             if (item.equals("ایجاد محتوا")){
                                 mContext.startActivity(new Intent(mContext , content.class));
                             }
                             if (item.equals("انواع محتوا : ایمیل های چرخه حیات")){
                                 mContext.startActivity(new Intent(mContext , email.class));
                             }
                             if (item.equals("انواع محتوا : مجلات دیجیتال")){
                                 mContext.startActivity(new Intent(mContext , magazine.class));
                             }
                             if (item.equals("انواع محتوا : برنامه های موبایل")){
                                 mContext.startActivity(new Intent(mContext , mobile.class));
                             }
                             if (item.equals("انواع محتوا : برنامه های وب")){
                                 mContext.startActivity(new Intent(mContext , web.class));
                             }
                         }
                     });
                     break;
                 }
                 case 2:{
                     View app_v = View.inflate(mContext,R.layout.three,null);
                     AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                     builder1.setView(app_v);
                     AlertDialog alertDialog = builder1.create();
                     alertDialog.show();
                     listView = app_v.findViewById(R.id.lst3);
                     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                         @Override
                         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                             item = listView.getItemAtPosition(i).toString().trim();
                             if (item.equals("بررسی اجمالی")){
                                 mContext.startActivity(new Intent(mContext , overview.class));
                             }
                             if (item.equals("رسانه های اجتماعی")){
                                 mContext.startActivity(new Intent(mContext , social.class));
                             }
                             if (item.equals("Pinterest")){
                                 mContext.startActivity(new Intent(mContext , pin.class));
                             }
                             if (item.equals("Linkedin")){
                                 mContext.startActivity(new Intent(mContext , link.class));
                             }
                             if (item.equals("Google Adwords")){
                                 mContext.startActivity(new Intent(mContext , google.class));
                             }
                         }
                     });
                     break;
                 }
                 case 3:{
                     View app_v = View.inflate(mContext,R.layout.four,null);
                     AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                     builder1.setView(app_v);
                     AlertDialog alertDialog = builder1.create();
                     alertDialog.show();
                     listView = app_v.findViewById(R.id.lst4);
                     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                         @Override
                         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                             item = listView.getItemAtPosition(i).toString().trim();
                             if (item.equals("لیست پستی")){
                                 mContext.startActivity(new Intent(mContext , list.class));
                             }
                             if (item.equals("اطلاعیه ها")){
                                 mContext.startActivity(new Intent(mContext , etela.class));
                             }
                             if (item.equals("محتوا")){
                                 mContext.startActivity(new Intent(mContext , contents.class));
                             }
                             if (item.equals("از قرار گرفتن در لیست سیاه خودداری کنید")){
                                 mContext.startActivity(new Intent(mContext , harz.class));
                             }
                             if (item.equals("UPS")){
                                 mContext.startActivity(new Intent(mContext , block.class));
                             }
                         }
                     });
                     break;
                 }
                 case 4:{
                     View app_v = View.inflate(mContext,R.layout.five,null);
                     AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                     builder1.setView(app_v);
                     AlertDialog alertDialog = builder1.create();
                     alertDialog.show();
                     listView = app_v.findViewById(R.id.lst5);
                     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                         @Override
                         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                             item = listView.getItemAtPosition(i).toString().trim();
                             if (item.equals("راه اندازی صفحه پروفایل")){
                                 mContext.startActivity(new Intent(mContext , profile.class));
                             }
                             if (item.equals("برندسازی شخصی")){
                                 mContext.startActivity(new Intent(mContext , page.class));
                             }
                             if (item.equals("شناسایی اهداف")){
                                 mContext.startActivity(new Intent(mContext , target.class));
                             }
                             if (item.equals("پست های با کیفیت")){
                                 mContext.startActivity(new Intent(mContext , post.class));
                             }
                             if (item.equals("ایجاد طرفدار")){
                                 mContext.startActivity(new Intent(mContext , fan.class));
                             }
                             if (item.equals("ترفندها")){
                                 mContext.startActivity(new Intent(mContext , trick.class));
                             }
                         }
                     });
                     break;
                 }
                 case 5:{
                     View app_v = View.inflate(mContext,R.layout.six,null);
                     AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                     builder1.setView(app_v);
                     AlertDialog alertDialog = builder1.create();
                     alertDialog.show();
                     listView = app_v.findViewById(R.id.lst6);
                     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                         @Override
                         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                             item = listView.getItemAtPosition(i).toString().trim();
                             if (item.equals("تنظیم صفحه کسب و کار")){
                                 mContext.startActivity(new Intent(mContext , bussines.class));
                             }
                             if (item.equals("جوامع")){
                                 mContext.startActivity(new Intent(mContext , community.class));
                             }
                             if (item.equals("تعامل کاربر را تقویت کنید")){
                                 mContext.startActivity(new Intent(mContext , binesh.class));
                             }
                             if (item.equals("بهینه سازی یک صفحه")){
                                 mContext.startActivity(new Intent(mContext , opage.class));
                             }
                             if (item.equals("اتصال با یوتیوب")){
                                 mContext.startActivity(new Intent(mContext , liink.class));
                             }
                         }
                     });
                     break;
                 }
                 case 6:{
                     View app_v = View.inflate(mContext,R.layout.seven,null);
                     AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                     builder1.setView(app_v);
                     AlertDialog alertDialog = builder1.create();
                     alertDialog.show();
                     listView = app_v.findViewById(R.id.lst7);
                     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                         @Override
                         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                             item = listView.getItemAtPosition(i).toString().trim();
                             if (item.equals("استراتژی کسب و کار")){
                                 mContext.startActivity(new Intent(mContext , strategy.class));
                             }
                             if (item.equals("نصب و ثبت نام")){
                                 mContext.startActivity(new Intent(mContext , install.class));
                             }
                             if (item.equals("ارسال و تعامل")){
                                 mContext.startActivity(new Intent(mContext , send.class));
                             }
                             if (item.equals("بررسی فعالیت")){
                                 mContext.startActivity(new Intent(mContext , tmpActivity.class));
                             }
                             if (item.equals("ابزارها و برنامه ها")){
                                 mContext.startActivity(new Intent(mContext , tool.class));
                             }
                         }
                     });
                     break;
                 }
                 case 7:{
                     View app_v = View.inflate(mContext,R.layout.eight,null);
                     AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                     builder1.setView(app_v);
                     AlertDialog alertDialog = builder1.create();
                     alertDialog.show();
                     listView = app_v.findViewById(R.id.lst8);
                     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                         @Override
                         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                             item = listView.getItemAtPosition(i).toString().trim();
                             if (item.equals("فناوری موبایل و دسترسی")){
                                 mContext.startActivity(new Intent(mContext , fanavari.class));
                             }
                             if (item.equals("استراتژی های بازاریابی موبایل")){
                                 mContext.startActivity(new Intent(mContext , mstrategy.class));
                             }
                             if (item.equals("استراتژی های بازاریابی اپلیکیشن های موبایل")){
                                 mContext.startActivity(new Intent(mContext , app.class));
                             }
                             if (item.equals("بازاریابی شبکه های اجتماعی موبایلی")){
                                 mContext.startActivity(new Intent(mContext , shabake.class));
                             }
                             if (item.equals("درک کاربران موبایل")){
                                 mContext.startActivity(new Intent(mContext , dark.class));
                             }
                         }
                     });
                     break;
                 }
                 case 8:{
                     View app_v = View.inflate(mContext,R.layout.nine,null);
                     AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                     builder1.setView(app_v);
                     AlertDialog alertDialog = builder1.create();
                     alertDialog.show();
                     listView = app_v.findViewById(R.id.lst9);
                     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                         @Override
                         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                             item = listView.getItemAtPosition(i).toString().trim();
                             if (item.equals("معرفی")){
                                 mContext.startActivity(new Intent(mContext , introduction.class));
                             }
                             if (item.equals("بازاریابی ویدئویی")){
                                 mContext.startActivity(new Intent(mContext , video.class));
                             }
                             if (item.equals("نشانه گذاری اجتماعی")){
                                 mContext.startActivity(new Intent(mContext , society.class));
                             }
                             if (item.equals("بهینه سازی تصویر")){
                                 mContext.startActivity(new Intent(mContext , image.class));
                             }
                             if (item.equals("وبلاگ نویسی")){
                                 mContext.startActivity(new Intent(mContext , blog.class));
                             }
                         }
                     });
                     break;
                 }
                 case 9:{
                     View app_v = View.inflate(mContext,R.layout.ten,null);
                     AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                     builder1.setView(app_v);
                     AlertDialog alertDialog = builder1.create();
                     alertDialog.show();
                     listView = app_v.findViewById(R.id.lst10);
                     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                         @Override
                         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                             item = listView.getItemAtPosition(i).toString().trim();
                             if (item.equals("دنبال کننده ها")){
                                 mContext.startActivity(new Intent(mContext , followers.class));
                             }
                             if (item.equals("هشتگ ها")){
                                 mContext.startActivity(new Intent(mContext , hashtag.class));
                             }
                             if (item.equals("ویژگی های مفید")){
                                 mContext.startActivity(new Intent(mContext , usefull.class));
                             }
                             if (item.equals("مدیریت شهرت")){
                                 mContext.startActivity(new Intent(mContext , shohrat.class));
                             }
                             if (item.equals("مدیریت تبدیل ها")){
                                 mContext.startActivity(new Intent(mContext , tabdil.class));
                             }
                         }
                     });
                     break;
                 }
                 case 10:{
                     View app_v = View.inflate(mContext,R.layout.eleven,null);
                     AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                     builder1.setView(app_v);
                     AlertDialog alertDialog = builder1.create();
                     alertDialog.show();
                     listView = app_v.findViewById(R.id.lst11);
                     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                         @Override
                         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                             item = listView.getItemAtPosition(i).toString().trim();
                             if (item.equals("ویدیوی خلاقانه ایجاد کنید")){
                                 mContext.startActivity(new Intent(mContext , creative.class));
                             }
                             if (item.equals("ایجاد ریز عکسها")){
                                 mContext.startActivity(new Intent(mContext , img.class));
                             }
                             if (item.equals("از ویدیوی خود کسب درآمد کنید")){
                                 mContext.startActivity(new Intent(mContext , daramad.class));
                             }  if (item.equals("ترفندهای بازاریابی")){
                                 mContext.startActivity(new Intent(mContext , tarfand.class));
                             }
                             if (item.equals("تنظیمات ایمنی")){
                                 mContext.startActivity(new Intent(mContext , safety.class));
                             }

                         }
                     });
                     break;
                 }

             }
            }
        });


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView aAvatar;
        public TextView aName;
        public TextView engDec;
        public ImageView img;





        public MyViewHolder(View itemView) {
            super(itemView);

            aAvatar = itemView.findViewById(R.id.img_avatar);
            aName = itemView.findViewById(R.id.txt_name);
            engDec = itemView.findViewById(R.id.engDec);
            img = itemView.findViewById(R.id.img);




        }


    }



    }




    


