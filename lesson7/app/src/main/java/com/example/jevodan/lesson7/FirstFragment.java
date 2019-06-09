package com.example.jevodan.lesson7;

import android.os.Build;
import android.os.Bundle;
import android.transition.ArcMotion;
import android.transition.ChangeBounds;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

  ImageView imageView;

  @Nullable
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_first, container, false);
    imageView = view.findViewById(R.id.imageView);
    imageView.setOnClickListener(
        v -> {
          SecondFragment secondFragment = new SecondFragment();
          ChangeBounds changeBounds = new ChangeBounds();
          changeBounds.setPathMotion(new ArcMotion());
          secondFragment.setSharedElementEnterTransition(changeBounds);
          getFragmentManager()
              .beginTransaction()
              .replace(R.id.container, secondFragment)
              .addSharedElement(imageView, getString(R.string.supername))
              .addToBackStack(
                  FirstFragment.class
                      .getName()) // нажатие кнопки назад, возвращаемся к первому фрагменту
              .commit();
        });
    return view;
  }
}
