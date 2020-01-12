package com.example.lblood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class fillForm extends AppCompatActivity {
RadioButton yes;
RadioButton no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_form);
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
