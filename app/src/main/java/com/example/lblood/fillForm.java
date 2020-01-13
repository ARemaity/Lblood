package com.example.lblood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class fillForm extends AppCompatActivity {
RadioButton yes;
RadioButton no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_form);
        Button button = (Button) findViewById(R.id.sbt);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), intro.class);
                startActivity(intent);
                Toast.makeText(fillForm.this, "Submitted", Toast.LENGTH_LONG).show();
            }

        });
yes=findViewById(R.id.radio_yes);
        no=findViewById(R.id.radio_no);
    }
    public void onRadioButtonClicked(View view) {


        boolean checked = ((RadioButton) view).isChecked();


        switch(view.getId()) {
            case R.id.radio_yes:
                if (checked)
                    Toast.makeText(this, "yes",
                            Toast.LENGTH_LONG).show();
                no.setChecked(false);

                    break;
            case R.id.radio_no:
                if (checked)
                    Toast.makeText(this, "no",
                            Toast.LENGTH_LONG).show();
                yes.setChecked(false);
                    break;
        }

    }
}
