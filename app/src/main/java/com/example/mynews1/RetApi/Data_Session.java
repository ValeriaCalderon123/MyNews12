package com.example.mynews1.RetApi;

import com.example.mynews1.model.Session;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Data_Session {
    @GET("auth")
    Call<Session> getToken();
}
