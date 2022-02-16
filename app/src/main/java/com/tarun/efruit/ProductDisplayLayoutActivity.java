package com.tarun.efruit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.tarun.efruit.Adapter.ProductAdapter;
import com.tarun.efruit.Models.ProductModel;

import java.util.ArrayList;

public class ProductDisplayLayoutActivity extends AppCompatActivity {
    RecyclerView products_rcv;
    ProductAdapter productAdapter;
    ArrayList<ProductModel> productlist;
    String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_display_layout);
        products_rcv = findViewById(R.id.displayProducts_rcv);
        price = getIntent().getStringExtra("price");
        System.out.println("@@@@@@@@@@@@@@@#IL:$$@@@@@@@@@@"+price);
        productlist = new ArrayList<>();
        productlist.add(new ProductModel("R.drawable.apple", "apple", "1", "kg", price));
        productAdapter = new ProductAdapter(getApplicationContext(), productlist);
        products_rcv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        products_rcv.setAdapter(productAdapter);
    }
}