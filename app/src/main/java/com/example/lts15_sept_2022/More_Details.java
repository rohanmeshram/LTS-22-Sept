package com.example.lts15_sept_2022;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class More_Details extends AppCompatActivity {
    public ImageView img_logo, img_banner;
    public Button bt_logo, bt_banner;
    int SELECT_IMAGE_CODE=1;
    int SELECT_IMAGE_CODE1=2;

    Spinner sp_local;
    ArrayList<String> arrayList_locality;
    ArrayAdapter<String> arrayAdapter_locality;

    Button bt_cont;

    EditText ed_dis, ed_services, ed_mon_am,ed_tue_am,ed_wed_am,ed_thu_am,ed_fri_am,ed_sat_am,ed_sun_am,ed_mon_pm,ed_tue_pm,ed_wed_pm,ed_thu_pm,ed_fri_pm,ed_sat_pm,ed_sun_pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_details);
        //=============== Initialisation of All Variables for Validation ===========================

        ed_dis = (EditText) findViewById(R.id.editText_dis);
        ed_services = (EditText) findViewById(R.id.editText_services);
        ed_mon_am = (EditText) findViewById(R.id.mon_am);
        ed_mon_pm = (EditText) findViewById(R.id.mon_pm);
        ed_tue_am = (EditText) findViewById(R.id.tue_am);
        ed_tue_pm = (EditText) findViewById(R.id.tue_pm);
        ed_wed_am = (EditText) findViewById(R.id.wed_am);
        ed_wed_pm = (EditText) findViewById(R.id.wed_pm);
        ed_thu_am = (EditText) findViewById(R.id.thu_am);
        ed_thu_pm = (EditText) findViewById(R.id.thu_pm);
        ed_fri_am = (EditText) findViewById(R.id.fri_am);
        ed_fri_pm = (EditText) findViewById(R.id.fri_pm);
        ed_sat_am = (EditText) findViewById(R.id.sat_am);
        ed_sat_pm = (EditText) findViewById(R.id.sat_pm);
        ed_sun_am = (EditText) findViewById(R.id.sun_am);
        ed_sun_pm = (EditText) findViewById(R.id.sun_pm);

        //=============== End of Variables for Validation ==========================================

    img_logo= (ImageView) findViewById(R.id.up_logo);
    bt_logo= (Button) findViewById(R.id.choose_logo);
    img_banner= (ImageView) findViewById(R.id.up_banner);
    bt_banner= (Button) findViewById(R.id.choose_banner);
    sp_local=(Spinner) findViewById(R.id.spinner_local);

        arrayList_locality=new ArrayList<>();
        arrayList_locality.add("Laxmi Nagar");
        arrayList_locality.add("Shradhananpeth");
        arrayList_locality.add("Gopal Nagar");
        arrayList_locality.add("Bhamti");
        arrayList_locality.add("Subhas Nagar");
        arrayList_locality.add("Parsodi");
        arrayList_locality.add("Sambhaji Nagar");
        arrayList_locality.add("Ranapratap Nagar");
        arrayList_locality.add("Trimurti Nagar");
        arrayList_locality.add("Gayatri Nagar");
        arrayList_locality.add("Swawlambi Nagar");
        arrayList_locality.add("Vasant Nagar");
        arrayList_locality.add("Deendayal Nagar");
        arrayAdapter_locality=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_locality);
        sp_local.setAdapter(arrayAdapter_locality);



    bt_logo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent,"Title"),SELECT_IMAGE_CODE);
        }
    });

    bt_banner.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent,"Title2"),SELECT_IMAGE_CODE1);
        }
    });

        bt_cont = (Button) findViewById(R.id.button_cont);
        bt_cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //============= For Validation =====================================================

                String describe = ed_dis.getText().toString();
                String services = ed_services.getText().toString();
                String mon_am = ed_mon_am.getText().toString();
                String mon_pm = ed_mon_pm.getText().toString();
                String tue_am = ed_tue_am.getText().toString();
                String tue_pm = ed_tue_pm.getText().toString();
                String wed_am = ed_wed_am.getText().toString();
                String wed_pm = ed_wed_pm.getText().toString();
                String thu_am = ed_thu_am.getText().toString();
                String thu_pm = ed_thu_pm.getText().toString();
                String fri_am = ed_fri_am.getText().toString();
                String fri_pm = ed_fri_pm.getText().toString();
                String sat_am = ed_sat_am.getText().toString();
                String sat_pm = ed_sat_pm.getText().toString();
                String sun_am = ed_sun_am.getText().toString();
                String sun_pm = ed_sun_pm.getText().toString();


                boolean check= (boolean) validationInfo(describe,services,mon_am,mon_pm,tue_am,tue_pm,wed_am,wed_pm,thu_am,thu_pm,fri_am,fri_pm,sat_pm,sat_am,sun_am,sun_pm);

                if (check==true){
                    Toast.makeText(getApplicationContext(),"Details Submitted",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(More_Details.this, Select_Plan.class);
                startActivity(intent);
                }else
                    Toast.makeText(getApplicationContext(),"Enter All Details",Toast.LENGTH_SHORT).show();
            }
        });

}

    private Object validationInfo(String describe, String services, String mon_am, String mon_pm, String tue_am, String tue_pm, String wed_am, String wed_pm, String thu_am, String thu_pm, String fri_am, String fri_pm, String sat_pm, String sat_am, String sun_am, String sun_pm) {
        if (describe.length() == 0) {
            ed_dis.requestFocus();
            ed_dis.setError("This Field cannot be Empty");
            return false;
        }

        else if (services.length()==0){
            ed_services.requestFocus();
            ed_services.setError("This Field Cannot be Empty");
            return false;
        }

        else if (mon_am.length()==0){
            ed_mon_am.requestFocus();
            ed_mon_am.setError("Enter Opening Time");
            return false;
        }else if (mon_pm.length()==0){
            ed_mon_pm.requestFocus();
            ed_mon_pm.setError("Enter Closing Time");
            return false;
        }

        else if (tue_am.length()==0){
            ed_tue_am.requestFocus();
            ed_tue_am.setError("Enter Opening Time");
            return false;
        }else if (tue_pm.length()==0){
            ed_tue_pm.requestFocus();
            ed_tue_pm.setError("Enter Closing Time");
            return false;
        }

        else if (wed_am.length()==0){
            ed_wed_am.requestFocus();
            ed_wed_am.setError("Enter Opening Time");
            return false;
        }else if (wed_pm.length()==0){
            ed_wed_pm.requestFocus();
            ed_wed_pm.setError("Enter Closing Time");
            return false;
        }

        else if (thu_am.length()==0){
            ed_thu_am.requestFocus();
            ed_thu_am.setError("Enter Opening Time");
            return false;
        }else if (thu_pm.length()==0){
            ed_thu_pm.requestFocus();
            ed_thu_pm.setError("Enter Closing Time");
            return false;
        }

        else if (fri_am.length()==0){
            ed_fri_am.requestFocus();
            ed_fri_am.setError("Enter Opening Time");
            return false;
        }else if (fri_pm.length()==0){
            ed_fri_pm.requestFocus();
            ed_fri_pm.setError("Enter Closing Time");
            return false;
        }

        else if (sat_am.length()==0){
            ed_sat_am.requestFocus();
            ed_sat_am.setError("Enter Opening Time");
            return false;
        }else if (sat_pm.length()==0){
            ed_sat_pm.requestFocus();
            ed_sat_pm.setError("Enter Closing Time");
            return false;
        }

        else if (sun_am.length()==0){
            ed_sun_am.requestFocus();
            ed_sun_am.setError("No Timing type Closed");
            return false;
        }else if (sun_pm.length()==0){
            ed_sun_pm.requestFocus();
            ed_sun_pm.setError("Enter Closing Time");
            return false;
        }
       return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1)
        {
            Uri uri=data.getData();
            img_logo.setImageURI(uri);
        }
        if(requestCode==2){
            Uri uri=data.getData();
            img_banner.setImageURI(uri);
        }
    }

}
