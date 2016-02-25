package com.example.welcome.listviewimages;

import com.google.gson.annotations.SerializedName;

/**
 * Created by welcome on 25-02-2016.
 */
public class User {//Variables that are in our json
    private String profile_image;
    private String display_name;
    private int age;
    private Badge badge_counts;
    private String location;
    private String reputation;

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public Badge getBadge_counts() {
        return badge_counts;
    }

    public void setBadge_counts(Badge badge_counts) {
        this.badge_counts = badge_counts;
    }
}
