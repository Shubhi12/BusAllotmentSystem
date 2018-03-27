package com.mta.busreservation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mta.busreservation.R;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SeatDetail extends AppCompatActivity {
    Button btn;
    Thread t;
    TextView tv;
    String[] array;
    public static SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sp = getSharedPreferences("Bus", MODE_WORLD_READABLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv=(TextView) findViewById(R.id.textView);
        t = new Thread() {
            public void run() {
                getstates();
            }
        };
        t.start();
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeatDetail.this,PaymentFragment.class);
                startActivity(intent);
            }
        });
    }

    public void getstates() {
        httpconnection obj = new httpconnection();
        List<BasicNameValuePair> l1 = new ArrayList<BasicNameValuePair>();
        Intent i=getIntent();
        final String email= i.getStringExtra("email");
        l1.add(new BasicNameValuePair("email", email));
       // l1.add(new BasicNameValuePair("email",sp.getString("email","null")));
        //Toast.makeText(getApplicationContext(), email ,Toast.LENGTH_LONG).show();
        final String result = obj.get_httpvalue("http://www.saloni.3eeweb.com/Bus/manage_booking.php", l1, getApplicationContext());
        JSONArray jArray;
        try {
            jArray = new JSONArray(result);
            JSONObject json_data = null;
            final int length = jArray.length();
            array = new String[length];
            int j = 0;
            for (int k = 0; k < length; k++) {
                json_data =jArray.getJSONObject(k);
                SearchResults sr1 = new SearchResults();
               // String id=(json_data.getString("id"));
                tv.setText(String.valueOf(json_data.getString("id")));
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("id1",tv.getText().toString());
                //editor.putString("id",id1.toString() );
                editor.commit();
            }
        } catch (Exception e) {
        }
    }

}
