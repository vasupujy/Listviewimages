package com.example.welcome.listviewimages;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by welcome on 25-02-2016.
 */
public class CustomAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<User> userItems;

    Context context;
    private String[] imageUrls;
   // ImageLoader imageLoader = AppController.getInstance().getImageLoader();


    public CustomAdapter(MainActivity activity) {
        this.activity = activity;
        this.userItems = new ArrayList<>();
    }

    public void addAll(List<User> users){
        userItems.addAll(users);
        notifyDataSetChanged();
    }



    @Override
    public int getCount() {
        return userItems.size();
    }

    @Override
    public User getItem(int position) {
        return userItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.content_main, null);

        TextView title = (TextView) convertView.findViewById(R.id.display_name);
        ImageView iv  = (ImageView)convertView.findViewById(R.id.thumbnail);
        TextView bronze = (TextView)convertView.findViewById(R.id.location);
        TextView silver = (TextView)convertView.findViewById(R.id.location1);
        TextView gold = (TextView)convertView.findViewById(R.id.location2);
        User user = userItems.get(position);
        title.setText(user.getDisplay_name());
        Picasso.with(activity).load(user.getProfile_image()).into(iv);
        Badge badge = user.getBadge_counts();
        bronze.setText(badge.getBronze());
        silver.setText(badge.getSilver());
        gold.setText(badge.getGold());


        return convertView;
    }
}
