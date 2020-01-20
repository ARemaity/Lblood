package com.example.lblood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.Manifest.permission.CALL_PHONE;

public class resultSingle extends AppCompatActivity {
TextView Name,BloodGroup,age,location,health;
    String NameS,BloodGroupS,ageS,locationS,healthS;
    int  idS,numberS;
    Button req;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_single);
        Button button = (Button) findViewById(R.id.bn);
        req=findViewById(R.id.bn);
        Name=findViewById(R.id.name);
        BloodGroup=findViewById(R.id.bloodgroup);
        age=findViewById(R.id.age);
        location=findViewById(R.id.address);
        health=findViewById(R.id.health);
        Bundle bundle = getIntent().getExtras();
        idS = bundle.getInt("DID");
        Log.d("rrrrrrrrrrIDDDDDDDDDDDDDDD", ">>" + idS);
        Name.setText(bundle.getString("name"));
        age.setText( bundle.getString("age"));
        numberS = bundle.getInt("number");
        location.setText(bundle.getString("address"));
        BloodGroup.setText( bundle.getString("blood_group"));
        health.setText( bundle.getString("health"));


        req.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {

                requestPermissions(new String[]{CALL_PHONE}, 1);

                Intent intent = new Intent(view.getContext(), requestCall.class);

                intent.putExtra("DID", idS);
                startActivity(intent);
            }
        });
    }
}
