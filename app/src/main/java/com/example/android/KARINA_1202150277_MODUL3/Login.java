package com.example.android.KARINA_1202150277_MODUL3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.User);
        password = (EditText) findViewById(R.id.Pass);
    }

    public void onLogin(View view) {
        if (username.getText().toString().equals("EAD") && password.getText().toString().equals("MOBILE")){
            Toast.makeText(getApplicationContext(),"LOGIN SUCCESS", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"LOGIN FAILED", Toast.LENGTH_SHORT).show();
        }
    }
}
