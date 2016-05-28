package com.csstack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.csstack.subjects.units.pointsAdapter;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;

import java.util.ArrayList;

/**
 * Created by nandhu on 27/5/16.
 */
public class TestFragment  extends Fragment{
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<String> su=new ArrayList<>();
        su.add("HEllo");
        su.add("hi");
        su.add("HOw are you doing");
        su.add("I'm fine");
      //mAdapter=new pointsAdapter(su);

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.unit_list_layout,container,false);
        mRecyclerView=(RecyclerView)view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
    return view;
    }
}
