package com.example.hh.view7.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.hh.view7.R;

public class result extends AppCompatActivity {

    private EditText text;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        text=(EditText)findViewById(R.id.text1);

    }
}
