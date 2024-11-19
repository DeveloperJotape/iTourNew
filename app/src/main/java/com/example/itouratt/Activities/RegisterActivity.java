package com.example.itouratt.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.itouratt.Domains.UserDomain;
import com.example.itouratt.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    FirebaseAuth auth;
    FirebaseFirestore firestore;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firestore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Criar sua conta");

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = binding.formName.getText().toString();
                String email = binding.formEmail.getText().toString();
                String password = binding.formPassword.getText().toString();

                if(name.isEmpty()) {
                    binding.formName.setError("O campo nome não pode estar em branco");
                } else if(email.isEmpty()) {
                    binding.formEmail.setError("O campo email não pode estar em branco");
                } else if(password.isEmpty()){
                    binding.formPassword.setError("O campo senha não pode estar em branco");
                } else {
                    auth.createUserWithEmailAndPassword(
                                binding.formEmail.getText().toString(),
                                binding.formPassword.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    UserDomain user = new UserDomain(name, email, password);
                                    String id = task.getResult().getUser().getUid();

                                    firestore.collection("users").document().set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            if(task.isSuccessful()) {
                                                progressDialog.dismiss();
                                                Toast.makeText(RegisterActivity.this, "Usuário registrado com sucesso", Toast.LENGTH_SHORT).show();
                                            }

                                        }
                                    });
                                }
                            });
                }

            }
        });

    }

    public void loginActivity(View view) {
        Intent in = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(in);
    }

}
