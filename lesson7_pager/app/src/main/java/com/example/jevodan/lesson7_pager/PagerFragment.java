package com.example.jevodan.lesson7_pager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PagerFragment extends Fragment {

    public static PagerFragment newInstance(int color) {
        Bundle args = new Bundle();
        args.putInt("COLOR", color);
        PagerFragment fragment = new PagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = new View(container.getContext());
        view.setLayoutParams((new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)));
        view.setBackgroundColor(getArguments().getInt("COLOR"));
        return view;
    }
}


