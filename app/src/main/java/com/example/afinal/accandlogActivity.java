package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.LinearLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class accandlogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.account_and_login);

        Button logout = findViewById(R.id.logout);

        logout.setOnClickListener(v -> {
            // Đăng xuất khỏi Firebase
            FirebaseAuth.getInstance().signOut();

            // Chuyển sang SignInActivity
            Intent intent = new Intent(accandlogActivity.this, SignInActivity.class);
            startActivity(intent);

            // Kết thúc Activity hiện tại
            finish();
        });


        ImageView imageView = findViewById(R.id.imageView7);

        // Đặt sự kiện click cho ImageView
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khi ImageView được nhấn, chuyển sang SecondActivity
                Intent intent = new Intent(accandlogActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout linearLayout = findViewById(R.id.linearLayout);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khi LinearLayout được nhấn, chuyển sang ChangepassActivity
                Intent intent = new Intent(accandlogActivity.this, accountinfo.class);
                startActivity(intent);
            }
        });

        LinearLayout linearLayout1 = findViewById(R.id.linearLayout1);

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khi LinearLayout được nhấn, chuyển sang ChangepassActivity
                Intent intent = new Intent(accandlogActivity.this, accoptionActivity.class);
                startActivity(intent);
            }
        });
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment); // fragment_container là ID của layout chứa fragment
        transaction.addToBackStack(null); // Cho phép quay lại Fragment trước đó
        transaction.commit();
    }
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}