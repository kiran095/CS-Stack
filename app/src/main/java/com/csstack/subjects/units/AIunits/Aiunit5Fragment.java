package com.csstack.subjects.units.AIunits;

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
 * Created by nandhu on 23/5/16.
 */
public class Aiunit5Fragment extends Fragment implements pointsAdapter.PositionClick {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    ArrayList<String> points;
    LinearLayoutManager lm;
    public  RecyclerViewMaterialAdapter adapter;

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
        points.add("AI Applications");
        points.add("Language Models");
        points.add("Information Retrival");
        points.add("Natural Language Proccessing");
        points.add("Machine Translation");
        points.add("Speech Recogonition");
        points.add("Robotics");
        points.add("Perception in Robotics");
        points.add("Planning ");
        points.add("Moving");



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
        String urltoLoad = null;
        switch (position) {

            case 0:
                urltoLoad = "https://en.wikipedia.org/wiki/Applications_of_artificial_intelligence"
                break;
            case 1:
                urltoLoad = "https://en.wikipedia.org/wiki/Language_model";


                break;
            case 2:
                urltoLoad = "https://en.wikipedia.org/wiki/Information_retrieval"
                break;
            case 3:
                urltoLoad = "https://en.wikipedia.org/wiki/Natural_language_processing";
                break;
            case 4:
                urltoLoad = "https://en.wikipedia.org/wiki/Machine_translation";
                break;
            case 5:
                urltoLoad = "https://en.wikipedia.org/wiki/Speech_recognition";
                break;

            case 6:
                urltoLoad = "https://en.wikipedia.org/wiki/Robotics";
                break;
            case 7:
                urltoLoad = "https://see.stanford.edu/materials/aiircs223a/handout5_robots_and_vision.pdf";
                break;
            showPage(urltoLoad);


        }

    }

    private void showPage(String urltoLoad) {
    }
}
