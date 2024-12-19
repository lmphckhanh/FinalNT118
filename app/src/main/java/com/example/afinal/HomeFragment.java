package com.example.afinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeFragment extends Fragment {
    private TextView txtname1;
    private ImageView imgAccount;

    public HomeFragment() {
        // Public empty constructor
    }

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.dashboard, container, false);

        // Ánh xạ các thành phần
        txtname1 = view.findViewById(R.id.txtname1);
        imgAccount = view.findViewById(R.id.imgAccount);

        // Lấy dữ liệu người dùng từ Firebase
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String name = user.getDisplayName();
            txtname1.setText(name != null ? name : "Tên không có");
        } else {
            txtname1.setText("Người dùng chưa đăng nhập");
        }

        // Thiết lập sự kiện cho hình ảnh tài khoản
        imgAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });

        return view;
    }

    // Hàm hiển thị PopupMenu
    @SuppressLint("NonConstantResourceId")
    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(getContext(), view);
        popupMenu.getMenuInflater().inflate(R.menu.account_menu, popupMenu.getMenu());

        // Xử lý sự kiện khi chọn các mục trong menu
        popupMenu.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();

            if (id == R.id.menu_account_info) {
                // Chuyển đến màn hình thông tin cá nhân
                Intent accountInfoIntent = new Intent(getContext(), accountinfo.class);
                startActivity(accountInfoIntent);
                return true;
            } else if (id == R.id.menu_logout) {
                // Đăng xuất và quay lại màn hình đăng nhập
                FirebaseAuth.getInstance().signOut();
                Intent logoutIntent = new Intent(getContext(), SignInActivity.class);
                logoutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(logoutIntent);
                return true;
            } else {
                return false;
            }
        });

        popupMenu.show();
    }
}
