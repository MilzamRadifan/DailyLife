package com.example.dailylife;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {
  private RecyclerView recyclerView;
  private RowRvAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recyclerView = findViewById(R.id.listRv);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://mgm.ub.ac.id/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    API api = retrofit.create(API.class);
    Call<List<RowRv>> call = api.getRv();
    call.enqueue(new Callback<List<RowRv>>() {
      @Override
      public void onResponse(Call<List<RowRv>> call, Response<List<RowRv>> response) {
        if (!response.isSuccessful()) {
          return;
        }

        List<RowRv> todo = response.body();
        adapter = new RowRvAdapter(todo);
        recyclerView.setAdapter(adapter);
      }

      @Override
      public void onFailure(Call<List<RowRv>> call, Throwable t) {
        Toast.makeText(MainActivity2.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
      }
    });
  }
}