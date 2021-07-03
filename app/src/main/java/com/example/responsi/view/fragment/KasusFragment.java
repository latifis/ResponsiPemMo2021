package com.example.responsi.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.responsi.R;
import com.example.responsi.adapter.KasusDiscoverAdapter;
import com.example.responsi.model.kasus.ContentItem;
import com.example.responsi.view.viewmodel.KasusViewModel;

import java.util.ArrayList;

public class KasusFragment extends Fragment {

    private KasusDiscoverAdapter kasusDiscoverAdapter;
    private RecyclerView recyclerView;
    private KasusViewModel kasusViewModel;
    private ProgressBar progressBar;

    public KasusFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kasus, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        progressBar = view.findViewById(R.id.progress_bar_kasus);

        kasusDiscoverAdapter = new KasusDiscoverAdapter(getContext());
        kasusDiscoverAdapter.notifyDataSetChanged();

        recyclerView = view.findViewById(R.id.fragmentkasus_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        kasusViewModel = new ViewModelProvider(this).get(KasusViewModel.class);
        kasusViewModel.setKasusDiscover();
        kasusViewModel.getKasusDiscover().observe(getViewLifecycleOwner(), getKasusDiscover);

        recyclerView.setAdapter(kasusDiscoverAdapter);

    }

    private Observer<ArrayList<ContentItem>> getKasusDiscover = new Observer<ArrayList<ContentItem>>() {
        @Override
        public void onChanged(ArrayList<ContentItem> dataItems) {
            if (dataItems != null){
                kasusDiscoverAdapter.setData(dataItems);
                progressBar.setVisibility(View.GONE);
            }
        }
    };

}