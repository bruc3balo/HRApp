package com.example.hrapp.employees.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hrapp.R;
import com.example.hrapp.models.Models;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class TicketRvAdapter extends RecyclerView.Adapter<TicketRvAdapter.ViewHolder> {

    private final LinkedList<Models.Tickets> list;
    private ItemClickListener mClickListener;
    private final Context mContext;


    public TicketRvAdapter(Context context, LinkedList<Models.Tickets> list) {
        this.list = list;
        this.mContext = context;
    }


    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_ticket_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ticketUser.setText(list.get(position).getUserName());
        holder.ticketContent.setText(list.get(position).getTicketContent());
        holder.ticketPostedAt.setText(list.get(position).getDateCreatedAt());
        holder.ticketSolvedAt.setText(list.get(position).getDateSolvedAt());
        if (list.get(position).getTicketComments() != null) {
            holder.ticketComments.setText("Comments".concat("(").concat(String.valueOf(list.get(position).getTicketComments().size())).concat(")"));
        } else {
            holder.ticketComments.setText("No comments");
        }
        holder.ticketComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Comments", Toast.LENGTH_SHORT).show();
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