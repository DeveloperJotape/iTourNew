package com.example.itouratt.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.itouratt.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
    }

    public void homeActivity(View view) {
        Intent in = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(in);
    }

    public void registerActivity(View view) {
        Intent in = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(in);
    }

}
