package com.example.hh.view7.activity;

import android.os.Bundle;
import android.renderscript.ScriptC;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hh.view7.R;
import com.example.hh.view7.util.OkHttpUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Response;

public class login2 extends AppCompatActivity {

    private EditText editText5;
    private EditText editText7;
    private EditText editText8;
    private EditText editText9;
    private EditText editText10;
    private Button bt;
    private String username;
    private String password1;
    private String password2;
    private String school;
    private String birthday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login2);

        editText5=(EditText)findViewById(R.id.editText5);
        editText7=(EditText)findViewById(R.id.editText7);
        editText8=(EditText)findViewById(R.id.editText8);
        editText9=(EditText)findViewById(R.id.editText9);
        editText10=(EditText)findViewById(R.id.editText10);
        bt=(Button)findViewById(R.id.button);

        username=editText5.getText().toString();
        password1=editText7.getText().toString();
        password2=editText8.getText().toString();
        school=editText9.getText().toString();
        birthday=editText10.getText().toString();

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Map<String,String> map=new HashMap<>();
                        map.put("username",username);
                        map.put("password1",password1);
                        map.put("password2",password2);
                        map.put("school",school);
                        map.put("birthday",birthday);
                        Response response= OkHttpUtils.doPost("http://106.15.228.191",map);
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
