package com.example.welcome.listviewimages;

import java.util.List;

/**
 * Created by welcome on 25-02-2016.
 */
public class UserResponse{
 List<User> items;
    boolean has_more;
    int quota_max;

    public List<User> getItems() {
        return items;
    }

    public void setItems(List<User> items) {
        this.items = items;
    }
}
