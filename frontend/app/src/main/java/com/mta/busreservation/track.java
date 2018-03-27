package com.mta.busreservation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mta.busreservation.R;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class track extends AppCompatActivity {
    EditText et;
    Button b1;
    String longitude,latitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        et=(EditText) findViewById(R.id.editText6);
        b1=(Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t=new Thread()
                {
                    public void run()
                    {
                        getlonglati();
                    }
                };
                t.start();
            }
        });
    }


    public void getlonglati()
    {
        httpconnection obj = new httpconnection();
        List<BasicNameValuePair> l1=new ArrayList<BasicNameValuePair>();


        l1.add(new BasicNameValuePair("busno",et.getText().toString()));
        final String result = obj.get_httpvalue("http://www.saloni.3eeweb.com/Bus/get_lonlat.php", l1, getApplicationContext());



                /* *********** json parsing *************** */
        JSONArray jArray;
        try {
            jArray = new JSONArray(result);
            JSONObject json_data = null;
            final int length = jArray.length();


            int j = 0;
            for (int k = 0; k < length; k++) {
                json_data =jArray.getJSONObject(k);
                longitude=json_data.getString("lon");
                latitude=json_data.getString("lat");

            }

        } catch (Exception e) {
        }
         Intent objt=new Intent(track.this,bustrack.class);
        objt.putExtra("lon",longitude);
        objt.putExtra("lat",latitude);
        startActivity(objt);



    }
}
