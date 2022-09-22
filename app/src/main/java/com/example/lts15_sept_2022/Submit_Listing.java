package com.example.lts15_sept_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import java.util.ArrayList;

public class Submit_Listing extends AppCompatActivity {

  Button button_submit;



    //============== Initialization for DropDown Spinner ===========================================
    Spinner sp_city, sp_parent, sp_child;

    ArrayList<String> arrayList_parent, arrayList_city, arrayList_child;
    ArrayAdapter<String> arrayAdapter_parent, arrayAdapter_city, arrayAdapter_child;
    ArrayList<String> arrayList_restaurants,arrayList_doctors,arrayList_real_estate,arrayList_travels,arrayList_repairs,arrayList_automobile, arrayList_services, arrayList_wedding, arrayList_care, arrayList_school, arrayList_electronics, arrayList_agri, arrayList_astro, arrayList_bcare, arrayList_sports, arrayList_fit, arrayList_dneeds, arrayList_courier, arrayList_civil, arrayList_chemist, arrayList_books, arrayList_hotels, arrayList_pest, arrayList_pack, arrayList_furniture,arrayList_caterers, arrayList_job;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_listing);


    //=============== Parent and Child Spinner Code i.e Category, Sub-Cat and City =================
       sp_parent=(Spinner) findViewById(R.id.spinner_parent);
        sp_child=(Spinner) findViewById(R.id.spinner_child);
        sp_city=(Spinner) findViewById(R.id.spinner_city);

        arrayList_parent=new ArrayList<>();
        arrayList_parent.add("Restaurants");
        arrayList_parent.add("Doctors");
        arrayList_parent.add("Schools and Colleges");
        arrayList_parent.add("Electronics");
        arrayList_parent.add("Tours & Travels");
        arrayList_parent.add("Repairs");
        arrayList_parent.add("Automobiles");
        arrayList_parent.add("Real Estate");
        arrayList_parent.add("Weddings");
        arrayList_parent.add("Personal Care");
        arrayList_parent.add("Job");
        arrayList_parent.add("Agriculture");
        arrayList_parent.add("Astrology");
        arrayList_parent.add("Baby Care");
        arrayList_parent.add("Sports");
        arrayList_parent.add("Fitness");
        arrayList_parent.add("Daily Needs");
        arrayList_parent.add("Courier");
        arrayList_parent.add("Civil Contractor");
        arrayList_parent.add("Chemist");
        arrayList_parent.add("Books");
        arrayList_parent.add("Hotels");
        arrayList_parent.add("Pest Control");
        arrayList_parent.add("Packers & Movers");
        arrayList_parent.add("Furniture");
        arrayList_parent.add("Caterers");


        arrayAdapter_parent=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_parent);
        sp_parent.setAdapter(arrayAdapter_parent);

    //============= Child Spinner Process Starts ===================================================

        arrayList_restaurants=new ArrayList<>();
        arrayList_restaurants.add("American Restaurants");
        arrayList_restaurants.add("Andhra Restaurants");
        arrayList_restaurants.add("Arabic Restaurants");
        arrayList_restaurants.add("Awadhi Restaurants");
        arrayList_restaurants.add("Barbeque Restaurants");
        arrayList_restaurants.add("Bengal Restaurants");
        arrayList_restaurants.add("Continental Restaurants");
        arrayList_restaurants.add("Coastal Restaurants");
        arrayList_restaurants.add("Punjabi Restaurants");
        arrayList_restaurants.add("European Restaurants");
        arrayList_restaurants.add("French Restaurants");
        arrayList_restaurants.add("Maharashtrian Restaurants");


        arrayList_doctors=new ArrayList<>();
        arrayList_doctors.add("General Surgeon");
        arrayList_doctors.add("ENT Surgeon");
        arrayList_doctors.add("Hepatologist");
        arrayList_doctors.add("ESIC");
        arrayList_doctors.add("Gastroenterologist");
        arrayList_doctors.add("Physiotherapists");
        arrayList_doctors.add("Piles");
        arrayList_doctors.add("Dentist");
        arrayList_doctors.add("Psychiatrists");
        arrayList_doctors.add("Psychologist");
        arrayList_doctors.add("Pulmonologist");
        arrayList_doctors.add("Radiologist");
        arrayList_doctors.add("Rheumatologist");


        arrayList_school=new ArrayList<>();
        arrayList_school.add("Science Collages");
        arrayList_school.add("Commerce Collages");
        arrayList_school.add("Dental Collages");
        arrayList_school.add("Law Collages");
        arrayList_school.add("Medical Collages");
        arrayList_school.add("Polytechnic Institutes");
        arrayList_school.add("Engineering Collages");
        arrayList_school.add("Baby Sitters");
        arrayList_school.add("Convent Schools");
        arrayList_school.add("Day Care Centers");
        arrayList_school.add("Nursery Schools");
        arrayList_school.add("Military Schools");
        arrayList_school.add("Boarding Schools");


        arrayList_electronics=new ArrayList<>();
        arrayList_electronics.add("Dish TV Dealers");
        arrayList_electronics.add("Water Filters and Purifiers");
        arrayList_electronics.add("Inverter Dealers");
        arrayList_electronics.add("Washing Machine Dealers");
        arrayList_electronics.add("Decorative Light Dealers");
        arrayList_electronics.add("Laptop Dealers");
        arrayList_electronics.add("Mobile Dealers");
        arrayList_electronics.add("Refrigerator Dealers");
        arrayList_electronics.add("LCD TV");
        arrayList_electronics.add("Electronic Shops");
        arrayList_electronics.add("Vi Store");
        arrayList_electronics.add("Air Cooler Dealers");


        arrayList_travels=new ArrayList<>();
        arrayList_travels.add("Air Ticketing Agents (Domestic)");
        arrayList_travels.add("Domestic Travel Agents");
        arrayList_travels.add("Domestic Tour Operators");
        arrayList_travels.add("International Tour Operators");
        arrayList_travels.add("Taxi Services");
        arrayList_travels.add("Radio Taxi");
        arrayList_travels.add("Tour Operators");
        arrayList_travels.add("Travel Passport Services");
        arrayList_travels.add("International Tour Package Dealers");
        arrayList_travels.add("Mini Bus on Hire");
        arrayList_travels.add("Taxi Services Inter City");
        arrayList_travels.add("Taxi Services Intra City");


        arrayList_repairs=new ArrayList<>();
        arrayList_repairs.add("Car Mechanic");
        arrayList_repairs.add("AC Repair Services");
        arrayList_repairs.add("TV Repairs");
        arrayList_repairs.add("Computer Repairs");
        arrayList_repairs.add("Mobile Repairs");
        arrayList_repairs.add("Laptop Repair Services");
        arrayList_repairs.add("Refrigerator Repair Services");
        arrayList_repairs.add("Washing Machine Repair Services");


        arrayList_automobile=new ArrayList<>();
        arrayList_automobile.add("Automobile Dealers");
        arrayList_automobile.add("Driving Schools");
        arrayList_automobile.add("Car Accessory Dealers");
        arrayList_automobile.add("Car Dealers");
        arrayList_automobile.add("Car Parts Dealers");
        arrayList_automobile.add("Garages");
        arrayList_automobile.add("Car Showrooms");
        arrayList_automobile.add("Bike Showrooms");
        arrayList_automobile.add("Tractor Dealers");
        arrayList_automobile.add("Car Tyre Dealers");
        arrayList_automobile.add("Electric Bike Dealers");
        arrayList_automobile.add("Bicycle Dealers");


        arrayList_real_estate=new ArrayList<>();
        arrayList_real_estate.add("Commercial Lands");
        arrayList_real_estate.add("Property Dealers");
        arrayList_real_estate.add("Residential Plots");
        arrayList_real_estate.add("Residential Apartments");
        arrayList_real_estate.add("Real Estate Agents");
        arrayList_real_estate.add("Construction Companies");
        arrayList_real_estate.add("Warehouses");
        arrayList_real_estate.add("Godowns");
        arrayList_real_estate.add("Land Developers");
        arrayList_real_estate.add("Farm Houses");
        arrayList_real_estate.add("Hostel");
        arrayList_real_estate.add("Real Estate Developers");


        arrayList_wedding=new ArrayList<>();
        arrayList_wedding.add("Photo Studios");
        arrayList_wedding.add("Wedding Card Printers");
        arrayList_wedding.add("Marriage Bureaus");
        arrayList_wedding.add("AC Banquet Halls");
        arrayList_wedding.add("Caterers");
        arrayList_wedding.add("Non AC Banquet Halls");
        arrayList_wedding.add("Flower Decorators");
        arrayList_wedding.add("Mandap Decorators");
        arrayList_wedding.add("Car Decorators");
        arrayList_wedding.add("Wedding Bands");
        arrayList_wedding.add("5 Star Banquet Halls");


        arrayList_care=new ArrayList<>();
        arrayList_care.add("Beauty Parlours");
        arrayList_care.add("Bridal Makeup Artists");
        arrayList_care.add("Hair Stylists");
        arrayList_care.add("Mehendi Artists");
        arrayList_care.add("Unisex Salon");
        arrayList_care.add("Gents Salon");
        arrayList_care.add("Tattoo Parlours");
        arrayList_care.add("Cosmetic Products");
        arrayList_care.add("Ladies Beauty Parlours");
        arrayList_care.add("Unisex Beauty Parlours");
        arrayList_care.add("Gents Beauty Parlours");
        arrayList_care.add("Makeup Institute");


        arrayList_job=new ArrayList<>();
        arrayList_job.add("Placement Services for Civil Industry");
        arrayList_job.add("Placement Services for Computer Hardware");
        arrayList_job.add("Placement Services for Computer Operator");
        arrayList_job.add("Placement Services for Data Entry Operator");
        arrayList_job.add("Placement Services for Electrical Engineers");
        arrayList_job.add("Placement Services for Engineering Freshers");
        arrayList_job.add("Placement Services for Hospital Staff");
        arrayList_job.add("Placement Services for HR");
        arrayList_job.add("Placement Services for Back Office");
        arrayList_job.add("Placement Services for MBA Students");
        arrayList_job.add("Placement Services for Pharma Industry");


        arrayList_agri=new ArrayList<>();


        arrayList_astro=new ArrayList<>();
        arrayList_astro.add("Numerologist");
        arrayList_astro.add("Astrology Computerised");
        arrayList_astro.add("Pandit for Pooja");
        arrayList_astro.add("Vastu Shastra Consultant");
        arrayList_astro.add("Astrology Training Center");


        arrayList_bcare=new ArrayList<>();
        arrayList_bcare.add("Baby Food");
        arrayList_bcare.add("Baby Sitters");
        arrayList_bcare.add("Baby Bath");
        arrayList_bcare.add("Books");
        arrayList_bcare.add("Clothes");
        arrayList_bcare.add("Creams");
        arrayList_bcare.add("Diapers");
        arrayList_bcare.add("Footwear");
        arrayList_bcare.add("Grooming");
        arrayList_bcare.add("Toys");


        arrayList_sports=new ArrayList<>();
        arrayList_sports.add("Badminton");
        arrayList_sports.add("Cricket");
        arrayList_sports.add("Volleyball");
        arrayList_sports.add("Basketball");
        arrayList_sports.add("Tennis");
        arrayList_sports.add("Table Tennis");
        arrayList_sports.add("Football");
        arrayList_sports.add("Field Hockey");
        arrayList_sports.add("Baseball");
        arrayList_sports.add("Golf");
        arrayList_sports.add("Boxing");
        arrayList_sports.add("Archery");


        arrayList_fit=new ArrayList<>();
        arrayList_fit.add("Health Clubs");
        arrayList_fit.add("Meditation Centers");
        arrayList_fit.add("Meditation Classes");
        arrayList_fit.add("Yoga Classes");
        arrayList_fit.add("Aerobic Classes");
        arrayList_fit.add("Nutrition Clubs");
        arrayList_fit.add("Fitness Equipment Shop");
        arrayList_fit.add("Gymnasiums");
        arrayList_fit.add("Therapy Center");
        arrayList_fit.add("Medical Equipment");
        arrayList_fit.add("Reflexology Massage Centers");


        arrayList_dneeds=new ArrayList<>();


        arrayList_courier=new ArrayList<>();


        arrayList_civil=new ArrayList<>();


        arrayList_chemist=new ArrayList<>();
        arrayList_chemist.add("Hospital");
        arrayList_chemist.add("Dentists");
        arrayList_chemist.add("Medical");
        arrayList_chemist.add("Pathology Labs");
        arrayList_chemist.add("Ambulance");
        arrayList_chemist.add("Opticians");
        arrayList_chemist.add("Blood Banks");


        arrayList_chemist=new ArrayList<>();


        arrayList_books=new ArrayList<>();


        arrayList_hotels=new ArrayList<>();


        arrayList_pest=new ArrayList<>();
        arrayList_pest.add("Pest Control");
        arrayList_pest.add("Ant Control");
        arrayList_pest.add("Cockroach Control");
        arrayList_pest.add("Commercial Pest Control");
        arrayList_pest.add("Fly Control");
        arrayList_pest.add("Lizard Control");
        arrayList_pest.add("Mosquito Control");
        arrayList_pest.add("Residential Pest Control");
        arrayList_pest.add("Rodent Control");
        arrayList_pest.add("Bird Control");
        arrayList_pest.add("Spider Control");
        arrayList_pest.add("Wasp & Bee Control");


        arrayList_pack=new ArrayList<>();
        arrayList_pack.add("Local");
        arrayList_pack.add("National");
        arrayList_pack.add("International");
        arrayList_pack.add("Movers for Automobile");
        arrayList_pack.add("Transporters");


        arrayList_furniture=new ArrayList<>();
        arrayList_furniture.add("Furniture & Fixture");
        arrayList_furniture.add("Steel Fabrication Works");
        arrayList_furniture.add("Furniture Showrooms");
        arrayList_furniture.add("Commercial Furniture");
        arrayList_furniture.add("Interior Decoration");
        arrayList_furniture.add("Interior Designer");
        arrayList_furniture.add("Modular Kitchen");
        arrayList_furniture.add("Furniture Wholesaler");
        arrayList_furniture.add("Plastic Furniture Wholesaler");
        arrayList_furniture.add("Glassware Wholesaler");
        arrayList_furniture.add("PoP Design Worker Services");
        arrayList_furniture.add("Plywood Dealers");


        arrayList_caterers=new ArrayList<>();



        sp_parent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                if(position==0)
                {
                    arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_restaurants);
                }

                if(position==1)
                {
                    arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_doctors);
                }

                sp_child.setAdapter(arrayAdapter_child);

             if(position==2)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_school);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==3)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_electronics);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==4)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_travels);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==5)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_repairs);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==6)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_automobile);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==7)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_real_estate);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==8)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_wedding);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==9)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_care);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==10)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_job);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==11)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_agri);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==12)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_astro);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==13)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_bcare);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==14)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_sports);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==15)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_fit);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==16)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_dneeds);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==17)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_courier);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==18)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_civil);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==19)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_chemist);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==20)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_books);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==21)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_hotels);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==22)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_pest);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==23)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_pack);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==24)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_furniture);
             }

             sp_child.setAdapter(arrayAdapter_child);

             if(position==25)
             {
              arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_caterers);
             }

             sp_child.setAdapter(arrayAdapter_child);


            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //============= Child Spinner Process End ===============================================

    //============= City Spinner Starts ============================================================
        arrayList_city=new ArrayList<>();
        arrayList_city.add("Nagpur");
        arrayList_city.add("Raipur");
        arrayList_city.add("Nashik");

        arrayAdapter_city=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_city);
        sp_city.setAdapter(arrayAdapter_city);

        //============== On Click Button Start ==========================================================
       // setContentView(R.layout.activity_submit_listing);

        button_submit = (Button) findViewById(R.id.button_submit);
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Submit_Listing.this, More_Details.class);
                startActivity(intent);

            }
        });

        //============== On Click Button END =======================================================

    }

}