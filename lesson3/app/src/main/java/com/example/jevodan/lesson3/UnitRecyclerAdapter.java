package com.example.jevodan.lesson3;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jevodan.lesson3.model.Imp;
import com.example.jevodan.lesson3.model.Unit;
import com.example.jevodan.lesson3.tools.CircularTransformation;
import com.example.jevodan.lesson3.tools.MyAnimation;
import com.squareup.picasso.Picasso;
import java.util.Collections;
import java.util.List;

public class UnitRecyclerAdapter extends RecyclerView.Adapter implements ItemAdapter {

  Unit unit;
  Uri otherPath;
  private static final int UNIT = 1;
  private static final int IMP = 2;

  private final List<Unit> unitList;

  public UnitRecyclerAdapter(List<Unit> unitList) {
    this.unitList = unitList;
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new ViewHold(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_unit, parent, false));
  }

  @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    unit = unitList.get(position);
    otherPath =
        Uri.parse("android.resource://com.example.jevodan.lesson3/drawable/" + unit.getPicture());
    Picasso.get()
        .load(otherPath)
        .transform(new CircularTransformation(155))
        .into(((ViewHold) holder).picture);
    ((ViewHold) holder).name.setText(unit.getName());
    ((ViewHold) holder).name.setTextColor(Color.parseColor(unit.getColor()));
    ((ViewHold) holder)
        .picture.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(unit.getColor())));
    ((ViewHold) holder).hp.setText(String.valueOf(unit.getHp()));
    MyAnimation.ValueAnim(((ViewHold) holder).attack , unit.getAttack());
    ((ViewHold) holder).attack.setText(String.valueOf(unit.getAttack()));
  }

  @Override
  public int getItemCount() {
    return unitList.size();
  }

  @Override
  public int getItemViewType(int position) {
    int wow;
    wow = unitList.get(position) instanceof Unit ? UNIT : IMP;
    Log.d("ТАГ", String.valueOf(wow));
    Log.d("ТАГ2", unitList.get(position).getName());
    return unitList.get(position) instanceof Imp ? IMP : UNIT;
  }

  @Override
  public void onDeleteItem(int position) {
    removeItem(position);
  }

  @Override
  public void onMoveItem(int from, int to) {
    Collections.swap(unitList, from, to);
    notifyItemMoved(from, to);
  }

  public static class ViewHold extends RecyclerView.ViewHolder {

    ImageView picture;
    TextView name;
    TextView hp;
    TextView attack;

    public ViewHold(@NonNull View itemView) {
      super(itemView);
      picture = itemView.findViewById(R.id.picture);
      name = itemView.findViewById(R.id.name);
      hp = itemView.findViewById(R.id.hp);
      attack = itemView.findViewById(R.id.attack);
    }
  }

  public void removeItem(int position) {
    unitList.remove(position);
    notifyItemRemoved(position);
  }

  public void addItem(Unit unit) {
    unitList.add(unit);
  }

  public static class ViewHoldImp extends RecyclerView.ViewHolder {

    ImageView picture;
    TextView name;

    public ViewHoldImp(@NonNull View itemView) {
      super(itemView);
      picture = itemView.findViewById(R.id.picture);
      name = itemView.findViewById(R.id.name);
    }
  }
}
