package com.codewithdeva.retrfitrecycler2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<modle> modles;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        modles=new ArrayList<>();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

        Call<List<modle>> call=retrofitInterface.getmodle();

        call.enqueue(new Callback<List<modle>>() {
            @Override
            public void onResponse(Call<List<modle>> call, Response<List<modle>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Responce Failed", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Responce Success", Toast.LENGTH_SHORT).show();

                    List<modle> modles= response.body();
                     adapter=new Adapter(MainActivity.this,modles);
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<List<modle>> call, Throwable t) {

            }
        });
    }
}