package com.example.afinal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class accountinfo extends AppCompatActivity {

    TextView txtname, txtemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_information);

        txtname = findViewById(R.id.txtname);
        txtemail = findViewById(R.id.txtemail);

        ImageView imageView = findViewById(R.id.imageView8);

        // Đặt sự kiện click cho ImageView
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khi ImageView được nhấn, chuyển sang SecondActivity
                Intent intent = new Intent(accountinfo.this, accandlogActivity.class);
                startActivity(intent);
            }
        });

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null)
        {
            String name = user.getDisplayName();
            String email = user.getEmail();

            txtname.setText(name != null ? name : "Tên không có");
            txtemail.setText(email != null ? email : "Email không có");
        } else {
            txtname.setText("Người dùng chưa đăng nhập");
            txtemail.setText("");
        }
    }
}