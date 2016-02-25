package com.example.welcome.listviewimages;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by welcome on 25-02-2016.
 */
public interface UserAPI {
    /*Retrofit get annotation with our URL
      And our method that will return us the list ob User
   */

    // /2.2/users?page=10&order=desc&sort=reputation&site=stackoverflow


    @GET("/2.2/users?")
    void getUser(@Query("page") int pageSize,
                 @Query("order") String order,
                 @Query("sort") String sort,
                 @Query("site") String site,
                 Callback<UserResponse> response);

}
