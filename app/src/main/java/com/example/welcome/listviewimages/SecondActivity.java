package com.example.welcome.listviewimages;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class SecondActivity extends AppCompatActivity {
    Toolbar toolbar2;
    ImageView thumb;
    TextView txtuser,reputation, usertype, location, location2, location3, display_Add3, display_Add2, display_Add4, display_Add5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        usertype = (TextView) findViewById(R.id.usertype);
        location = (TextView) findViewById(R.id.location);
        location2 = (TextView) findViewById(R.id.location2);
        location3 = (TextView) findViewById(R.id.location1);
        reputation = (TextView)findViewById(R.id.locations);
        display_Add3 = (TextView) findViewById(R.id.display_Add3);
        display_Add2 = (TextView) findViewById(R.id.display_Add2);
        display_Add5 = (TextView) findViewById(R.id.display_Add5);
        display_Add4 = (TextView) findViewById(R.id.display_Add4);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = this.getIntent();
        User user = (User) intent.getSerializableExtra("Detail");

        //  String name = user.getDisplay_name();
        ImageView th = (ImageView) findViewById(R.id.thumbnail);
        usertype.setText(user.getDisplay_name());
        location.setText(user.getBadge_counts().getGold());
        location2.setText(user.getBadge_counts().getSilver());
        location3.setText(user.getBadge_counts().getBronze());
        reputation.setText(String.valueOf(user.getReputation()));
        Picasso.with(SecondActivity.this).load(user.getProfile_image()).into(th);
        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(user.getCreation_date());
        Calendar mydate = Calendar.getInstance();
        Calendar lastdate = Calendar.getInstance();
        mydate.setTimeInMillis(user.getCreation_date() * 1000);
        lastdate.setTimeInMillis(user.getLast_access_date()*1000);

      long year = mydate.get(Calendar.YEAR);
        long month =mydate.get(Calendar.MONTH);

        long yearl = lastdate.get(Calendar.YEAR);
        long monthl =lastdate.get(Calendar.MONTH);
        long hourl = lastdate.get(Calendar.HOUR_OF_DAY);
        Calendar calendar1 = Calendar.getInstance(TimeZone.getDefault());

        long cYear=calendar1.get(Calendar.YEAR);
        long cHour = calendar1.get(Calendar.HOUR_OF_DAY);


       long cMonth= calendar1.get(Calendar.MONTH);
        long cDay=calendar1.get(Calendar.DAY_OF_MONTH);
      long diffyear = cYear-year;

        long diffmonth = cMonth-month;
        long lsyear = cYear-yearl;
        long lsmonth = cMonth-monthl;
        long diffhour = cHour-hourl;
        display_Add3.setText("Member for"+""+diffyear+"Year"+","+diffmonth+"Month");
        display_Add5.setText("Last seen "+diffhour+"Hour ago");
       // display_Add3.setText(cr);*/




     //   Read more: http://javarevisited.blogspot.com/2012/12/how-to-convert-millisecond-to-date-in-java-example.html#ixzz41cocPC8K
        //   display_Add4.setText(user.getWebsite_url());
        if (user.getWebsite_url().equals("") || user.getWebsite_url().equals(null)) {
            display_Add4.setVisibility(View.GONE);
        } else {
            display_Add4.setText(user.getWebsite_url());
        }

        if (TextUtils.isEmpty(user.getLocation())) {
            display_Add2.setVisibility(View.GONE);
        } else {
            display_Add2.setText(user.getLocation());
        }





      /*  Bundle bundle = getIntent().getExtras();

//Extract the data…
        String stuff = bundle.getString("name");
        txtuser = (TextView)findViewById(R.id.usertype);
        txtuser.setText(stuff);*/
      /*  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
