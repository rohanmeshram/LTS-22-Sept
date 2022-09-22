package com.example.lts15_sept_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class More_Details extends AppCompatActivity {

    Spinner spinner_child, spinner_parent;

    ArrayList<String> arrayList_child;
    ArrayAdapter<String> arrayAdapter_child;

    ArrayList<String> arrayList_restaurants,arrayList_doctors,arrayList_real_estate,arrayList_loans,arrayList_travels,arrayList_repairs,arrayList_automobile,arrayList_services,
            arrayList_wedding,arrayList_care;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_details);




    }
}