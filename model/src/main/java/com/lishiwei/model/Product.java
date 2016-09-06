package com.lishiwei.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lishiwei on 16/6/13.
 */
public class Product implements Parcelable {
    String imageUrl;
    String artist;
    String title;
    String material;
    String technique;

    public Product(String imageUrl, String artist, String title, String material, String technique, String size) {
        this.imageUrl = imageUrl;
        this.artist = artist;
        this.title = title;
        this.material = material;
        this.technique = technique;
        this.size = size;
    }

    public String getSize() {

        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    String size;

    @Override
    public String toString() {
        return "Product{" +
                "imageUrl='" + imageUrl + '\'' +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", material='" + material + '\'' +
                ", technique='" + technique + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    public Product(String imageUrl, String artist, String title) {
        this.imageUrl = imageUrl;
        this.artist = artist;
        this.title = title;
    }

    public String getImageUrl() {

        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getArtist() {

        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageUrl);
        dest.writeString(this.artist);
        dest.writeString(this.title);
        dest.writeString(this.material);
        dest.writeString(this.technique);
        dest.writeString(this.size);
    }

    protected Product(Parcel in) {
        this.imageUrl = in.readString();
        this.artist = in.readString();
        this.title = in.readString();
        this.material = in.readString();
        this.technique = in.readString();
        this.size = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
