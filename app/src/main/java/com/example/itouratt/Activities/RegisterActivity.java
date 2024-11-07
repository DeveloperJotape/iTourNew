package com.example.itouratt.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.itouratt.Domains.UserDomain;
import com.example.itouratt.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        startFirebase();
    }

    public void startFirebase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void registerUser() {
        EditText userName = findViewById(R.id.formName);
        EditText userEmail = findViewById(R.id.formEmail);
        EditText userPassword = findViewById(R.id.formPassword);

        UserDomain usuario = new UserDomain(UUID.randomUUID().toString(),
                userName.getText().toString(),
                userEmail.getText().toString(),
                userPassword.getText().toString());
        databaseReference.child("usuario").child(usuario.getUUID()).setValue(usuario);
        userName.setText(null);
        userEmail.setText(null);
        userPassword.setText(null);
        Toast.makeText(this, "Usuário criado com sucesso!", Toast.LENGTH_SHORT).show();
    }

    public void loginActivity(View view) {
        Intent in = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(in);
    }

}
