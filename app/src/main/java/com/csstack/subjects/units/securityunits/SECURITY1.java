package com.csstack.subjects.units.securityunits;

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
public class SECURITY1 extends Fragment implements pointsAdapter.PositionClick{
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
        points=new ArrayList<>(10);
        points.add("Security overivew");
        points.add("Substitution ciphers");
        points.add("Encryption Algorithams");

        points.add("Data Enryption Sstandards");
        points.add("AES");
        points.add("Public Key Encryption");

        points.add("Cryptographc hash functions");
        points.add("Key Exchange");
        points.add("digital Signature");

        points.add("certificates");



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

            case 0:urltoLoad="https://en.wikipedia.org/wiki/Computer_security";
                break;
            case 1:
                urltoLoad="https://en.wikipedia.org/wiki/Substitution_cipher";
                break;
            case 2:urltoLoad="https://en.wikipedia.org/wiki/Encryption";
                break;
            case 3:urltoLoad="https://en.wikipedia.org/wiki/Data_Encryption_Standard";
                break;
            case 4:urltoLoad="https://en.wikipedia.org/wiki/Advanced_Encryption_Standard";
                break;
            case 5:urltoLoad="https://en.wikipedia.org/wiki/Public-key_cryptography";

                break;

            case 6:urltoLoad="https://en.wikipedia.org/wiki/Cryptographic_hash_function";

                break;

            case 7:urltoLoad="https://en.wikipedia.org/wiki/Key_exchange";

                break;
            case 8:urltoLoad="https://en.wikipedia.org/wiki/Digital_signature";

                break;
            case 9:urltoLoad="https://en.wikipedia.org/wiki/Digital_signature";

                break;



        }


        showPage(urltoLoad);
    }

    private void showPage(String urltoLoad) {
    }
}

