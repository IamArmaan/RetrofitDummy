package com.sample.retrofitdummy.Interface;

import com.sample.retrofitdummy.Pojo.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/users")
    Call<List<UserResponse>> usersList();

}
