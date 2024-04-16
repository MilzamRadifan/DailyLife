package com.example.dailylife;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface API {
  @GET("todo.php")
  Call<List<RowRv>> getRv();
}

