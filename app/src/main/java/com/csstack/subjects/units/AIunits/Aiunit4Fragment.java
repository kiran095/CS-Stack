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
public class Aiunit4Fragment extends Fragment implements pointsAdapter.PositionClick{
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
        points.add("Probability basics");
        points.add("Bayes Rule");
        points.add("Bayesian Networks");
        points.add("Inference");
        points.add(" Markov Models");
        points.add("Types of Learning");
        points.add("Learning Decision Trees");
        points.add("Regression");
        points.add("Artificial Neural Networks");
        points.add("Non Parametric Models");
        points.add("SUpport Vector Machines");
        points.add("Statistical Learning");
        points.add("The EM Algorithm");
        points.add("Reinforcement Learning");



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

            case 0:urltoLoad="https://en.wikipedia.org/wiki/Probability";
                break;
            case 1:
                urltoLoad="https://en.wikipedia.org/wiki/Bayes%27_rule";
                break;
            case 2:urltoLoad="https://en.wikipedia.org/wiki/Bayesian_network";
                break;
            case 3:urltoLoad="https://en.wikipedia.org/wiki/Inference";
                break;
            case 4:urltoLoad="https://en.wikipedia.org/wiki/Markov_model";
                break;
            case 5:urltoLoad="https://en.wikipedia.org/wiki/Decision_tree_learning";
                break;
            case 6:
                urltoLoad="https://en.wikipedia.org/wiki/Regression_analysis";
                break;
            case 7:
                urltoLoad="https://en.wikipedia.org/wiki/Artificial_neural_network";
                break;
            case 8:
                urltoLoad="https://en.wikipedia.org/wiki/Nonparametric_statistics";
                break;
            case 9:
                urltoLoad="https://en.wikipedia.org/wiki/Support_vector_machine";
                break;
            case 10:
                urltoLoad="https://en.wikipedia.org/wiki/Statistical_learning_theory";
                break;
            case 11:
                urltoLoad="https://en.wikipedia.org/wiki/Expectation%E2%80%93maximization_algorithm";
                break;
            case 12:
                urltoLoad="https://en.wikipedia.org/wiki/Reinforcement_learning";
                break;
            case 13:
                urltoLoad="";
                break;
            case 14:
                urltoLoad="";
                break;









        }


        showPage(urltoLoad);
    }

    private void showPage(String urltoLoad) {
    }
}
