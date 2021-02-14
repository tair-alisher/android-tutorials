package com.example.appwithbottomnav.models;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DashboardDataInterface {
    @GET("v2/list")
    Call<String> STRING_CALL();
}
