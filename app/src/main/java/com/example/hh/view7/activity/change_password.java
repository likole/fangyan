package com.example.hh.view7.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hh.view7.R;
import com.example.hh.view7.util.OkHttpUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Response;

public class change_password extends AppCompatActivity {

    private EditText edit1;
    private EditText edit2;
    private EditText edit3;
    private Button bt;
    private String username;
    private String old_password;
    private String new_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_passord);

        edit1=(EditText)findViewById(R.id.change_ed1);
        edit2=(EditText)findViewById(R.id.change_ed2);
        edit3=(EditText)findViewById(R.id.change_ed3);
        bt=(Button)findViewById(R.id.button);

        username=edit1.getText().toString();
        old_password=edit2.getText().toString();
        new_password=edit3.getText().toString();

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Map<String,String> map=new HashMap<>();
                        map.put("username",username);
                        map.put("old_password",old_password);
                        map.put("new_password",new_password);

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
