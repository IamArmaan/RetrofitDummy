package com.sample.retrofitdummy.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.sample.retrofitdummy.Adapter.UserAdapter;
import com.sample.retrofitdummy.Interface.ApiService;
import com.sample.retrofitdummy.Network.RestApiClient;
import com.sample.retrofitdummy.Pojo.UserResponse;
import com.sample.retrofitdummy.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    LinearLayoutManager linearLayoutManager ;
    UserAdapter userAdapter;
    ArrayList<UserResponse> userArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_address);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        userArrayList = new ArrayList<>();

        ApiService apiService = RestApiClient.getClient().create(ApiService.class);
        Call<List<UserResponse>> call = apiService.usersList();
        call.enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {
                List<UserResponse> userResponses = response.body();

                userArrayList.addAll(userResponses);
                userAdapter = new UserAdapter(getApplicationContext(),userArrayList,R.layout.user_list);
                recyclerView.setAdapter(userAdapter);


            }

            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable t) {
                Log.e("message",""+t.getMessage());
            }
        });


    }
}