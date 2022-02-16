package com.tarun.efruit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputLayout;

public class AdminLoginActivity extends AppCompatActivity {
    LottieAnimationView deliveryAnim,adminAnim;
    TextView loghead;
    TextInputLayout loginCredentials,password;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        Intent intent = getIntent();
        String result = intent.getStringExtra("result");

        deliveryAnim = (LottieAnimationView)findViewById(R.id.deliveryanim);
        deliveryAnim.setVisibility(View.INVISIBLE);
        adminAnim = (LottieAnimationView)findViewById(R.id.adminanim);
        adminAnim.setVisibility(View.INVISIBLE);
        loghead = (TextView)findViewById(R.id.loghead);
        loginCredentials = (TextInputLayout)findViewById(R.id.login);
        password = (TextInputLayout)findViewById(R.id.password);
        loginBtn = (Button)findViewById(R.id.loginbtn);

        if (result.equals("admin")){
            Toast.makeText(this, "Admin Login", Toast.LENGTH_SHORT).show();
            adminAnim.setVisibility(View.VISIBLE);
            loghead.setText("Admin Login");

        }else if (result.equals("delivery")){
            Toast.makeText(this, "Delivery Partner Login", Toast.LENGTH_SHORT).show();
            deliveryAnim.setVisibility(View.VISIBLE);
            loghead.setText("Delivery Login");
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.equals("admin")){
                String loginAdmin = loginCredentials.getEditText().getText().toString().trim();
                String pwdAdmin = password.getEditText().getText().toString().trim();
                if (loginAdmin.equals("225588") && pwdAdmin.equals("123456")){
                    Intent adminIntent = new Intent(AdminLoginActivity.this,AdminDashboard.class);
                    startActivity(adminIntent);
                    finish();
                }else if (loginAdmin.equals("") || pwdAdmin.equals("")){
                    loginCredentials.setError("Credentials must not be empty");
                    loginCredentials.requestFocus();
                    password.setError("Credentials must not be empty");
                    password.requestFocus();
                }else{
                    Toast.makeText(AdminLoginActivity.this, "Wrong Password! Access Denied.", Toast.LENGTH_SHORT).show();
                }
            }else if (result.equals("delivery")){
                    String loginDelivery = loginCredentials.getEditText().getText().toString().trim();
                    String pwdDelivery = password.getEditText().getText().toString().trim();
                    if (loginDelivery.equals("01230") && pwdDelivery.equals("123456")){
                        Intent adminIntent = new Intent(AdminLoginActivity.this,DeliveryDashboard.class);
                        startActivity(adminIntent);
                        finish();
                    }else if (loginDelivery.equals("") || pwdDelivery.equals("")){
                        loginCredentials.setError("Credentials must not be empty");
                        loginCredentials.requestFocus();
                        password.setError("Credentials must not be empty");
                        password.requestFocus();
                    }else{
                        Toast.makeText(AdminLoginActivity.this, "Wrong Password! Access Denied.", Toast.LENGTH_SHORT).show();
                    }


                }

            }
        });

    }
}