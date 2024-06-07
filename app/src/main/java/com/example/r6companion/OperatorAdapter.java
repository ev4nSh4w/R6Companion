package com.example.r6companion;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class OperatorAdapter extends RecyclerView.Adapter<OperatorAdapter.OperatorViewHolder> {
    private List<Operator> operators;

    public OperatorAdapter(List<Operator> operators) {
        this.operators = operators;
    }

    @NonNull
    @Override
    public OperatorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.operator_item, parent, false);
        return new OperatorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OperatorViewHolder holder, int position) {
        Operator operator = operators.get(position);
        holder.name.setText(operator.getName());
        holder.details.setText(operator.getRole() + " - " + operator.getUnit());
        holder.description.setText(operator.getDescription());

        Glide.with(holder.itemView.getContext())
                .load(operator.getIconUrl())
                .into(holder.icon);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OperatorDetailActivity.class);
                intent.putExtra("operator", operator);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return operators.size();
    }

    public static class OperatorViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView name;
        TextView details;
        TextView description;

        public OperatorViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.operator_icon);
            name = itemView.findViewById(R.id.operator_name);
            details = itemView.findViewById(R.id.operator_details);
            description = itemView.findViewById(R.id.operator_description);
        }
    }
}