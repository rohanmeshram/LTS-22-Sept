package com.example.lts15_sept_2022;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public TextView textView4;
    public TextView textView3;

    private static final String apiurl="http://10.0.2.2/lts_Android/login_maker.php";
    EditText ed_mail,ed_pass;
    TextView tv;
    Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);

     //   super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_mail=(EditText) findViewById(R.id.edit_email);
        ed_pass=(EditText) findViewById(R.id.edit_pass);
        tv=(TextView) findViewById(R.id.tv_result);
        bt_login=(Button) findViewById(R.id.button2);

        checkuserexistance();

//==================== To Jump on Submit Listing Page ==============================================
        textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Submit_Listing.class);
                startActivity(intent);
            }
        });

//=================== To Jump on Forgot Password Page ==============================================
        textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Forgot_Password.class);
                startActivity(intent);
            }
        });

//================ Login Process ===================================================================
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processlogin();
            }
        });

    }

    private void processlogin()
    {
        String email=ed_mail.getText().toString();
        String password=ed_pass.getText().toString();
        Call<responsemodel> call=controller
                .getInstance()
                .getapi()
                .verifyuser(email,password);

        call.enqueue(new Callback<responsemodel>() {
            @Override
            public void onResponse(Call<responsemodel> call, Response<responsemodel> response) {
                responsemodel obj = response.body();
                String output=obj.getMessage();
                if(output.equals("Failed"))
                {
                    ed_mail.setText("");
                    ed_pass.setText("");
                    tv.setTextColor(Color.RED);
                    tv.setText("Invalid Email or Password");
                }else
                {
                    SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("email",ed_mail.getText().toString());
                    editor.putString("password",ed_pass.getText().toString());
                    editor.commit();
                    editor.apply();

                    startActivity(new Intent(getApplicationContext(),AfterLogin.class));
                    finish();
                }
            }

            @Override
            public void onFailure(Call<responsemodel> call, Throwable t) {
                tv.setText("Something Went Wrong");
                tv.setTextColor(Color.RED);
            }
        });
    }

    private void checkuserexistance()
    {
        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
        if(sp.contains("email"))
            startActivity(new Intent(getApplicationContext(),AfterLogin.class));
        else
        {
            tv.setText("");
            tv.setTextColor(Color.RED);
        }
    }


}
