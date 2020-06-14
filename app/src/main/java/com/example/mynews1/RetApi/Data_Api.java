package com.example.mynews1.RetApi;

import com.example.mynews1.model.User;
import java.util.*;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Data_Api {
    @GET("user")
    Call<List<User>>getUsers();
}
