package com.example.hh.view7.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hh.view7.R;

public class result extends AppCompatActivity {

    private TextView text;
    private String string;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        text=(TextView) findViewById(R.id.text1);

        Intent it2=getIntent();
        string=it2.getStringExtra("infor_result");

         text.setText(string);
    }
}
