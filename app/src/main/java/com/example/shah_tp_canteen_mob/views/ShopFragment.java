package com.example.shah_tp_canteen_mob.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shah_tp_canteen_mob.R;
import com.example.shah_tp_canteen_mob.adapters.ShopListAdapter;
import com.example.shah_tp_canteen_mob.databinding.FragmentShopBinding;
import com.example.shah_tp_canteen_mob.models.Product;
import com.example.shah_tp_canteen_mob.viewmodels.ShopViewModel;

import java.util.List;


public class ShopFragment extends Fragment implements ShopListAdapter.ShopInterface {

    FragmentShopBinding fragmentShopBinding;
    private ShopListAdapter shopListAdapter;
    private ShopViewModel shopViewModel;


    public ShopFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentShopBinding =FragmentShopBinding.inflate(inflater,container,false);
        return fragmentShopBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shopListAdapter= new ShopListAdapter();
        fragmentShopBinding.shopRecycleView.setAdapter(shopListAdapter);
        fragmentShopBinding.shopRecycleView.addItemDecoration(new DividerItemDecoration(requireContext(),DividerItemDecoration.HORIZONTAL));
        fragmentShopBinding.shopRecycleView.addItemDecoration(new DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL));

        //pass owner and activity
        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        shopViewModel.getProduct().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                shopListAdapter.submitList(products);
            }
        });

    }

    @Override
    public void addItem(Product product) {

    }

    @Override
    public void onItemClick(Product product) {

    }
}