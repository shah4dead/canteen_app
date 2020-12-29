package com.example.shah_tp_canteen_mob.repo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.shah_tp_canteen_mob.models.Product;
import com.example.shah_tp_canteen_mob.views.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShopRepo {


    private MutableLiveData<List<Product>> mutableProductList;

    //we will call this method to get the data
    public LiveData<List<Product>>getProducts(){

        if(mutableProductList==null){
            mutableProductList = new MutableLiveData<>();
            //we will load it asynchronously from server in this method
            loadProducts();
            //List<Product> productList= new ArrayList<>();
        }

        return mutableProductList;


        }
    private void loadProducts(){
        List<Product> productList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);
        Call<List<Product>> call = api.getProducts();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, retrofit2.Response<List<Product>> response) {
                //finally we are setting the list to our MutableLiveData
                mutableProductList.setValue(response.body());
            }

            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });








     //   List<Product> productList = new ArrayList<>();
     //   productList.add(new Product(1,"nasi lemask",3.00,true,"https://i.imgur.com/FInj2ns.jpg"));



      //  mutableProductList.setValue(productList);
    }



}
