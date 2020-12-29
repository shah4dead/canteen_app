package com.example.shah_tp_canteen_mob.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shah_tp_canteen_mob.databinding.ShopRowBinding;
import com.example.shah_tp_canteen_mob.models.Product;

import java.util.List;

public class ShopListAdapter extends ListAdapter<Product,ShopListAdapter.ShopViewHolder> {



    public ShopListAdapter() {
        super(Product.itemCallback);
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ShopRowBinding shopRowBinding = ShopRowBinding.inflate(layoutInflater,parent,false);

        return new ShopViewHolder(shopRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
        Product product = getItem(position);

        holder.shopRowBinding.setProduct(product);


    }

    class ShopViewHolder extends RecyclerView.ViewHolder{
        ShopRowBinding shopRowBinding;


        public ShopViewHolder(ShopRowBinding binding) {
            super(binding.getRoot());
            this.shopRowBinding=binding;
        }
    }

    public interface ShopInterface{
        void addItem(Product product);
        void onItemClick(Product product);
    }

}
