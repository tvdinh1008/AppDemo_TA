package com.example.appdemo_ta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("");
        //toolbar.setNavigationIcon(R.id.action_menu);

        Button transImage=findViewById(R.id.trans_en);
        transImage.setOnClickListener(this);
        Button transSentences=findViewById(R.id.trans_vn);
        transSentences.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.trans_en:
                Intent intent=new Intent(MainActivity.this,TranslateActivity.class);
                startActivity(intent);
                break;
            case R.id.trans_vn:
                Intent intent2=new Intent(MainActivity.this,TranslateVNActivity.class);
                startActivity(intent2);
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
