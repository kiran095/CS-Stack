package com.csstack.subjects.units.SSUnits;

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
public class SS3 extends Fragment implements pointsAdapter.PositionClick{
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
        points.add("Macroprocessors");
        points.add("Machine-Independent Macro");
        points.add("Introduction to Virtual Machines");
        points.add("basic Interpretation");
        points.add("Threaded Interpretation");
        points.add("instruction set");
        points.add("binary translation");



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

            case 0:urltoLoad="https://en.wikipedia.org/wiki/General-purpose_macro_processor";
                break;
            case 1:
                urltoLoad="https://en.wikipedia.org/wiki/Macro_(computer_science)#Macros_for_machine-independent_software";
                break;
            case 2:urltoLoad="https://en.wikipedia.org/wiki/Virtual_machine";
                break;
            case 3:urltoLoad="https://en.wikipedia.org/wiki/Interpreter_(computing)";
                break;
            case 4:urltoLoad="https://en.wikipedia.org/wiki/Threaded_code";
                break;
            case 5:urltoLoad="https://en.wikipedia.org/wiki/Instruction_set";

                break;
            case 6:urltoLoad="https://en.wikipedia.org/wiki/Instruction_set";

                break;
            case 7:urltoLoad="https://en.wikipedia.org/wiki/Binary_translation";

                break;

        }


        showPage(urltoLoad);
    }

    private void showPage(String urltoLoad) {
    }
}

