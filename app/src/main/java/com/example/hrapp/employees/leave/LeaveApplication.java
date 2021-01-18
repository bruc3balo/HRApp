package com.example.hrapp.employees.leave;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.example.hrapp.R;

public class LeaveApplication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_application);

        Toolbar leaveTb = findViewById(R.id.leaveTb);
        setSupportActionBar(leaveTb);
        leaveTb.setNavigationOnClickListener(v -> finish());

    }
}