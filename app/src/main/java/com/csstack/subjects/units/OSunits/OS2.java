package com.csstack.subjects.units.OSunits;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.csstack.R;
import com.csstack.subjects.units.pointsAdapter;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;

import java.util.ArrayList;

/**
 * Created by nandhu on 28/5/16.
 */
public class OS2 extends Fragment implements pointsAdapter.PositionClick{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    ArrayList<String> points;
    LinearLayoutManager lm;
    public RecyclerViewMaterialAdapter adapter;

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        points=new ArrayList<>(5);
        points.add("Basic concepts");
        points.add("Scheduling criteria");
        points.add("Scheduling algorithms");
        points.add("Thread scheduling");
        points.add("Multiple processor scheduling");
        points.add("Operating system examples");
        points.add("The critical section problem");
        points.add("Synchronization hardware");
        points.add("Synchronization hardware");
        points.add("Semaphore");
        points.add("Classic problems of synchronization");
        points.add("Critical regions");
        points.add("Monitors");
        points.add("Synchronization examples");
        points.add("Deadlocks");
        points.add("Deadlock Prevention");
        points.add("Deadlock Avoidance");
        points.add("Deadlock detection");
        points.add("Recovery from deadlock");





    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.unit_list_layout, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getParentFragment().getContext()));
        mRecyclerView.setAdapter(adapter);
        MaterialViewPagerHelper.registerRecyclerView(getActivity(), mRecyclerView, null);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void positionClicked(int position) {
        Log.d("COM_CSTACK","IN fragment interface definition");
        String urltoLoad=null;
        switch (position){

            case 0:urltoLoad="";
                break;
            case 1:
                urltoLoad="";
                break;
            case 2:urltoLoad="";
                break;
            case 3:urltoLoad="";
                break;
            case 4:urltoLoad="";
                break;
            case 5:urltoLoad="";

                break;

        }


        showPage(urltoLoad);
    }

    private void showPage(String urltoLoad) {
    }
}

