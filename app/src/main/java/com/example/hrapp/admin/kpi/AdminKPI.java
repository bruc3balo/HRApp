package com.example.hrapp.admin.kpi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.example.hrapp.R;

public class AdminKPI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_k_p_i);

        Toolbar kpiTb = findViewById(R.id.kpiTb);
        setSupportActionBar(kpiTb);
        kpiTb.setNavigationOnClickListener(v -> finish());
    }
}