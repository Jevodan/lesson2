package com.example.jevodan.lesson3;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.Scene;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;

import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  private FragmentManager fragmentManager;
  private FragmentTransaction fragmentTransaction;
  private ImageView imageView = null;

  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
      item -> {
        switch (item.getItemId()) {
          case R.id.navigation_home:
            createFragment(new HomeFragment());
            return true;
          case R.id.navigation_dashboard:
            createFragment(new DashFragment());
            return true;
          case R.id.navigation_notifications:
            createFragment(new NotiFragment());
            return true;
        }
        return false;
      };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    final BottomNavigationView navView = findViewById(R.id.nav_view);
    navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    fragmentManager = getSupportFragmentManager();
    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(
        view -> {
          navView.setVisibility(View.VISIBLE);
          navView
              .animate()
              .setListener(null)
              .rotationXBy(360)
              .setDuration(1500)
              .setInterpolator(new OvershootInterpolator(1.5f));
          // navView.setRotationX(0);
          Log.d("ТАГ", String.valueOf(navView.getRotationX()));
          if (imageView != null) {
            Animation anim =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_animation);
            imageView.startAnimation(anim);
          }
        });
  }

  private void createFragment(Fragment fragment) {
    fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.my_fragment, fragment);
    fragmentTransaction.commit();

    Handler handler = new Handler();
    handler.post(
        () -> {
          imageView = fragment.getView().findViewById(R.id.imageView);
        });
  }
}
