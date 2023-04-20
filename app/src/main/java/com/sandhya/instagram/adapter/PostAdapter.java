package com.sandhya.instagram.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sandhya.instagram.R;
import com.sandhya.instagram.model.PostModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    Context context;
    ArrayList<PostModel> postModels;

    public PostAdapter(Context context, ArrayList<PostModel> postModels) {
        this.context = context;
        this.postModels = postModels;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_home_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        PostModel model = postModels.get(position);
        holder.txtName.setText(model.getName());
        holder.txtPostUsername.setText(model.getUsername());
        Glide.with(context).load(model.getProfileImage()).into(holder.imgUser);
        Glide.with(context).load(model.getPost()).into(holder.imgPost);

    }

    @Override
    public int getItemCount() {
        return postModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName,txtPostUsername;
        ImageView imgLick,imgMessage,imgSend,imgSave,imgPost;
        CircleImageView imgUser;
        AppCompatButton btnFollow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPostUsername = itemView.findViewById(R.id.txtPostUsername);
            imgLick = itemView.findViewById(R.id.imgLick);
            imgMessage = itemView.findViewById(R.id.imgMessage);
            imgSend = itemView.findViewById(R.id.imgSend);
            imgSave = itemView.findViewById(R.id.imgSave);
            imgPost = itemView.findViewById(R.id.imgPost);
            imgUser = itemView.findViewById(R.id.imgUser);
            btnFollow = itemView.findViewById(R.id.btnFollow);
        }
    }
}
