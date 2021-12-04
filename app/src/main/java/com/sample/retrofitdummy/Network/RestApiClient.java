package com.sample.retrofitdummy.Network;

import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiClient {


    private static Retrofit retrofit = null;

    // dummy json url
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

     public static Retrofit getClient(){
         OkHttpClient client = new OkHttpClient.Builder()
                 .connectTimeout(100,TimeUnit.SECONDS)
                 .readTimeout(100,TimeUnit.SECONDS).build();

         if (retrofit == null){
             retrofit = new Retrofit.Builder()
                     .baseUrl(BASE_URL)
                     .client(client)
                     .addConverterFactory(GsonConverterFactory.create(new Gson()))
                     .build();
         }
         return retrofit;
     }


}
