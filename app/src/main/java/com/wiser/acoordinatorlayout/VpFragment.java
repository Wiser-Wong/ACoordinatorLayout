package com.wiser.acoordinatorlayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class VpFragment extends Fragment {

    private RecyclerView rlv;

    public static VpFragment getInstance(int size) {
        VpFragment fragment = new VpFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("size", size);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vp_item, container, false);
        rlv = view.findViewById(R.id.rlv_vp);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rlv.setAdapter(new RecyclerAdapter(getActivity(),getArguments() != null ? getArguments().getInt("size") : 0));
        return view;
    }


}
