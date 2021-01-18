package com.example.hrapp.admin.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hrapp.R;
import com.example.hrapp.models.Models;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class AdminTicketRvAdapter extends RecyclerView.Adapter<AdminTicketRvAdapter.ViewHolder> {

    private LinkedList<Models.Tickets> list;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context mContext;


    public AdminTicketRvAdapter(Context context, LinkedList<Models.Tickets> list) {
        this.mInflater = LayoutInflater.from(context);
        this.list = list;
        this.mContext = context;
    }


    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.admin_ticket_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ticketUser.setText(list.get(position).getUserName());
        holder.ticketContent.setText(list.get(position).getTicketContent());
        holder.ticketPostedAt.setText(list.get(position).getDateCreatedAt());
        holder.ticketSolvedAt.setText(list.get(position).getDateSolvedAt());
        holder.ticketComments.setText("Status and Comments");
        holder.ticketComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Comments and solve", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView ticketUser, ticketContent, ticketPostedAt, ticketSolvedAt, ticketComments;

        ViewHolder(View itemView) {
            super(itemView);

            ticketUser = itemView.findViewById(R.id.ticketUser);
            ticketContent = itemView.findViewById(R.id.ticketContent);
            ticketPostedAt = itemView.findViewById(R.id.ticketPostedAt);
            ticketSolvedAt = itemView.findViewById(R.id.ticketSolvedAt);
            ticketComments = itemView.findViewById(R.id.ticketComments);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }


    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }


    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}