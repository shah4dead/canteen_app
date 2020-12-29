package com.example.shah_tp_canteen_mob.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.example.shah_tp_canteen_mob.models.Product;
import com.example.shah_tp_canteen_mob.repo.ShopRepo;

import java.util.List;

public class ShopViewModel extends ViewModel {

    ShopRepo shopRepo = new ShopRepo();

    public LiveData<List<Product>> getProduct(){
        return shopRepo.getProducts();

    }


}
