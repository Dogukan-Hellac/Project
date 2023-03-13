package com.example.isimsehiroyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    private Button normalOyun,sureliOyun,cikis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        normalOyun = findViewById(R.id.btnNormalOyun);
        sureliOyun = findViewById(R.id.btnSureliOyun);
        cikis = findViewById(R.id.btnCikis);

    }

    public void AnaSayfa(View view){

    switch (view.getId()) {
        case R.id.btnNormalOyun:
            Intent intent = new Intent(MainActivity.this, NomalOyunActivity.class);
            startActivity(intent);
            break;
        case R.id.btnSureliOyun:
            Intent intent1 = new Intent(MainActivity.this, SureliOyunActivity.class);
            startActivity(intent1);
            break;
        case R.id.btnCikis:
            break;
    }
    }
}