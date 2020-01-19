package com.example.lblood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class resultSingle extends AppCompatActivity {
TextView Name,BloodGroup,age,location,health;
    String idS,NameS,BloodGroupS,ageS,locationS,healthS,numberS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_single);
        Button button = (Button) findViewById(R.id.bn);
        Name=findViewById(R.id.name);
        BloodGroup=findViewById(R.id.bloodgroup);
        age=findViewById(R.id.age);
        location=findViewById(R.id.address);
        health=findViewById(R.id.health);
        Bundle bundle = getIntent().getExtras();
        idS = bundle.getString("id");
        Name.setText(bundle.getString("name"));
        age.setText( bundle.getString("age"));
        numberS = bundle.getString("number");
        location.setText(bundle.getString("address"));
        BloodGroup.setText( bundle.getString("blood_group"));
        health.setText( bundle.getString("health"));


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity







                Intent intent = new Intent(view.getContext(), requestCall.class);

                intent.putExtra("DID", idS);
                startActivity(intent);
            }
        });
    }
}
