package com.mta.busreservation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mta.busreservation.R;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SearchBus extends AppCompatActivity {
    ListView lv;
    Thread t;
    String[] states;
    ArrayAdapter<String> aa1;
    String[] departure_time;
    String[] arrival_time;
    String[] agency;
    String[] seat;
    String[] categary;
    String[] bus_no;
    String[] bus_day;
    String[] range;
    String[] price;
    String id1;
    public static SharedPreferences sf;
    final ArrayList<SearchResults> resultss = new ArrayList<SearchResults>();
    ProgressBar pbar;
    ProgressDialog progressDoalog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sf = getSharedPreferences("BusReservation", MODE_WORLD_READABLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv = (ListView) findViewById(R.id.listView2);
        pbar = (ProgressBar) findViewById(R.id.progressBar1);
        if (isNetworkConnected()) {
            t = new Thread() {
                public void run() {
                    getstates();
                }
            };
            t.start();

        } else {
            Toast.makeText(SearchBus.this, "No Internet Connection", Toast.LENGTH_LONG).show();
        }
    }
    Handler handle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progressDoalog.incrementProgressBy(1);
        }
    };

    public void getstates()
    {
        httpconnection obj = new httpconnection();
        List<BasicNameValuePair> l1=new ArrayList<BasicNameValuePair>();
        Intent i=getIntent();
        final String source= i.getStringExtra("source");
        final String destination= i.getStringExtra("designation");
        final String date= i.getExtras().getString("date");
        l1.add(new BasicNameValuePair("source", source));
        l1.add(new BasicNameValuePair("destination",destination));
        l1.add(new BasicNameValuePair("date",date));
        final String result = obj.get_httpvalue("http://www.saloni.3eeweb.com/Bus/route.php", l1, getApplicationContext());


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),date,Toast.LENGTH_LONG).show();
            }
        });
                /* *********** json parsing *************** */

        JSONArray jArray;
        try {
            jArray = new JSONArray(result);
            JSONObject json_data = null;
            final int length = jArray.length();


            int j = 0;
            for (int k = 0; k < length; k++) {
                json_data =jArray.getJSONObject(k);
                SearchResults sr1 = new SearchResults();
                sr1.setTimimg(json_data.getString("departure_time")+" "+json_data.getString("arrival_time"));
                sr1.setAgency(json_data.getString("agency"));
                sr1.setSeat(json_data.getString("seats"));
                sr1.setCategary(json_data.getString("categary"));
                sr1.setBus_no(json_data.getString("bus_no"));
                sr1.setRange(json_data.getString("range"));
                sr1.setPrice(json_data.getString("price"));
                sr1.setbus_day(json_data.getString("day"));
                id1 = (json_data.getString("id"));
                sr1.setid(id1);
                resultss.add(sr1);
            }
            SharedPreferences.Editor editor = sf.edit();
            editor.putString("date",date.toString());
            //editor.putString("id",id1.toString() );
            editor.commit();
        } catch (Exception e) {
        }

        runOnUiThread(new Runnable() {

            public void run() {
                //Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                lv.setAdapter(new MyCustomBaseAdapter(getApplicationContext(), resultss));
                pbar.setVisibility(View.GONE);
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               SearchResults s= (SearchResults)lv.getItemAtPosition(position);
                String res = lv.getItemAtPosition(position).toString();
              Intent obj = new Intent(SearchBus.this, BusBooking.class);
               obj.putExtra("id",s.getid());
                startActivity(obj);
              // setResult(Activity.RESULT_OK, obj);
              //  finish();
            }
        });


    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }


}
