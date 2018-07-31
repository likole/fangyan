package com.example.hh.view7.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hh.view7.R;

public class change_password extends AppCompatActivity {

    private EditText edit1;
    private EditText edit2;
    private EditText edit3;
    private Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_passord);

        edit1=(EditText)findViewById(R.id.change_ed1);
        edit2=(EditText)findViewById(R.id.change_ed2);
        edit3=(EditText)findViewById(R.id.change_ed3);
        bt=(Button)findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
