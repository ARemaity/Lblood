package com.example.lblood;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    private String HttpUrl  = "https://lblood.000webhostapp.com/api/insertrec";


    ProgressDialog progressDialog;
    RequestQueue requestQueue;
    public ArrayList<RequestModel> dataModelArrayList=new ArrayList<RequestModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_call);
         Name=findViewById(R.id.nameR);
        hospital=findViewById(R.id.hospitalR);
        phone=findViewById(R.id.numberR);
        call=findViewById(R.id.callR);
        Bundle bundle = getIntent().getExtras();
        DID = bundle.getString("DID");
        NameS = Name.getText().toString().trim();
        hospitalS = hospital.getText().toString().trim();
        phoneS = phone.getText().toString().trim();
        requestQueue = Volley.newRequestQueue(this);

        progressDialog = new ProgressDialog(this);
        call.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {



                // Showing progress dialog at user registration time.
                progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                progressDialog.show();



                // Creating string request with post method.
                StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing response message coming from server.
                                Toast.makeText(requestCall.this, ServerResponse, Toast.LENGTH_LONG).show();
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
                        }) {
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




}
