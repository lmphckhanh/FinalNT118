package com.example.afinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    private EditText email_input, password_input;
    private Button login_button;
    private FirebaseAuth mAuth;
    private ImageView imgback1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sign_in);

        mAuth = FirebaseAuth.getInstance();
        imgback1 = findViewById(R.id.imgback1);
        email_input = findViewById(R.id.email_input);
        password_input = findViewById(R.id.password_input);
        login_button = findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        imgback1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quay lại màn hình Login
                Intent intent = new Intent(SignInActivity.this,WelcomeActivity.class);
                startActivity(intent);
                finish(); // Kết thúc Activity hiện tại
            }
        });
    }

    private void login() {
        String email, password;
        email = email_input.getText().toString().trim();
        password = password_input.getText().toString().trim();
        if (email.isEmpty() || password.isEmpty()) {
            if (email.isEmpty()) {
                email_input.setError("Email is required");
            }
            if (password.isEmpty()) {
                password_input.setError("Password is required");
            }
        }

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if( task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignInActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
