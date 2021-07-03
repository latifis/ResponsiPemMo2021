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
import com.example.responsi.adapter.RujukanDiscoverAdapter;
import com.example.responsi.model.kasus.ContentItem;
import com.example.responsi.model.rujukan.DataItem;
import com.example.responsi.view.viewmodel.KasusViewModel;
import com.example.responsi.view.viewmodel.RujukanViewModel;

import java.util.ArrayList;

public class RujukanFragment extends Fragment {

    private RujukanDiscoverAdapter rujukanDiscoverAdapter;
    private RecyclerView recyclerView;
    private RujukanViewModel rujukanViewModel;
    private ProgressBar progressBar;

    public RujukanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rujukan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        progressBar = view.findViewById(R.id.progress_bar_rs);

        rujukanDiscoverAdapter = new RujukanDiscoverAdapter(getContext());
        rujukanDiscoverAdapter.notifyDataSetChanged();

        recyclerView = view.findViewById(R.id.fragmentkasus_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        rujukanViewModel = new ViewModelProvider(this).get(RujukanViewModel.class);
        rujukanViewModel.setRujukanDiscover();
        rujukanViewModel.getRujukanDiscover().observe(getViewLifecycleOwner(), getRujukanDiscover);

        recyclerView.setAdapter(rujukanDiscoverAdapter);
    }

    private Observer<ArrayList<DataItem>> getRujukanDiscover = new Observer<ArrayList<DataItem>>() {
        @Override
        public void onChanged(ArrayList<DataItem> dataItems) {
            if (dataItems != null){
                rujukanDiscoverAdapter.setData(dataItems);
                progressBar.setVisibility(View.GONE);
            }
        }
    };
}