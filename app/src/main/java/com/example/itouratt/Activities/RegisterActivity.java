package com.example.itouratt.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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

    private void startFirebase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void registerUser() {
        EditText name = findViewById(R.id.formName);
        EditText email = findViewById(R.id.formEmail);
        EditText password = findViewById(R.id.formPassword);
        UserDomain user = new UserDomain(UUID.randomUUID().toString(),
                                            name.getText().toString(),
                                            email.getText().toString(),
                                            password.getText().toString());
        databaseReference.child("user").child(user.getUUID()).setValue(user);
        name.setText(null);
        email.setText(null);
        Toast.makeText(this, "Usuário registrado com sucesso!", Toast.LENGTH_SHORT).show();

    }


    public void loginActivity(View view) {
        Intent in = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(in);
    }

}
