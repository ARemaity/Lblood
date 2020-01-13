package com.example.lblood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView donner = (ImageView) findViewById(R.id.imageView2);
        donner.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(intro.this, fillForm.class);

                intro.this.startActivity(myIntent);
            }
        });

        ImageView donate = (ImageView) findViewById(R.id.imageView1);
        donate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent2 = new Intent(intro.this, search.class);

                intro.this.startActivity(myIntent2);
            }
        });


    }



}
