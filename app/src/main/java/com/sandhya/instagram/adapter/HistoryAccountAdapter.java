package com.sandhya.instagram.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sandhya.instagram.R;
import com.sandhya.instagram.model.HistoryAccountModel;

import java.util.ArrayList;

public class HistoryAccountAdapter extends RecyclerView.Adapter<HistoryAccountAdapter.ViewHolder> {
    Context context;
    ArrayList<HistoryAccountModel> hModels;

    public HistoryAccountAdapter(Context context, ArrayList<HistoryAccountModel> hModels) {
        this.context = context;
        this.hModels = hModels;
    }

    @NonNull
    @Override
    public HistoryAccountAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.save_history_account,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAccountAdapter.ViewHolder holder, int position) {
        HistoryAccountModel model = hModels.get(position);
        holder.txtTitleHistory.setText(model.getTitle());
//        holder.imgSaveHistory.setImageURI(Uri.parse(model.getImage()));
        Glide.with(context).load(model.getImage()).into(holder.imgSaveHistory);
    }

    @Override
    public int getItemCount() {
        return hModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitleHistory;
        ImageView imgSaveHistory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitleHistory = itemView.findViewById(R.id.txtTitleHistory);
            imgSaveHistory = itemView.findViewById(R.id.imgSaveHistory);
        }
    }
}
