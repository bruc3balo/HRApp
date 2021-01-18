package com.example.hrapp.employees.appAvailabilities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.example.hrapp.R;

public class ApplicationAvailabilities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_availabilities);

        Toolbar availabilityTb = findViewById(R.id.availabilityTb);
        setSupportActionBar(availabilityTb);

        availabilityTb.setNavigationOnClickListener(v -> finish());
    }
}