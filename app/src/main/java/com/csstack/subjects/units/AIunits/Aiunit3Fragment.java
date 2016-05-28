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
public class Aiunit3Fragment extends Fragment implements pointsAdapter.PositionClick {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    ArrayList<String> points;
    LinearLayoutManager lm;
    RecyclerViewMaterialAdapter adapter;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("COM_CSTACK","on destrou AI3");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        points=new ArrayList<>();
        points.add("Predicate Calculus");
        points.add("First Order Prdeicate Logic");
        points.add("Unification");
        points.add("Forward Chaining");
        points.add("Backward Chaining")
        ;points.add("Knowledge Representation");
        points.add("Ontological Engineering");

        points.add("Reasoning and Acting");
        mAdapter=new pointsAdapter(points,(pointsAdapter.PositionClick)this);
        lm=new LinearLayoutManager(getParentFragment().getContext());
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
        mRecyclerView=(RecyclerView)view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(lm);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);
        MaterialViewPagerHelper.registerRecyclerView(getActivity(),mRecyclerView,null);
    }
    @Override
    public void positionClicked(int position) {
        Log.d("COM_CSTACK","IN fragment interface definition");
        String urltoLoad=null;
        switch (position){

            case 0:urltoLoad="https://en.wikipedia.org/wiki/Predicate_logic";

                break;
            case 1:
                urltoLoad="https://en.wikipedia.org/wiki/First-order_logic";
                break;



            case 2:urltoLoad="https://en.wikipedia.org/wiki/Unification_(computer_science)";
                break;
            case 3:urltoLoad="https://en.wikipedia.org/wiki/Forward_chaining";

                break;
            case 4:urltoLoad="https://en.wikipedia.org/wiki/Backward_chaining";
                break;
            case 5:urltoLoad="http://groups.csail.mit.edu/medg/ftp/psz/k-rep.html#kr";

                break;
            case 6:urltoLoad="http://artint.info/html/ArtInt_11.html";


        }


        showPage(urltoLoad);
    }

    private void showPage(String urltoLoad) {
    }


}
