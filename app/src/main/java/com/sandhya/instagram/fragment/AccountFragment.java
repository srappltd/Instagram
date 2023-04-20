package com.sandhya.instagram.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sandhya.instagram.R;
import com.sandhya.instagram.accFragment.AccountFragments;
import com.sandhya.instagram.accFragment.GuideFragments;
import com.sandhya.instagram.accFragment.ImageFragments;
import com.sandhya.instagram.accFragment.VideoFragments;
import com.sandhya.instagram.activity.MainActivity;
import com.sandhya.instagram.adapter.HistoryAccountAdapter;
import com.sandhya.instagram.model.HistoryAccountModel;

import java.util.ArrayList;

public class AccountFragment extends Fragment {

    public AccountFragment() {
        // Required empty public constructor
    }

    Toolbar toolbarAccount;
    TextView txtUsername;

    RecyclerView recyclerSaveHistory;
    ArrayList<HistoryAccountModel> hModel = new ArrayList<>();
    HistoryAccountAdapter hAdapter;
    BottomNavigationView bottomAccount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        toolbarAccount = view.findViewById(R.id.toolbarAccount);
        txtUsername = view.findViewById(R.id.txtUsername);
        bottomAccount = view.findViewById(R.id.bottomAccount);

        recyclerSaveHistory = view.findViewById(R.id.recyclerSaveHistory);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerSaveHistory.setLayoutManager(manager);
        hModel.add(new HistoryAccountModel(null,null,"Sandhya Gautam","https://th.bing.com/th/id/OIP.WIsBVj2VuK8o14hZUOs8MwHaHw?w=203&h=212&c=7&r=0&o=5&dpr=1.3&pid=1.7",null));
        hModel.add(new HistoryAccountModel(null,null,"Sandhya Gautam","https://th.bing.com/th/id/OIP.rnqM8FdAZl_UTkCSIeH-9QHaHY?w=176&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",null));
        hModel.add(new HistoryAccountModel(null,null,"Sandhya Gautam","https://th.bing.com/th/id/OIP.QHhu5UuBOUz7iX_-I4ctYwHaEy?w=252&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",null));
        hModel.add(new HistoryAccountModel(null,null,"Sandhya Gautam","https://th.bing.com/th/id/OIP.rnqM8FdAZl_UTkCSIeH-9QHaHY?w=176&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",null));
        hModel.add(new HistoryAccountModel(null,null,"Sandhya Gautam","https://th.bing.com/th/id/OIP.QHhu5UuBOUz7iX_-I4ctYwHaEy?w=252&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",null));
        hModel.add(new HistoryAccountModel(null,null,"Sandhya Gautam","https://th.bing.com/th/id/OIP.2FmyoU0UIM3LglMI-ISQZQHaEK?w=289&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",null));
        hAdapter = new HistoryAccountAdapter(getActivity(),hModel);
        recyclerSaveHistory.setAdapter(hAdapter);

        toolbarAccount.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.accMenu:
                        Toast.makeText(getActivity(), "Menu", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.accUpload:
//                        Toast.makeText(getActivity(), "Upload", Toast.LENGTH_SHORT).show();
                        BottomSheetDialog dialog = new BottomSheetDialog(getActivity(),R.style.BottomDialog);
                        dialog.setContentView(R.layout.create_account);
                        dialog.show();
                        break;
                }
                return false;
            }
        });

        txtUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Username", Toast.LENGTH_SHORT).show();
            }
        });

        bottomAccount.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.accImg:
                        ImageFragments imageFragments = new ImageFragments();
                        selectedFragment(imageFragments);
                       // Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.accVideo:
                        VideoFragments videoFragments = new VideoFragments();
                        selectedFragment(videoFragments);
                       // Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.accGuide:
                        GuideFragments guideFragments = new GuideFragments();
                        selectedFragment(guideFragments);
                      //  Toast.makeText(MainActivity.this, "Upload", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.accAccount:
                        AccountFragments accountFragments = new AccountFragments();
                        selectedFragment(accountFragments);
                      //  Toast.makeText(MainActivity.this, "Video", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }

        });
        bottomAccount.setSelectedItemId(R.id.accImg);

        return view;
    }

    private void selectedFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.accountFram, fragment);
        fragmentTransaction.commit();
    }
}