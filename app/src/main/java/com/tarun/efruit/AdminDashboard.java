package com.tarun.efruit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AdminDashboard extends AppCompatActivity {
    CardView addProduct,getOrders,deliveryStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        addProduct = (CardView)findViewById(R.id.addproduct);
        getOrders = (CardView)findViewById(R.id.getorders);
        deliveryStatus = (CardView)findViewById(R.id.deliverystatus);

        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog popupCategory;
                popupCategory = new Dialog(AdminDashboard.this);
                popupCategory.setContentView(R.layout.customlinkpopupselectcategory);
                Button veges = popupCategory.findViewById(R.id.veges);
                Button fruits = popupCategory.findViewById(R.id.fruits);
                TextView closebtn = popupCategory.findViewById(R.id.closebtn);

                closebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(AdminDashboard.this, "Category Popup Closes", Toast.LENGTH_SHORT).show();
                        popupCategory.cancel();
                    }
                });

                veges.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(AdminDashboard.this, "Adding Vegetables", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AdminDashboard.this,Addproduct.class);
                        intent.putExtra("category","Vegetables");
                        startActivity(intent);
                    }
                });

                fruits.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(AdminDashboard.this, "Adding Fruits", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AdminDashboard.this,Addproduct.class);
                        intent.putExtra("category","Fruits");
                        startActivity(intent);
                    }
                });

                popupCategory.show();



/*                Intent intent = new Intent(AdminDashboard.this,Addproduct.class);
                startActivity(intent);*/
            }
        });

        getOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminDashboard.this,Getorders.class);
                startActivity(intent);
            }
        });

        deliveryStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminDashboard.this,DeliveryStatus.class);
                startActivity(intent);
            }
        });




    }
}