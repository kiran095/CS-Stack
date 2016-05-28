package com.csstack.subjects.units.AIunits;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
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

import java.net.URI;
import java.util.ArrayList;

/**
 * Created by nandhu on 23/5/16.
 */
public class AIunit1Fragment extends Fragment implements pointsAdapter.PositionClick{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    public  pointsAdapter.PositionClick listener ;
    ArrayList<String> points;
    LinearLayoutManager lm;
    public View view;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("COM_CSTACK","AI UNIT I");
        points=new ArrayList<>();
        points.add("Introudction ");
        points.add("Intelligent Agents");
        points.add("Types of Agents");
        points.add("Problem Solving in AI");
        mAdapter=new pointsAdapter(points,(pointsAdapter.PositionClick)this);
        lm=new LinearLayoutManager(getParentFragment().getContext());



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("COM_CSTACK","--->on create of child");
        view =  inflater.inflate(R.layout.unit_list_layout,container,false);
        mRecyclerView=(RecyclerView)view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(lm);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(new RecyclerViewMaterialAdapter(mAdapter));

         MaterialViewPagerHelper.registerRecyclerView(getActivity(),mRecyclerView,null);
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
    public void onDestroy() {
        super.onDestroy();
        Log.d("COM_CSTACK","--->on destroy");
    }

    @Override
    public void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("COM_CSTACK","--->on detach");
    }

    @Override
    public void positionClicked(int position) {
        Log.d("COM_CSTACK","IN fragment interface definition");
        String urltoLoad=null;
        switch (position){

            case 0:urltoLoad="https://en.wikipedia.org/wiki/Artificial_intelligence";
                break;
            case 1:
                urltoLoad="https://en.wikipedia.org/wiki/Intelligent_agent";


                break;
            case 2:urltoLoad="https://en.wikipedia.org/wiki/Artificial_intelligence#Deduction.2C_reasoning.2C_problem_solving";
                break;
            case 3:urltoLoad="https://en.wikipedia.org/wiki/Intelligent_agent#Classes_of_intelligent_agents";
                break;
            case 4:urltoLoad="http://www.sdsc.edu/~tbailey/teaching/cse151/lectures/chap03a.html";
                break;
           }


        showPage(urltoLoad);
    }

    public void showPage(String urltoLoad) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(getActivity(), Uri.parse(urltoLoad));
    }
}