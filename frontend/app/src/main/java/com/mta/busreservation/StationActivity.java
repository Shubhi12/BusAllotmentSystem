package com.mta.busreservation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mta.busreservation.R;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StationActivity extends AppCompatActivity {

    ListView lv;
    Thread t;
    String[] states;
    ArrayAdapter<String> aa1;
    ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv = (ListView) findViewById(R.id.listView);
        pbar = (ProgressBar) findViewById(R.id.progressBar1);
        if (isNetworkConnected()) {
            t = new Thread() {
                public void run() {
                    getstates();
                }
            };
            t.start();

        } else {
        Toast.makeText(StationActivity.this,"No Internet Connection",Toast.LENGTH_LONG ).show();
        }
    }
    public void getstates() {
        httpconnection obj = new httpconnection();
        List<BasicNameValuePair> l1 = new ArrayList<BasicNameValuePair>();
        l1.add(new BasicNameValuePair("name", "name"));
        final String result = obj.get_httpvalue("http://www.saloni.3eeweb.com/Bus/get_states.php", l1, getApplicationContext());

        /* *********** json parsing *************** */

        JSONArray jArray;
        try {
            jArray = new JSONArray(result);
            JSONObject json_data = null;

            final int length = jArray.length();
            states = new String[length];

            int j = 0;
            for (int i = 0; i < length; i++) {
                json_data = jArray.getJSONObject(i);
                states[i] = json_data.getString("states");

            }
        } catch (Exception e) {
        }
        runOnUiThread(new Runnable() {

            public void run() {
                //Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                aa1 = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_item_1, states);
                lv.setAdapter(aa1);
                pbar.setVisibility(View.GONE);
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String res = lv.getItemAtPosition(position).toString();

                Intent obj = new Intent(StationActivity.this, Search.class);
                obj.putExtra("city", res);
                setResult(Activity.RESULT_OK, obj);
                finish();
            }
        });



}
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_search_drawer, menu);
        return true;
    }

}
