package com.example.lblood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class resutList extends AppCompatActivity {


    private String URLstring = "https://lblood.000webhostapp.com/api/getdoner.php?group=";

    private static ProgressDialog mProgressDialog;
    private ListView listView;
    ArrayList<RequestModel> dataModelArrayList;
    private ListAdapter listAdapter;
private  String blood="";
    private  String location="";

    private int did;
    private String name;
    private String age;
    private int number;
    private String address;
    private   String blood_group;

    private   String health;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resut_list);
        listView=findViewById(R.id.listView1);
        Bundle bundle = getIntent().getExtras();
       blood = bundle.getString("blood");
       location = bundle.getString("location");






        geturl();

        retrieveJSON();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                did= dataModelArrayList.get(position).getDID();
                name= dataModelArrayList.get(position).getfullName();
                age= dataModelArrayList.get(position).getAge();
                number= dataModelArrayList.get(position).getNumber();
                address= dataModelArrayList.get(position).getAddress();
                blood_group= dataModelArrayList.get(position).getBlood_group();
                health= dataModelArrayList.get(position).getHealth();

                Toast.makeText(getApplicationContext(),Integer.toString(did),Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(resutList.this, resultSingle.class);
                myIntent.putExtra("id", did);
                myIntent.putExtra("name", name);
                myIntent.putExtra("age", age);
                myIntent.putExtra("number", number);
                myIntent.putExtra("address", address);
                myIntent.putExtra("blood_group", blood_group);
                myIntent.putExtra("health", health);
                startActivity(myIntent);


            }
        });
    }
    private void retrieveJSON() {

        showSimpleProgressDialog(resutList.this, "Loading...","Please wait",false);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLstring,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("strrrrr", ">>" + response);



                        try {


                            JSONObject ex =new JSONObject(response);
                            int theredata=Integer.parseInt(ex.getString("exsit"));
                            if(theredata==1) {
                                showSimpleProgressDialog(resutList.this, "Loading...","Please wait",false);
                                JSONObject obj = new JSONObject(response);


                                dataModelArrayList = new ArrayList<>();
                                JSONArray dataArray = obj.getJSONArray("data");

                                for (int i = 0; i < dataArray.length(); i++) {

                                    RequestModel x = new RequestModel();
                                    JSONObject dataobj = dataArray.getJSONObject(i);
                                    Log.d("strrrrr", ">>" + dataobj.getString("DID"));
                                    x.setDID(Integer.parseInt(dataobj.getString("DID")));
                                    x.setFname(dataobj.getString("fname"));
                                    x.setLname(dataobj.getString("lname"));
                                    x.setNumber(Integer.parseInt(dataobj.getString("phone_number")));
                                    x.setAddress(dataobj.getString("address"));
                                    x.setDOB(dataobj.getString("DOB"));
                                    x.setBlood_group(dataobj.getString("blood_group"));
                                    x.setHealth(dataobj.getString("Health_History"));
                                    if (dataModelArrayList.isEmpty()) {
                                        Log.d("befoooooooooore", ">>>>>>>>>>>>>>>>>>0000000000000000");

                                    } else {


                                        Log.d("befoooooooooore", ">>>>>>>>>11111111111111111111111");
                                    }


                                    dataModelArrayList.add(x);
                                    if (dataModelArrayList.isEmpty()) {
                                        Log.d("Aftrrrrrrrrr", ">>>>>>>>>>>>>>>>>>0000000000000000");


                                    } else {


                                        Log.d("Aftrrrrrrrr", ">>>>>>>>>11111111111111111111111");
                                    }

                                }

                                setupListview();

                            }else{


                                Toast.makeText(getApplicationContext(), "no data to view ", Toast.LENGTH_SHORT).show();
                                removeSimpleProgressDialog();
                                finish();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurrs
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        // request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);


    }
private  void geturl(){

    char sign =blood.charAt(blood.length() - 1);
    char letter=blood.charAt(0);
    Log.d("////////////Char sign is ", ":"+sign );
    String f="";
    if(sign=='P'){
        f="%2B";

    }else{

        f="%2D";

    }
    Log.d("///////////f  is ", ":"+f );
    URLstring+=letter+f+"&address="+location;
    Log.d("//////////Url  is ", ":"+URLstring );
}
    private void setupListview(){

        removeSimpleProgressDialog();  //will remove progress dialog
        listAdapter =new RequestAdapter(this,dataModelArrayList);
        listView.setAdapter(listAdapter);

    }

    public static void removeSimpleProgressDialog() {
        try {
            if (mProgressDialog != null) {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                    mProgressDialog = null;
                }
            }
        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();

        } catch (RuntimeException re) {
            re.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void showSimpleProgressDialog(Context context, String title,
                                                String msg, boolean isCancelable) {
        try {
            if (mProgressDialog == null) {
                mProgressDialog = ProgressDialog.show(context, title, msg);
                mProgressDialog.setCancelable(isCancelable);
            }

            if (!mProgressDialog.isShowing()) {
                mProgressDialog.show();
            }

        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();
        } catch (RuntimeException re) {
            re.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
