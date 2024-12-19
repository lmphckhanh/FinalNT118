package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.ImageView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.example.afinal.R;
import com.example.afinal.SignInActivity;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;


public class SignUpActivity extends AppCompatActivity {

    private EditText edtname,edtemail,edtpass,edtpassconf;
    private Button button7;
    private CheckBox checkBox;
    private FirebaseAuth mAuth;
    private ImageView imgback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sign_up);

        mAuth = FirebaseAuth.getInstance();
        imgback = findViewById(R.id.imgback);
        edtname = findViewById(R.id.edtname);
        edtemail = findViewById(R.id.edtemail);
        edtpass = findViewById(R.id.edtpass);
        edtpassconf = findViewById(R.id.edtpassconf);

        button7 = findViewById(R.id.button7);
        checkBox = findViewById(R.id.checkBox);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            register();
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quay lại màn hình Login
                Intent intent = new Intent(SignUpActivity.this,WelcomeActivity.class);
                startActivity(intent);
                finish(); // Kết thúc Activity hiện tại
            }
        });

    }

    private void register() {
        String name,email,password,passwordconf;
        CheckBox checkbox = findViewById(R.id.checkBox);

        name = edtname.getText().toString().trim();
        email = edtemail.getText().toString().trim();
        password = edtpass.getText().toString().trim();
        passwordconf = edtpassconf.getText().toString().trim();

        if(name.isEmpty() || email.isEmpty() || password.isEmpty() || passwordconf.isEmpty()){
            if(name.isEmpty()){
                edtname.setError("Name is required");
            }
            if(email.isEmpty()){
                edtemail.setError("Email is required");
                }
            if(password.isEmpty()){
                edtpass.setError("Password is required");
            }
            if(passwordconf.isEmpty()){
                edtpassconf.setError("Confirm Password is required");
            }
        }
        else if (!email.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$")) {
            edtemail.setError("Please enter a valid Gmail address");
        }
        else if(!password.equals(passwordconf)){
            edtpassconf.setError("Password does not match");
        } else if (!checkbox.isChecked()) {
            Toast.makeText(this, "You must agree to the terms and conditions", Toast.LENGTH_SHORT).show();
        }
        else{
    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
                FirebaseUser user = mAuth.getCurrentUser();
                if (user != null) {
                    // Cập nhật tên hiển thị
                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                            .setDisplayName(name)
                            .build();

                    user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> profileTask) {
                            if (profileTask.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "Failed to update profile", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            } else {
                Toast.makeText(getApplicationContext(), "Registration Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    });
    }
        }
}

