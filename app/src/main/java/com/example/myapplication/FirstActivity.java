package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    private Button jumpToMain;
    private Button jumpToSecond;
    private String TAG = "FirstActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        jumpToMain = findViewById(R.id.jumpToMain);
        jumpToSecond = findViewById(R.id.jumpToTwo);

        jumpToMain.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                startMainActivity();
            }
        });
        jumpToSecond.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                startSecondActivity();
            }
        });
        Log.d(TAG,"wangbin" + getTaskId());
    }
    private void startMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    private void startSecondActivity(){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}
