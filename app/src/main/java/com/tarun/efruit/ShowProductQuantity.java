package com.tarun.efruit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ShowProductQuantity extends AppCompatActivity {
    ImageView increment, decrement;
    TextView numberdisp;
    Button addtocartbtn;
    int count = 0;

    //Testing - Remove after test to implement it
    TextView productinformationprice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_product_quantity);
        increment = (ImageView) findViewById(R.id.increment);
        decrement = (ImageView) findViewById(R.id.decrement);
        numberdisp = (TextView) findViewById(R.id.numberdisp);
        addtocartbtn = (Button) findViewById(R.id.addtocartbtn);
        productinformationprice = (TextView) findViewById(R.id.productinformationprice);

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementValue();
            }

            private void incrementValue() {
                count++;
                numberdisp.setText("" + count);
            }
        });

        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count <= 0) count = 0;
                else count--;
                numberdisp.setText("" + count);

            }
        });
        addtocartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String orderValue = numberdisp.getText().toString().trim();
                String productinformationpriceSt = productinformationprice.getText().toString().trim();
                int oPrice = Integer.parseInt(productinformationpriceSt);
                int oValue = Integer.parseInt(orderValue);

                String totalValue = String.valueOf(oPrice * oValue);
                System.out.println("@@@@@@@@@@@@@@@@@@@@@"+productinformationpriceSt);
                System.out.println("@@@@@@@@@@@@@@@@@@@@@"+orderValue);
                System.out.println("@@@@@@@@@@@@@@@@@@@@@"+totalValue);
                String TotalValue = String.valueOf(totalValue);
                startActivity(new Intent(ShowProductQuantity.this, ProductDisplayLayoutActivity.class)
                        .putExtra("price", totalValue));
            }
        });


    }
}