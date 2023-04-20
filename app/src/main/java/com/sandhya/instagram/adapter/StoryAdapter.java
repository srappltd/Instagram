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

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {
    Context context;
    ArrayList<HistoryAccountModel> sModel;

    public StoryAdapter(Context context, ArrayList<HistoryAccountModel> sModel) {
        this.context = context;
        this.sModel = sModel;
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.save_history_account,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.ViewHolder holder, int position) {
        HistoryAccountModel model = sModel.get(position);
        holder.txtTitleHistory.setText(model.getTitle());
        Glide.with(context).load(model.getImage()).into(holder.imgSaveHistory);


    }

    @Override
    public int getItemCount() {
        return sModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgSaveHistory;
        TextView txtTitleHistory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgSaveHistory = itemView.findViewById(R.id.imgSaveHistory);
            txtTitleHistory = itemView.findViewById(R.id.txtTitleHistory);
        }
    }
}
