package com.mta.busreservation;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.mta.busreservation.R;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Search extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView,t1,t2,textView;
    private int year, month, day;
    private Button bt;
    private ProgressDialog progress;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        dateView = (TextView) findViewById(R.id.textView9);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);


        bt=(Button)findViewById(R.id.button);
        //t2=(TextView)findViewById(R.id.textView8);
        t1=(TextView)findViewById(R.id.textView5);
        textView=(TextView)findViewById(R.id.textView3);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Fragment frg=new CalendarFragment();
                // FragmentManager fragmentManager = getFragmentManager();
                //  fragmentManager.beginTransaction()
                //        .replace(R.id.frame_lo, frg).addToBackStack(null).commit();
                Intent obj = new Intent(Search.this, StationActivity.class);
                startActivityForResult(obj,2);
                //  finish();
            }
        });
        t1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View view){
                Intent intent = new Intent(Search.this, StationActivity.class);
                startActivityForResult(intent,1);
            }
        });
        bt.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View view){
                /*Timer obj=new Timer();
                tt obj1=new tt();
                obj.schedule(obj1,5000);*/
                Intent i = new Intent(Search.this, SearchBus.class);
                i.putExtra("source",textView.getText().toString());
                i.putExtra("designation",t1.getText().toString());
                i.putExtra("date",dateView.getText().toString());
                startActivityForResult(i,3);
            }
        });

    }
    Handler handle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progressDoalog.incrementProgressBy(1);
        }
    };
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_search_drawer, menu);
        return true;
    }*/


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int rcode,int rescode,Intent data)
    {
        if(rcode==1)
        {
            if(rescode== Activity.RESULT_OK)
            {
                String city=data.getStringExtra("city");
                t1.setText(city);
            }
        }
        if(rcode==2)
        {
            if(rescode== Activity.RESULT_OK)
            {
                String city=data.getStringExtra("city");
                textView.setText(city);
            }
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_manage) {
            Intent obj=new Intent(Search.this,track.class);
            startActivity(obj);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
   /* public class tt extends TimerTask {
        public void run()
        {
            Intent i = new Intent(Search.this, SearchBus.class);
            i.putExtra("source",textView.getText().toString());
            i.putExtra("designation",t1.getText().toString());
            i.putExtra("date",dateView.getText().toString());
            startActivityForResult(i,3);

        }
    }*/
}
