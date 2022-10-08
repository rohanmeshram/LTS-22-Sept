package com.example.lts15_sept_2022;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

import java.util.ArrayList;
import java.util.UUID;

public class More_Details extends AppCompatActivity {
    public ImageView img_logo, img_banner;
    public Button bt_logo, bt_banner;

    Spinner sp_local;
    ArrayList<String> arrayList_locality;
    ArrayAdapter<String> arrayAdapter_locality;

    private static final int STORAGE_PERMISSION_CODE = 4655;
    private Uri filepath1, filepath2;
    private Bitmap bitmap_logo, bitmap_banner;
    TextView tv1,tv2;

    private int PICK_IMAGE_REQUEST1 = 1, PICK_IMAGE_REQUEST2 = 2;

    public static final String UPLOAD_URL = "http://10.0.2.2/lts_Android/fileupload.php?add=333";

    Button bt_cont;

    EditText ed_dis, ed_services, ed_mon_am,ed_tue_am,ed_wed_am,ed_thu_am,ed_fri_am,ed_sat_am,ed_sun_am,ed_mon_pm,ed_tue_pm,ed_wed_pm,ed_thu_pm,ed_fri_pm,ed_sat_pm,ed_sun_pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_details);

        requestStoragePermission();
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
                    uploadImage();
                    Toast.makeText(getApplicationContext(),"Details Submitted",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(More_Details.this, Select_Plan.class);
                    startActivity(intent);
                }else
                    Toast.makeText(getApplicationContext(),"Enter All Details",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void requestStoragePermission()
    {
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            return;

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(this, "Permission Denied, Data cannot be Stored", Toast.LENGTH_LONG).show();
            }
        }
    }


    //================ Validation Code Start =======================================================================================
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

    //============== Select Logo Start ============================================
    public void selectLogo (View view)
    {
        showFileChooser1();
    }
    private void showFileChooser1()
    {
       Intent intent = new Intent ();
       intent.setType("image/*");
       intent.setAction(Intent.ACTION_GET_CONTENT);
       startActivityForResult(Intent.createChooser(intent, "Select Logo"), PICK_IMAGE_REQUEST1);
    }

    //============== Select Banner Start ============================================
    public void selectBanner (View view)
    {
        showFileChooser2();
    }
    private void showFileChooser2()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Banner"), PICK_IMAGE_REQUEST2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST1 && data != null && data.getData() != null) {

            filepath1 = data.getData();
            try {

                bitmap_logo = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath1);
                img_logo.setImageBitmap(bitmap_logo);
                tv1.setText(filepath1.toString());
                // Toast.makeText(getApplicationContext(),getPath(filepath),Toast.LENGTH_LONG).show();
            } catch (Exception ex) {

            }
        } else

        if (requestCode == PICK_IMAGE_REQUEST2 && data != null && data.getData() != null){

            filepath2 = data.getData();
            try {
                bitmap_banner = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath2);
                img_banner.setImageBitmap(bitmap_banner);
               tv2.setText(filepath2.toString());
            }catch (Exception ex){

            }
        }
    }

    //============ Function to Change Path =========================================================

    private String getPath (Uri uri){
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, MediaStore.Images.Media._ID + "=?", new String[]{document_id}, null
        );
        cursor.moveToFirst();
        @SuppressLint("Range") String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();
        return path;
    }

    private  void uploadImage()
    {
        final String path = getPath(filepath1);
        final String path2 = getPath(filepath2);
        final String describe = ed_dis.getText().toString().trim();
        final String services = ed_services.getText().toString().trim();
        final String location = sp_local.getSelectedItem().toString().trim();
        final String mon_am = ed_mon_am.getText().toString().trim();
        final String mon_pm = ed_mon_pm.getText().toString().trim();
        final String tue_am = ed_tue_am.getText().toString().trim();
        final String tue_pm = ed_tue_pm.getText().toString().trim();
        final String wed_am = ed_wed_am.getText().toString().trim();
        final String wed_pm = ed_wed_pm.getText().toString().trim();
        final String thu_am = ed_thu_am.getText().toString().trim();
        final String thu_pm = ed_thu_pm.getText().toString().trim();
        final String fri_am = ed_fri_am.getText().toString().trim();
        final String fri_pm = ed_fri_pm.getText().toString().trim();
        final String sat_am = ed_sat_am.getText().toString().trim();
        final String sat_pm = ed_sat_pm.getText().toString().trim();
        final String sun_am = ed_sun_am.getText().toString().trim();
        final String sun_pm = ed_sun_pm.getText().toString().trim();

        try {
            String uploadId = UUID.randomUUID().toString();
            new MultipartUploadRequest(this, uploadId, UPLOAD_URL).addFileToUpload(path,"upload1").addFileToUpload(path2,"upload2").addParameter("ed_dis", describe).addParameter("ed_services",services).addParameter("sp_local",location).addParameter("ed_mon_am",mon_am).addParameter("ed_mon_pm",mon_pm).addParameter("ed_tue_am",tue_am).addParameter("ed_tue_pm",tue_pm).addParameter("ed_wed_am",wed_am).addParameter("ed_wed_pm",wed_pm).addParameter("ed_thu_am",thu_am).addParameter("ed_thu_pm",thu_pm).addParameter("ed_fri_am",fri_am).addParameter("ed_fri_pm",fri_pm).addParameter("ed_sat_am",sat_am).addParameter("ed_sat_pm",sat_pm).addParameter("ed_sun_am",sun_am).addParameter("ed_sun_pm",sun_pm)

                    .setMaxRetries(3)
                    .startUpload();
        }catch (Exception ex){

        }
    }


}
