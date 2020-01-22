package com.example.lblood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import static android.Manifest.permission.CALL_PHONE;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class requestCall extends AppCompatActivity {
    EditText Name,hospital,phone;
    String NameS,hospitalS,phoneS;
    Button call;
    String DID;
    int phoneDoner;
  String HttpUrl  = "https://lblood.000webhostapp.com/api/insertrec.php";


    ProgressDialog progressDialog;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_call);
        Name=findViewById(R.id.nameR);
        hospital=findViewById(R.id.hospitalR);
        phone=findViewById(R.id.numberR);
        call=findViewById(R.id.callR);
        Bundle bundle = getIntent().getExtras();
        DID = Integer.toString(bundle.getInt("DID"));
        phoneDoner = bundle.getInt("number");
        requestQueue = Volley.newRequestQueue(this);
        progressDialog = new ProgressDialog(this);
        call.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                NameS = Name.getText().toString().trim();
                hospitalS = hospital.getText().toString().trim();
                phoneS = phone.getText().toString().trim();
                Log.d("////////////////////////////////////phoneS  is ", ":"+phoneDoner );

                progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                progressDialog.show();

                // Calling method to get value from EditText.




                StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing response message coming from server.
                                Toast.makeText(requestCall.this, ServerResponse, Toast.LENGTH_LONG).show();
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent i = new Intent(Intent.ACTION_CALL);

                                        i.setData(Uri.parse("tel:"+phoneDoner));

                                        if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                                            startActivity(i);
                                        } else {
                                            requestPermissions(new String[]{CALL_PHONE}, 1);
                                        }
                                    }
                                }, 2000);

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing error message if something goes wrong.
                                Toast.makeText(requestCall.this, volleyError.toString(), Toast.LENGTH_LONG).show();

                            }
                        }){
                    @Override
                    protected Map<String, String> getParams() {

                        // Creating Map String Params.
                        Map<String, String> params = new HashMap<String, String>();

                        // Adding All values to Params.
                        params.put("DID", DID);
                        params.put("name", NameS);
                        params.put("hospital_name", hospitalS);
                        params.put("phone_number", phoneS);

                        return params;
                    }

                };

                // Creating RequestQueue.
                RequestQueue requestQueue = Volley.newRequestQueue(requestCall.this);

                // Adding the StringRequest object into requestQueue.
                requestQueue.add(stringRequest);

            }
        });

    }


//    private  void askForPermission(String permission, Integer requestCode) {
//        if (ContextCompat.checkSelfPermission(requestCall.this, permission) != PackageManager.PERMISSION_GRANTED) {
//
//            // Should we show an explanation?
//            if (ActivityCompat.shouldShowRequestPermissionRationale(requestCall.this, permission)) {
//
//                //This is called if user has denied the permission before
//                //In this case I am just asking the permission again
//                ActivityCompat.requestPermissions(requestCall.this, new String[]{permission}, requestCode);
//
//            } else {
//
//                ActivityCompat.requestPermissions(requestCall.this, new String[]{permission}, requestCode);
//            }
//        } else {
//            Toast.makeText(this, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
//        }
//    }

}
