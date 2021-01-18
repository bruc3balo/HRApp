package com.example.hrapp.employees.advance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.example.hrapp.R;

public class EmployeeAdvances extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_advances);

        Toolbar advancesTb = findViewById(R.id.advancesTb);
        setSupportActionBar(advancesTb);

        advancesTb.setNavigationOnClickListener(v -> finish());
    }
}