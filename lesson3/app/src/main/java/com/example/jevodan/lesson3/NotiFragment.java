package com.example.jevodan.lesson3;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jevodan.lesson3.model.Imp;
import com.example.jevodan.lesson3.model.Unit;

import java.util.ArrayList;
import java.util.List;

/** A simple {@link Fragment} subclass. */
public class NotiFragment extends Fragment {

  public NotiFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Handler handler = new Handler();
    handler.post(
        () -> {
          RecyclerView recyclerView = getView().findViewById(R.id.recycler_unit);
          recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
          recyclerView.setAdapter(new UnitRecyclerAdapter(genUnits()));
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
