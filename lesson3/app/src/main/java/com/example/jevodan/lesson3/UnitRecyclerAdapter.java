package com.example.jevodan.lesson3;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jevodan.lesson3.model.Imp;
import com.example.jevodan.lesson3.model.Unit;

import java.util.Collections;
import java.util.List;

public class UnitRecyclerAdapter extends RecyclerView.Adapter implements ItemAdapter {

  private static final int UNIT = 1;
  private static final int IMP = 2;

  private final List<Unit> unitList;

  public UnitRecyclerAdapter(List<Unit> unitList) {
    this.unitList = unitList;
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    switch (viewType) {
      case IMP:
        return new ViewHoldImp(
            LayoutInflater.from(parent.getContext()).inflate(R.layout.item_imp, parent, false));
      default:
        return new ViewHold(
            LayoutInflater.from(parent.getContext()).inflate(R.layout.item_unit, parent, false));
    }
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    if (holder instanceof ViewHold)
      ((ViewHold) holder).name.setText(unitList.get(position).getName());
    else ((ViewHoldImp) holder).name.setText(unitList.get(position).getName());
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

    public ViewHold(@NonNull View itemView) {
      super(itemView);
      picture = itemView.findViewById(R.id.picture);
      name = itemView.findViewById(R.id.name);
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
