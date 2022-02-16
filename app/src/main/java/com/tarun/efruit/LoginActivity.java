package com.tarun.efruit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    TextView newaccount;
    Button loginBtn;
    ProgressDialog progressDialog;
    TextInputLayout loginPhone,loginPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        newaccount = (TextView)findViewById(R.id.newaccount);
        loginBtn = (Button)findViewById(R.id.loginbtn);
        progressDialog = new ProgressDialog(this);
        loginPhone = (TextInputLayout)findViewById(R.id.loginPhone);
        loginPwd = (TextInputLayout)findViewById(R.id.loginPwd);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = loginPhone.getEditText().getText().toString().trim();
                String password = loginPwd.getEditText().getText().toString().trim();
                progressDialog.setTitle("User Login");
                progressDialog.setMessage("Please wait! We are checking your credentials");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
                if (phone.equals(null) || password.equals(null)){
                    loginPhone.setError("Please check your phone number");
                    loginPhone.requestFocus();
                    loginPwd.setError("Please check your password");
                    loginPwd.requestFocus();
                }else if (phone.equals("0000000000") && password.equals("123456")){
                    progressDialog.cancel();
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    intent.putExtra("usernumber","0000000000");
                    startActivity(intent);
                    finish();
                }   else if (phone.equals("#2233*") && password.equals("123456#")){
                    Dialog popup; //To create popup when user clicks on the Videos/Web Button at Place 12
                    popup = new Dialog(LoginActivity.this);//Initiate the popup dialog box
                    popup.setContentView(R.layout.customlinkpopup);
                    progressDialog.cancel();

                    popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    TextView closeBtn;
                    Button btn4video,btn4web;
                    btn4video = popup.findViewById(R.id.veges);
                    btn4web = popup.findViewById(R.id.fruits);
                    closeBtn = popup.findViewById(R.id.closebtn);
                    closeBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            popup.cancel();
                        }
                    });
                    btn4video.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(LoginActivity.this,AdminLoginActivity.class);
                            i.putExtra("result","admin");

                            startActivity(i);
                        }
                    });

                    btn4web.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(LoginActivity.this,AdminLoginActivity.class);
                            i.putExtra("result","delivery");
                            startActivity(i);
                        }
                    });
                    popup.show();



                }


            }
        });

        newaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });

    }
}