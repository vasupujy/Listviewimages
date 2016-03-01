package com.example.welcome.listviewimages;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.Field;

public class MainActivity extends AppCompatActivity {
    public static final String ROOT_URL = "https://api.stackexchange.com";
int currentpage=1;
    //Strings to bind with intent will be used to send data to other activity
    private ListView listView;
    boolean webserviceflag=false;
    private CustomAdapter adapter;
    //List of type userList this list will store type User which is our data model
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);

        adapter = new CustomAdapter(this);

        listView.setAdapter(adapter);
        //Calling the method that will fetch data
        getBooks();

        //Setting onItemClickListener to listview
        //   listView.setOnItemClickListener(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void getBooks() {
        //While the app fetched data we are displaying a progress dialog
        final ProgressDialog loading = ProgressDialog.show(this, "Fetching Data", "Please wait...", false, false);

        //Creating a rest adapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL)
                .build();

        //Creating an object of our api interface
        UserAPI api = adapter.create(UserAPI.class);

        //Defining the method
        webserviceflag=true;
        api.getUser(currentpage,20, "desc", "reputation", "stackoverflow", new Callback<UserResponse>() {
            @Override
            public void success(UserResponse userResponse, Response response) {
                loading.dismiss();
                webserviceflag=false;
                //Storing the data in our list
                userList = userResponse.getItems();

                //Calling a method to show the list
                showList();
                currentpage++;
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
                webserviceflag=false;
                loading.dismiss();
            }
        });

    }

    //Our method to show list
    private void showList() {

        adapter.addAll(userList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User obj = adapter.getItem(position);
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("Detail", obj);
                startActivity(i);
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if ((listView.getLastVisiblePosition() == (adapter.getCount() - 1))&&webserviceflag==false){
                   // Toast.makeText(MainActivity.this,"vasu",Toast.LENGTH_LONG).show();
                    getBooks();

                }

            }
        });
        //Creating an array adapter for list view
        //  ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.simple_list, items);

        //Setting adapter to listview
        //  listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
