package com.example.hrapp.employees.timetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.example.hrapp.R;

public class EmployeeTimetable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_timetable);

        Toolbar timeTableTb = findViewById(R.id.timeTableTb);
        setSupportActionBar(timeTableTb);

        timeTableTb.setNavigationOnClickListener(v -> finish());
    }
}