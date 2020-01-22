package com.example.lblood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class search extends AppCompatActivity {
    private Spinner bloodSP;

    private Spinner locationSP;
    private String choosinBlood;
    private String choosingLocation;

    String[] locations = new String[]{

            "Akkar",
            "Nabatieh",
            "Baalback-Hermel",
        "Beirut",
        "Beqaa",
  "Mount Lebanon",
   "South Lebanon",
    "North Lebanon"
    };
    String[] bloods = new String[]{

            "A+",
            "A-",
            "B+",
            "B-",
            "AB+",
            "AB-",
            "O+",
            "O-"
    };

    ArrayAdapter<String> bloodAdapter;
    ArrayAdapter<String> locationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Button button = (Button) findViewById(R.id.sch);
        bloodSP=findViewById(R.id.spinner1);
        locationSP=findViewById(R.id.spinner2);
        bloodAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,bloods);
        locationAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,locations);
bloodSP.setAdapter(bloodAdapter);
        locationSP.setAdapter(locationAdapter);
//        final String bloods = blood.getSelectedItem().toString();
//        final String locations = location.getSelectedItem().toString();



        bloodSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        @Override

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            //use postion value

            switch (position)

            {

                case 0:

                    choosinBlood = "AP";

                    break;

                case 1:

                    choosinBlood = "AN";

                    break;

                case 2:

                    choosinBlood = "BP";

                    break;
                case 3:

                    choosinBlood = "BN";

                    break;

                case 4:

                    choosinBlood = "ABP";

                    break;

                case 5:

                    choosinBlood = "ABN";

                    break;
                case 6:

                    choosinBlood = "OP";

                    break;
                case 7:

                    choosinBlood = "ON";

                    break;
                default :

                    choosinBlood = "AP";
            }

        }

        @Override

        public void onNothingSelected(AdapterView<?> parent) {

        }

    });
        locationSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //use postion value

                switch (position)

                {



                    case 0:

                        choosingLocation = "Akkar";

                        break;

                    case 1:

                        choosingLocation = "Nabatieh";

                        break;
                    case 2:

                        choosingLocation = "Baalback-Hermel";

                        break;
                    case 3:

                        choosingLocation = "Beirut";

                        break;
                    case 4:

                        choosingLocation = "Beqaa";

                        break;

                    case 5:

                        choosingLocation = "Mount Lebanon";

                        break;

                    case 6:

                        choosingLocation = "South Lebanon";

                        break;
                    case 7:

                        choosingLocation = "North Lebanon";

                        break;
                    default :

                        choosingLocation = "Akkar";
                }

            }

            @Override

            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), resutList.class);
                intent.putExtra("blood",choosinBlood);
                intent.putExtra("location", choosingLocation);

                Log.d("///////////////",choosinBlood);
                Log.d("///////////////",choosingLocation);
                startActivity(intent);
            }
        });
    }
}
