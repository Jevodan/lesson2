package com.example.jevodan.lesson3.tools;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class MyAnimation {

  @SuppressLint("ClickableViewAccessibility")
  public static void ValueAnim(@NonNull TextView attack, int number) {
    attack.setOnTouchListener(
        (v1, event) -> {
          ValueAnimator animator = ValueAnimator.ofInt(1, number);
          animator.addUpdateListener(
              animation -> attack.setText(String.valueOf(animation.getAnimatedValue())));
          animator.setDuration(1500);
          animator.setInterpolator(new OvershootInterpolator(1.5f));
          animator.start();
          return false;
        });
  }
}
