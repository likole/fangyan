package com.example.hh.view7.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.hh.view7.R;

public class manage_zhu extends AppCompatActivity {

    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_zhu);

        bt1 = (Button) findViewById(R.id.manage_bt1);
        bt2 = (Button) findViewById(R.id.manage_bt2);
        bt3 = (Button) findViewById(R.id.manage_bt3);
        bt4=(Button)findViewById(R.id.manage_bt4);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(manage_zhu.this,login.class);
                startActivity(it);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(manage_zhu.this,login2.class);
                startActivity(it);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(manage_zhu.this,change_password.class);
                startActivity(it);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(manage_zhu.this,forget_password.class);
                startActivity(it);
            }
        });
    }
}
