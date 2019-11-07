package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private Button jumpToMain;
    private Button jumpToFirst;
    private String TAG = "secondActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        jumpToMain = findViewById(R.id.jumpToMain);
        jumpToFirst = findViewById(R.id.jumpToOne);

        jumpToMain.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                startMainActivity();
            }
        });
        jumpToFirst.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                startFirstActivity();
            }
        });
        Log.d(TAG,"wangbin" + getTaskId());
    }
    private void startMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    private void startFirstActivity(){
        Intent intent = new Intent(this,FirstActivity.class);
        startActivity(intent);
    }
}
