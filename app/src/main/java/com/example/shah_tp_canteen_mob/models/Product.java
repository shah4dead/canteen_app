package com.example.shah_tp_canteen_mob.models;

import android.media.Image;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.bumptech.glide.Glide;



public class Product {
    private int pid;
    private String pname;
    private double price;
    private boolean isAvailable;
    private String imageURL;

    public Product(int pid, String pname, double price, boolean isAvailable, String imageURL) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.isAvailable = isAvailable;
        this.imageURL = imageURL;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.getPrice(), getPrice()) == 0 &&
                isAvailable() == product.isAvailable() &&
                getPid()==(product.getPid()) &&
                getPname().equals(product.getPname()) &&
                getImageURL().equals(product.getImageURL());
    }



    public static DiffUtil.ItemCallback<Product> itemCallback = new DiffUtil.ItemCallback<Product>() {
        @Override
        public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem.getPid()==(newItem.getPid());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem.equals(newItem);
        }
    };
    @BindingAdapter("android:productImage")
    public static  void loadImage(ImageView imageView, String imageURL ){
        Glide.with(imageView)
                .load(imageURL)
                .fitCenter()
                .into(imageView);



    }


}
