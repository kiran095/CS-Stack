package com.csstack.subjects.units.SeUnits;

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
 * Created by nandhu on 29/5/16.
 */
public class SE3 extends Fragment implements pointsAdapter.PositionClick{
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
        points.add("Requirement Analyis");
        points.add("Design Process");
        points.add("UI design");
        points.add("Testing Strategies");
        points.add("Validation testing");
        points.add("System Testing");
        points.add("Art of Debugging");
        points.add("Project managment");



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

            case 0:urltoLoad="https://en.wikipedia.org/wiki/Requirements_analysis";
                break;
            case 1:
                urltoLoad="https://en.wikipedia.org/wiki/Design_process_(computing)";
                break;
            case 2:urltoLoad="https://en.wikipedia.org/wiki/User_interface_design";
                break;
            case 3:urltoLoad="https://en.wikipedia.org/wiki/Test_strategy";
                break;
            case 4:urltoLoad="https://en.wikipedia.org/wiki/Acceptance_testing";
                break;
            case 5:urltoLoad="https://en.wikipedia.org/wiki/System_testing";

                break;
            case 6:urltoLoad="https://en.wikipedia.org/wiki/Debugging";

                break;
            case 7:urltoLoad="https://en.wikipedia.org/wiki/Project_management";

                break;

        }


        showPage(urltoLoad);
    }

    private void showPage(String urltoLoad) {
    }
}

