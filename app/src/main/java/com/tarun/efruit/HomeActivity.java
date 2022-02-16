package com.tarun.efruit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    CardView orderVegetables, orderFruits;
    TextView logOutUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        String userNumber = intent.getStringExtra("usernumber");
        Toast.makeText(this, "Welcome :" + userNumber, Toast.LENGTH_SHORT).show();

        orderVegetables = (CardView) findViewById(R.id.orderVegetables);
        orderFruits = (CardView) findViewById(R.id.orderFruits);
        logOutUser = (TextView) findViewById(R.id.logOutUser);


        orderVegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, Addproduct.class)
                .putExtra("veges","category"));
                Toast.makeText(HomeActivity.this, "Working", Toast.LENGTH_SHORT).show();
            }
        });

        orderFruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Working", Toast.LENGTH_SHORT).show();
            }
        });
        logOutUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}