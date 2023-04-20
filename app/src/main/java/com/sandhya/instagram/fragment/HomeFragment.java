package com.sandhya.instagram.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.sandhya.instagram.R;
import com.sandhya.instagram.adapter.AdapterForPostsSystem;
import com.sandhya.instagram.adapter.HistoryAccountAdapter;
import com.sandhya.instagram.adapter.PostAdapter;
import com.sandhya.instagram.adapter.StoryAdapter;
import com.sandhya.instagram.model.HistoryAccountModel;
import com.sandhya.instagram.model.PostModel;
import com.sandhya.instagram.model.SystemModelForPosts;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment {

    List<SystemModelForPosts> postList;
    AdapterForPostsSystem adapterPost;
    RecyclerView post;
    List<String> followingList;
    String myId;
    FirebaseAuth mAuth;
    private static final int TOTAL_ITEMS_TO_LOAD = 7;
    private int mCurrentPage = 1;
    ProgressBar progressBar;
    List<String> followingSList;

    public HomeFragment() {
        // Required empty public constructor
    }
    Toolbar toolbarHome;
    TextView txtInstagram;

    RecyclerView recyclerStory,recyclerPost;

    ArrayList<HistoryAccountModel> sModel = new ArrayList<>();
    StoryAdapter storyAdapter;

    PostAdapter postAdapter;
    ArrayList<PostModel> postModels = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mAuth = FirebaseAuth.getInstance();
        myId = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();


        progressBar = view.findViewById(R.id.pb);
        progressBar.setVisibility(View.VISIBLE);

        post = view.findViewById(R.id.post);

        toolbarHome = view.findViewById(R.id.toolbarHome);
        txtInstagram = view.findViewById(R.id.txtInstagram);
        recyclerPost = view.findViewById(R.id.recyclerPost);
        recyclerStory = view.findViewById(R.id.recyclerStory);

        ImageView imgMyStory = view.findViewById(R.id.imgMyStory);
        TextView txtMyTitle = view.findViewById(R.id.txtMyTitle);
        txtMyTitle.setText("Sandhya Gautam");
        Glide.with(getActivity()).load("https://th.bing.com/th/id/OIP.WIsBVj2VuK8o14hZUOs8MwHaHw?w=203&h=212&c=7&r=0&o=5&dpr=1.3&pid=1.7").into(imgMyStory);

        //story upload
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerStory.setLayoutManager(manager);
        sModel.add(new HistoryAccountModel(null,null,"Sandhya Gautam","https://th.bing.com/th/id/OIP.WIsBVj2VuK8o14hZUOs8MwHaHw?w=203&h=212&c=7&r=0&o=5&dpr=1.3&pid=1.7",null));
        sModel.add(new HistoryAccountModel(null,null,"Sandhya Gautam","https://th.bing.com/th/id/OIP.rnqM8FdAZl_UTkCSIeH-9QHaHY?w=176&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",null));
        sModel.add(new HistoryAccountModel(null,null,"Sandhya Gautam","https://th.bing.com/th/id/OIP.QHhu5UuBOUz7iX_-I4ctYwHaEy?w=252&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",null));
        sModel.add(new HistoryAccountModel(null,null,"Sandhya Gautam","https://th.bing.com/th/id/OIP.rnqM8FdAZl_UTkCSIeH-9QHaHY?w=176&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",null));
        sModel.add(new HistoryAccountModel(null,null,"Sandhya Gautam","https://th.bing.com/th/id/OIP.QHhu5UuBOUz7iX_-I4ctYwHaEy?w=252&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",null));
        sModel.add(new HistoryAccountModel(null,null,"Sandhya Gautam","https://th.bing.com/th/id/OIP.2FmyoU0UIM3LglMI-ISQZQHaEK?w=289&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",null));
        storyAdapter = new StoryAdapter(getActivity(),sModel);
        recyclerStory.setAdapter(storyAdapter);

        ///post upload
        recyclerPost.setLayoutManager(new LinearLayoutManager(getActivity()));
        postModels.add(new PostModel("Shah Rukh Khan","iamsrk","https://www.goldenglobes.com/sites/default/files/articles/cover_images/shah_rukh_khan.jpg","https://www.bing.com/th?id=OIP.bdgWxd40cpUrDHuOBV6BiAHaFj&w=128&h=100&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2"));
        postModels.add(new PostModel("Shah Rukh Khan","iamsrk","https://th.bing.com/th/id/OIP.zsdoZSo-6XqsEEhSMSNUMwHaKn?pid=ImgDet&w=207&h=296&c=7&dpr=1.3","https://www.bing.com/th?id=OIP.bdgWxd40cpUrDHuOBV6BiAHaFj&w=128&h=100&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2"));
        postModels.add(new PostModel("Shah Rukh Khan","iamsrk","https://th.bing.com/th/id/OIP.C5xoK_L5rvBay911t7aSBQAAAA?pid=ImgDet&w=207&h=282&c=7&dpr=1.3","https://www.bing.com/th?id=OIP.bdgWxd40cpUrDHuOBV6BiAHaFj&w=128&h=100&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2"));
        postModels.add(new PostModel("Shah Rukh Khan","iamsrk","https://th.bing.com/th/id/OIP.uXGj3nRuTfp5dlBY1R2E5wHaHa?pid=ImgDet&w=207&h=207&c=7&dpr=1.3","https://www.bing.com/th?id=OIP.bdgWxd40cpUrDHuOBV6BiAHaFj&w=128&h=100&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2"));
        postModels.add(new PostModel("Shah Rukh Khan","iamsrk","https://th.bing.com/th/id/OIP.2orbBeewRm8mkMEiYAC_9AHaLH?pid=ImgDet&w=204&h=306&c=7&dpr=1.3","https://www.bing.com/th?id=OIP.bdgWxd40cpUrDHuOBV6BiAHaFj&w=128&h=100&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2"));
        postModels.add(new PostModel("Shah Rukh Khan","iamsrk","https://th.bing.com/th/id/OIP.aZkQi9XwPabIhYaN1PmjPQHaKT?pid=ImgDet&w=207&h=288&c=7&dpr=1.3","https://www.bing.com/th?id=OIP.bdgWxd40cpUrDHuOBV6BiAHaFj&w=128&h=100&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2"));
        postModels.add(new PostModel("Shah Rukh Khan","iamsrk","https://th.bing.com/th/id/OIP.Wbn7u6xVmqB2dS6i-fpQPgAAAA?pid=ImgDet&w=203&h=282&c=7&dpr=1.3","https://www.bing.com/th?id=OIP.bdgWxd40cpUrDHuOBV6BiAHaFj&w=128&h=100&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2"));
        postModels.add(new PostModel("Shah Rukh Khan","iamsrk","https://www.goldenglobes.com/sites/default/files/articles/cover_images/shah_rukh_khan.jpg","https://www.bing.com/th?id=OIP.bdgWxd40cpUrDHuOBV6BiAHaFj&w=128&h=100&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2"));
        postModels.add(new PostModel("Shah Rukh Khan","iamsrk","https://th.bing.com/th/id/OIP.zsdoZSo-6XqsEEhSMSNUMwHaKn?pid=ImgDet&w=207&h=296&c=7&dpr=1.3","https://www.bing.com/th?id=OIP.bdgWxd40cpUrDHuOBV6BiAHaFj&w=128&h=100&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2"));
        postModels.add(new PostModel("Shah Rukh Khan","iamsrk","https://th.bing.com/th/id/OIP.C5xoK_L5rvBay911t7aSBQAAAA?pid=ImgDet&w=207&h=282&c=7&dpr=1.3","https://www.bing.com/th?id=OIP.bdgWxd40cpUrDHuOBV6BiAHaFj&w=128&h=100&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2"));
        postModels.add(new PostModel("Shah Rukh Khan","iamsrk","https://th.bing.com/th/id/OIP.uXGj3nRuTfp5dlBY1R2E5wHaHa?pid=ImgDet&w=207&h=207&c=7&dpr=1.3","https://www.bing.com/th?id=OIP.bdgWxd40cpUrDHuOBV6BiAHaFj&w=128&h=100&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2"));
        postModels.add(new PostModel("Shah Rukh Khan","iamsrk","https://th.bing.com/th/id/OIP.2orbBeewRm8mkMEiYAC_9AHaLH?pid=ImgDet&w=204&h=306&c=7&dpr=1.3","https://www.bing.com/th?id=OIP.bdgWxd40cpUrDHuOBV6BiAHaFj&w=128&h=100&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2"));
        postModels.add(new PostModel("Shah Rukh Khan","iamsrk","https://th.bing.com/th/id/OIP.aZkQi9XwPabIhYaN1PmjPQHaKT?pid=ImgDet&w=207&h=288&c=7&dpr=1.3","https://www.bing.com/th?id=OIP.bdgWxd40cpUrDHuOBV6BiAHaFj&w=128&h=100&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2"));
        postModels.add(new PostModel("Shah Rukh Khan","iamsrk","https://th.bing.com/th/id/OIP.Wbn7u6xVmqB2dS6i-fpQPgAAAA?pid=ImgDet&w=203&h=282&c=7&dpr=1.3","https://www.bing.com/th?id=OIP.bdgWxd40cpUrDHuOBV6BiAHaFj&w=128&h=100&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2"));
        postAdapter = new PostAdapter(getActivity(),postModels);
        recyclerPost.setAdapter(postAdapter);



        toolbarHome.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.tpLike:
                        Toast.makeText(getActivity(), "Like", Toast.LENGTH_SHORT).show();
                        BottomSheetDialog dialog = new BottomSheetDialog(getActivity(),R.style.BottomDialog);
                        dialog.setContentView(R.layout.bottom_dialog);
                        dialog.show();
                        break;
                    case R.id.tpChat:
                        Toast.makeText(getActivity(), "Chat", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        txtInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Instagram", Toast.LENGTH_SHORT).show();
            }
        });




        return view;
    }

}