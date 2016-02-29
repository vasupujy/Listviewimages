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

public class SecondActivity extends AppCompatActivity {
    Toolbar toolbar2;
    ImageView thumb;
    TextView txtuser, usertype, location, location2, location3, display_Add3, display_Add2, display_Add4, display_Add5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        usertype = (TextView) findViewById(R.id.usertype);
        location = (TextView) findViewById(R.id.location);
        location2 = (TextView) findViewById(R.id.location2);
        location3 = (TextView) findViewById(R.id.location1);
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
        Picasso.with(SecondActivity.this).load(user.getProfile_image()).into(th);
        String cr = Double.toString(user.getCreation_date());
        // display_Add2.setText(user.getLocation());
        display_Add3.setText(cr);
        //   display_Add4.setText(user.getWebsite_url());
        if (user.getWebsite_url().equals("") || user.getWebsite_url().equals(null)) {
            display_Add4.setVisibility(View.GONE);
        } else {
            display_Add4.setText(user.getWebsite_url());
        }
      ;
        if (TextUtils.isEmpty(user.getLocation())) {
            display_Add2.setVisibility(View.GONE);
        } else {
            display_Add2.setText(user.getLocation());
        }

        String cr2 = Double.toString(user.getLast_access_date());
        display_Add5.setText(cr2);


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
