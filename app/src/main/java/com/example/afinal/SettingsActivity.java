package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private LinearLayout linearLayoutAccount;
    private LinearLayout linearLayoutLanguage;
    private TextView textViewAccount;
    private TextView textViewLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        // Ánh xạ các phần tử giao diện
        linearLayoutAccount = findViewById(R.id.linearLayout);
        linearLayoutLanguage = findViewById(R.id.linearLayout2);
        textViewAccount = findViewById(R.id.tvGoToDashboard);
        textViewLanguage = findViewById(R.id.tvGoToChooseLan);

        // Sự kiện click vào phần Account và Login
        linearLayoutAccount.setOnClickListener(v -> {
            // Mở màn hình Account và Login
            Intent intent = new Intent(SettingsActivity.this, accandlogActivity.class);
            startActivity(intent);
        });

        // Sự kiện click vào phần Language
        linearLayoutLanguage.setOnClickListener(v -> {
            // Mở màn hình chọn ngôn ngữ
            Intent intent = new Intent(SettingsActivity.this, ChooseLanActivity.class);
            startActivity(intent);
        });

        // Có thể thêm các sự kiện khác cho các phần tử khác nếu cần
    }
}
