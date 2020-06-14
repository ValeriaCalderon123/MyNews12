package com.example.mynews1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaCas;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.*;

import com.example.mynews1.RetApi.Data_Api;
import com.example.mynews1.RetApi.Data_Session;
import com.example.mynews1.model.Session;
import com.example.mynews1.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

   // final Intent conexion = new Intent(this,Index.class);
    private EditText usuarioEdit;
    private EditText passwordEdit;
    private TextView error;
    int bandera=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuarioEdit = findViewById(R.id.usuario);
        passwordEdit = findViewById(R.id.password);
    }

    public void registrarse(View view){
        Intent registro= new Intent(this,RegistroUsuarioActivity.class);
        startActivity(registro);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.buttonLogin:
                userLogin();
        }
    }
    public void userLogin(){
        String username=usuarioEdit.getText().toString().trim();
        String password=passwordEdit.getText().toString().trim();
        if (username.isEmpty()) {
            usuarioEdit.setError("Requieres un usuario");
            usuarioEdit.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            passwordEdit.setError("Requieres una contraseña");
            passwordEdit.requestFocus();
            return;
        }


    }
    public void sesion(View view){
         String userName = usuarioEdit.getText().toString().trim();
         String password = passwordEdit.getText().toString().trim();

        if (userName.isEmpty()) {
            usuarioEdit.setError("Requieres un usuario");
            usuarioEdit.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            passwordEdit.setError("Requieres una contraseña");
            passwordEdit.requestFocus();
            return;
        }


        Retrofit retrofit= new Retrofit.Builder().
                baseUrl("https://mynews2020.herokuapp.com/api/v1/").
                addConverterFactory(GsonConverterFactory.create())
                .build();
        Data_Session data_session=retrofit.create(Data_Session.class);
        Call<Session> call = data_session.getToken();
      //  this.retrofit.login(userName,
        call.enqueue(new Callback<Session>() {
            @Override
            public void onResponse(Call<Session> call, Response<Session> response) {

                if(!response.isSuccessful()){
                   Session session = response.body();

                }

                else{
                    //ShowToast.show(getApplicationContext(),R.string.bad_user);
                }
            }

            @Override
            public void onFailure(Call<Session> call, Throwable t) {
                error.setText(t.getMessage());
            }
        });

        if(bandera==1){
            Intent con= new Intent(this,Index.class);
            startActivity(con);
        }
    }

}
