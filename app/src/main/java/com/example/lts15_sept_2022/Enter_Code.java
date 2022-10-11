package com.example.lts15_sept_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Enter_Code extends AppCompatActivity {
    Button bt_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_code);

        bt_code=(Button) findViewById(R.id.button_nxt);
        bt_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Enter_Code.this, Re_Enter_Password.class);
                startActivity(intent);
            }
        });
    }
}