package com.example.hrapp.admin.applications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.example.hrapp.R;

public class AdminApplications extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_applications);

        Toolbar adminApplicationsTb = findViewById(R.id.adminApplicationsTb);
        setSupportActionBar(adminApplicationsTb);
        adminApplicationsTb.setNavigationOnClickListener(v -> finish());
    }
}