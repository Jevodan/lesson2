package com.example.jevodan.lesson3;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class ItemCallback extends ItemTouchHelper.Callback {

  final ItemAdapter adapter;

  public ItemCallback(ItemAdapter adapter) {
    this.adapter = adapter;
  }

  @Override
  public int getMovementFlags(
      @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
    int dragDrop = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
    int swipeDrop = ItemTouchHelper.START | ItemTouchHelper.END;
    return makeMovementFlags(dragDrop, swipeDrop);
  }

  @Override
  public boolean onMove(
      @NonNull RecyclerView recyclerView,
      @NonNull RecyclerView.ViewHolder viewHolder,
      @NonNull RecyclerView.ViewHolder target) {
    adapter.onMoveItem(viewHolder.getAdapterPosition(), target.getAdapterPosition());
    return true;
  }

  @Override
  public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
    adapter.onDeleteItem(viewHolder.getAdapterPosition());
  }
}
