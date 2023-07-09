package com.example.doddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private EditText etName;
    private EditText etHobby;
    private TextView tvUserName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        etName = view.findViewById(R.id.et_name);
        etHobby = view.findViewById(R.id.et_hobby);
        Button btnSubmit = view.findViewById(R.id.btn_submit);
        tvUserName = view.findViewById(R.id.tv_user_name);

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String hobby = etHobby.getText().toString();
            String userName = name + " (" + hobby + ")";
            tvUserName.setText(userName);
        });

        return view;
    }
}
