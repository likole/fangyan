package com.example.hh.view7.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SyncStatusObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hh.view7.R;
import com.example.hh.view7.util.OkHttpUtils;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Response;

public class login extends AppCompatActivity{

    private Button bt1;
    private Button bt2;
    private Button bt3;
    private EditText name;
    private EditText pass;
    private String username;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        bt1=(Button)findViewById(R.id.zhuce);
        bt2=(Button)findViewById(R.id.wangji);
        bt3=findViewById(R.id.button3);
        name=(EditText)findViewById(R.id.editText2) ;
        pass=(EditText)findViewById(R.id.editText);
        username=name.getText().toString();
        password=pass.getText().toString();

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(login.this,login2.class);
                startActivity(it);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(login.this,forget_password.class);
                startActivity(it);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Map<String,String> map=new HashMap<>();
                        map.put("username",username);
                        map.put("password",password);
                        Response response= OkHttpUtils.doPost("/log_in.php",map);
                        try {
                            System.out.println(response.body().string());
                        } catch (Exception e) {
                            System.out.println("s");
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }
}
