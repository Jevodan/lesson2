package com.example.jevodan.lesson3;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.Scene;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/** A simple {@link Fragment} subclass. */
public class HomeFragment extends Fragment {

  ViewGroup root;
  Scene scene2, scene1;
  boolean isFirstScene;
  public ImageView imageVieww;

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_home, container, false);
    imageVieww = view.findViewById(R.id.imageView);
    root = view.findViewById(R.id.root);
    scene2 = Scene.getSceneForLayout(root, R.layout.scene2, getContext());
    scene1 = Scene.getSceneForLayout(root, R.layout.scene1, getContext());
    return view;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Handler handler = new Handler();

    handler.post(
        () -> {
          FloatingActionButton fab = getActivity().findViewById(R.id.fab);
          fab.setOnClickListener(
              view -> {
                changeScene();
              });
        });
  }

  private void changeScene() {
    TransitionSet set = new TransitionSet();
    set.addTransition(new Fade());
    set.addTransition(new ChangeBounds());
    set.setOrdering(TransitionSet.ORDERING_TOGETHER);
    set.setDuration(4000);
    set.setInterpolator(new OvershootInterpolator(1.5f));
    TransitionManager.go(isFirstScene ? scene2 : scene1, set);
    isFirstScene = !isFirstScene;
  }
}
