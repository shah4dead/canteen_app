package com.example.shah_tp_canteen_mob.repo;

import com.example.shah_tp_canteen_mob.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    String BASE_URL = "http://localhost/mdad_proj/products/";

    @GET("retrieveProducts")
    Call<List<Product>> getProducts();

}
