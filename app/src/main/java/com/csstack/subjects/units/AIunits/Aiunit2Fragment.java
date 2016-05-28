package com.csstack.subjects.units.AIunits;

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

import java.util.ArrayList;

/**
 * Created by nandhu on 23/5/16.
 */
public class Aiunit2Fragment extends Fragment  implements pointsAdapter.PositionClick{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    ArrayList<String> points;
    RecyclerViewMaterialAdapter adapter;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("COM_CSTACK","on destrou AI2");
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("COM_CSTACK","AI 2");
        super.onCreate(savedInstanceState);
        points = new ArrayList<>(5);
        points.add("Uniformed Search Strategies");
        points.add("Heuristics");
        points.add("Local Search Algorithams");
        points.add("Constraint satisfaction problem");
        points.add("Backtracking");
        points.add("Game Playing");
        points.add("Pruning");
        points.add("Alpha-Beta Pruning");
        mAdapter =new pointsAdapter(points,(pointsAdapter.PositionClick) this );
        adapter=new RecyclerViewMaterialAdapter(mAdapter);
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
        Log.d("COM_CSTACK", "IN fragment interface definition");
        String urltoLoad = null;
        switch (position) {

            case 0:
                urltoLoad = "http://www.codeproject.com/Articles/203828/AI-Simple-Implementation-of-Uninformed-Search-Stra";
                break;
            case 1:
                urltoLoad = "http://artint.info/html/ArtInt_56.html";


                break;
            case 2:
                urltoLoad = "https://en.wikipedia.org/wiki/Local_search_(optimization)";
                break;
            case 3:
                urltoLoad = "https://en.wikipedia.org/wiki/Constraint_satisfaction_problem";
                break;
            case 4:
                urltoLoad = "https://en.wikipedia.org/wiki/Backtracking#Description_of_the_method";
                break;
            case 5:
                urltoLoad = "http://cis-linux1.temple.edu/~pwang/3203-AI/Lecture/Game.htm";
                break;

            case 6:
                urltoLoad = "https://en.wikipedia.org/wiki/Pruning_(decision_trees)";
                break;
            case 7:
                urltoLoad = "https://en.wikipedia.org/wiki/Alpha%E2%80%93beta_pruning";
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



