package com.mta.busreservation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.mta.busreservation.R;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BusBooking extends AppCompatActivity {
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private Button btnDisplay;
    ListView lv;
    Thread t;
    String[] states;
    String[] array;
    Spinner seat;
    ArrayAdapter<String> aa1;
    public static SharedPreferences sf;
    public static SharedPreferences sp;
    EditText email,mobile,fullname,age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sf = getSharedPreferences("BusReservation", MODE_WORLD_READABLE);
        sp = getSharedPreferences("Bus", MODE_WORLD_READABLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_booking);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addListenerOnButton();
        states = getResources().getStringArray(R.array.countries_list);
        seat = (Spinner) findViewById(R.id.editText5);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, states);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seat.setAdapter(dataAdapter);
        seat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                seat.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        email = (EditText) findViewById(R.id.editText);
        mobile = (EditText) findViewById(R.id.editText2);
        fullname = (EditText) findViewById(R.id.editText3);
        age = (EditText) findViewById(R.id.editText4);
        radioSexButton = (RadioButton) findViewById(radioSexGroup.getCheckedRadioButtonId());

    }


    public void addListenerOnButton() {
       radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);
        btnDisplay = (Button) findViewById(R.id.button);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st =seat.getSelectedItem().toString();
                int pos =seat.getSelectedItemPosition();
                if (pos !=0) {
                    int SelectedId = radioSexGroup.getCheckedRadioButtonId();
                    radioSexButton = (RadioButton) findViewById(SelectedId);
                    // Toast.makeText(BusBooking.this,
                    //  radioSexButton.getText(), Toast.LENGTH_SHORT).show();
                    if (checkValidation()) {
                        t = new Thread() {
                            public void run() {
                                postdetail();
                            }
                        };
                        t.start();
                        Toast.makeText(BusBooking.this, "ThankYou", Toast.LENGTH_SHORT).show();

                       /* SharedPreferences.Editor editor = sp.edit();
                        editor.putString("email",email.toString());
                        editor.commit();*/
                        Intent obj = new Intent(BusBooking.this, SeatDetail.class);
                        obj.putExtra("email",email.getText().toString());
                        startActivityForResult(obj,2);
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Please Select Seat" , Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void postdetail() {
        String id1;
        httpconnection obj = new httpconnection();
        List<BasicNameValuePair> l1 = new ArrayList<BasicNameValuePair>();
        Intent i=getIntent();
        final String source= i.getStringExtra("id");
        l1.add(new BasicNameValuePair("id", source));

        l1.add(new BasicNameValuePair("date",sf.getString("date","null")));
       // l1.add(new BasicNameValuePair("id",sf.getString("id","null")));
        l1.add(new BasicNameValuePair("seat",seat.getSelectedItem().toString()));
        l1.add(new BasicNameValuePair("email", email.getText().toString()));
        l1.add(new BasicNameValuePair("mobile", mobile.getText().toString()));
        l1.add(new BasicNameValuePair("name", fullname.getText().toString()));
        l1.add(new BasicNameValuePair("age", age.getText().toString()));
         l1.add(new BasicNameValuePair("radiosexgroup", radioSexButton.getText().toString()));
       // Toast.makeText(BusBooking.this, date.toString(), Toast.LENGTH_SHORT).show();
        final String result = obj.get_httpvalue("http://www.saloni.3eeweb.com/Bus/usar_details.php", l1, getApplicationContext());
        JSONArray jArray;
        try {
            JSONObject json_data = null;
            jArray = new JSONArray(result);
            final int length = jArray.length();
            array = new String[length];
            int j = 0;
            for (int k = 0; k < length; k++) {
                json_data =jArray.getJSONObject(k);
                SearchResults sr1 = new SearchResults();
                id1=json_data.getString("id");
                Toast.makeText(getApplicationContext(),id1 , Toast.LENGTH_SHORT).show();
               // tv.setText(String.valueOf(json_data.getString("id")));
            }

        } catch (Exception e) {
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
               // seat.setText("");
                email.setText("");
                mobile.setText("");
                fullname.setText("");
                age.setText("");
                //radioSexButton.setText("");
            }
        });
    }

    private boolean checkValidation() {
        boolean ret = true;

        if (!Validation.hasText(fullname)) ret = false;
       // if (!Validation.hasText(seat)) ret = false;
        if (!Validation.isEmailAddress(email,true)) ret = false;
        if (!Validation.isPhoneNumber(mobile,true)) ret = false;
        if (!Validation.hasText(age)) ret = false;


        return ret;
    }

}