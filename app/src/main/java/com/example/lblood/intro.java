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




        ImageView donate = (ImageView) findViewById(R.id.imageView1);
        donate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent2 = new Intent(intro.this, search.class);

                intro.this.startActivity(myIntent2);
            }
        });


    }



}
