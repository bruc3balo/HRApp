package com.example.hrapp.admin.tickets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.hrapp.R;
import com.example.hrapp.admin.adapter.AdminTicketRvAdapter;
import com.example.hrapp.models.Models;

import java.util.Collections;
import java.util.LinkedList;

public class AdminTickets extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private final LinkedList<Models.Tickets> ticketList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_tickets);

        Toolbar adminTicketsTb = findViewById(R.id.adminTicketsTb);
        setSupportActionBar(adminTicketsTb);
        adminTicketsTb.setNavigationOnClickListener(v -> finish());

        CheckBox low = findViewById(R.id.lowBox);
        low.setOnCheckedChangeListener(this);
        CheckBox mid = findViewById(R.id.midBox);
        mid.setOnCheckedChangeListener(this);
        CheckBox high = findViewById(R.id.highBox);
        high.setOnCheckedChangeListener(this);

        RecyclerView adminTicketsRv = findViewById(R.id.adminTicketsRv);
        adminTicketsRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        AdminTicketRvAdapter adminTicketRvAdapter = new AdminTicketRvAdapter(this, ticketList);
        adminTicketsRv.setAdapter(adminTicketRvAdapter);

        populateTickets(adminTicketRvAdapter);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            default:break;

            case R.id.lowBox:
                if (isChecked) {
                    Toast.makeText(this, "showing low", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "no low", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.midBox:
                if (isChecked) {
                    Toast.makeText(this, "showing mid", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "no mid", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.highBox:
                if (isChecked) {
                    Toast.makeText(this, "showing high", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "no high", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void populateTickets(AdminTicketRvAdapter adminTicketRvAdapter) {
        TicketsViewModel ticketsViewModel = new ViewModelProvider(this).get(TicketsViewModel.class);
        ticketsViewModel.getTicketsList().observe(this, tickets -> {
            ticketList.clear();
            ticketList.addAll(Collections.singleton(tickets));
            adminTicketRvAdapter.notifyDataSetChanged();
        });
    }
}