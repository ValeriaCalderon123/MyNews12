package com.example.mynews1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class RegistroUsuarioActivity extends AppCompatActivity {
    private EditText usuarioEdit;
    private EditText nombreEdit;
    private EditText apellidoEdit;
    private EditText emailEdit;
    private EditText passwordEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        usuarioEdit = findViewById(R.id.usuario);
        nombreEdit = findViewById(R.id.nombre);
        apellidoEdit = findViewById(R.id.apellido);
        emailEdit = findViewById(R.id.email);
        passwordEdit = findViewById(R.id.password);
    }
    public void regresar(View view){
        Intent regresar= new Intent(this, MainActivity.class);
        startActivity(regresar);
    }

    public void registrarme(View view){
        String user = usuarioEdit.getText().toString().trim();
        String firstname = nombreEdit.getText().toString().trim();
        String lastname = apellidoEdit.getText().toString().trim();
        String email = emailEdit.getText().toString().trim();
        String password = passwordEdit.getText().toString().trim();


        if (user.isEmpty()) {
            usuarioEdit.setError("Requieres un usuario");
            usuarioEdit.requestFocus();
            return;
        }
        if (firstname.isEmpty()) {
            nombreEdit.setError("Requieres un nombre");
            nombreEdit.requestFocus();
            return;
        }
        if (lastname.isEmpty()) {
            apellidoEdit.setError("Requieres un apellido");
            apellidoEdit.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            emailEdit.setError("Requieres un email");
            emailEdit.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            passwordEdit.setError("Requieres una contraseña");
            passwordEdit.requestFocus();
            return;
        }
    }

}
