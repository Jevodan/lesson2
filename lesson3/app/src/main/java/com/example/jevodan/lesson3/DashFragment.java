package com.example.jevodan.lesson3;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/** A simple {@link Fragment} subclass. */
public class DashFragment extends Fragment {

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    return inflater.inflate(R.layout.fragment_dash, container, false);

  }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Handler handler = new Handler();

        handler.post(
                () -> {
                    ImageView anima = getActivity().findViewById(R.id.anim);
                    FloatingActionButton fab = getActivity().findViewById(R.id.fab);
                    fab.setOnClickListener(
                            view -> {
                                Log.d("fff","тест");
                                if (getActivity().findViewById(R.id.imageView) != null) {
                                    Animation anim =
                                            AnimationUtils.loadAnimation(this.getContext(), R.anim.move_animation);
                                    getActivity().findViewById(R.id.imageView).startAnimation(anim);
                                }
                                ((AnimatedVectorDrawable)anima.getDrawable()).start();
                            });

                });
    }
}
