package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    public SettingsFragment() {
        // Yêu cầu một constructor công khai rỗng
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate layout cho fragment
        View rootView = inflater.inflate(R.layout.setting, container, false);

        LinearLayout linearLayout = rootView.findViewById(R.id.linearLayout);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khi LinearLayout được nhấn, chuyển sang accandlogActivity
                Intent intent = new Intent(getActivity(), accandlogActivity.class);
                startActivity(intent);
            }
        });


        LinearLayout linearLayout1 = rootView.findViewById(R.id.linearLayout2);

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khi LinearLayout được nhấn, chuyển sang accandlogActivity
                Intent intent = new Intent(getActivity(), ChooseLanActivity.class);
                startActivity(intent);
            }
        });



        return rootView;
    }
}

