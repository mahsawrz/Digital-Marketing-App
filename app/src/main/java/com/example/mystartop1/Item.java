package com.example.mystartop1;



public class Item {
    private  String id;
    private String name;
    private int photo;
    private String engdes;
    private int img;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Item(String id ,String name, int photo, String engdes, int img) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.engdes = engdes;
        this.img = img;


    }

    public Item() {
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
    public String getEngdes() {
        return engdes;
    }

    public void setEngdes(String engdes) {
        this.engdes = engdes;
    }

}
