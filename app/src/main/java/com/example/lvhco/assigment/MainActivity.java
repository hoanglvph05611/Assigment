package com.example.lvhco.assigment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                } catch (Exception e){

                }finally {
                    Intent intent = new Intent(MainActivity.this,Login.class);
                    startActivity(intent);
                }
            }
        });
        thread.start();
    }
}
