package com.example.jevodan.lesson3;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jevodan.lesson3.model.Imp;
import com.example.jevodan.lesson3.model.Unit;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.FlipInLeftYAnimator;

/** A simple {@link Fragment} subclass. */
public class NotiFragment extends Fragment {

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Handler handler = new Handler();
    handler.post(
        () -> {
          FloatingActionButton fab = getActivity().findViewById(R.id.fab);
          FlipInLeftYAnimator flipInLeftYAnimator = new FlipInLeftYAnimator();
          flipInLeftYAnimator.setRemoveDuration(1000);

          RecyclerView recyclerView = getView().findViewById(R.id.recycler_unit);
          recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

          UnitRecyclerAdapter unitRecyclerAdapter = new UnitRecyclerAdapter(genUnits());

          recyclerView.setAdapter(unitRecyclerAdapter);
          recyclerView.setItemAnimator(flipInLeftYAnimator);

          ItemTouchHelper itemTouchHelper =
              new ItemTouchHelper(new ItemCallback(unitRecyclerAdapter));
          itemTouchHelper.attachToRecyclerView(recyclerView);
            SnapHelper snapHelper = new LinearSnapHelper();
            snapHelper.attachToRecyclerView(recyclerView);

          fab.setOnClickListener(
              view -> {
                unitRecyclerAdapter.removeItem(0);
              });
        });
  }

  private List<Unit> genUnits() {
    List<Unit> unitList = new ArrayList();
    for (int i = 0; i < 50; i++) {
      unitList.add(new Unit("", "Юнит" + i));
      unitList.add(new Imp("", "Рыцарь" + i));
    }
    return unitList;
  }

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_noti, container, false);
  }
}
