package com.example.lts15_sept_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Re_Enter_Password extends AppCompatActivity {

    Button bt_relog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_enter_password);

        bt_relog=(Button) findViewById(R.id.button_relog);
        bt_relog.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Re_Enter_Password.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}