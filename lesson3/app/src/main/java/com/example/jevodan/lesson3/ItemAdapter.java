package com.example.jevodan.lesson3;

import com.example.jevodan.lesson3.model.Unit;

public interface ItemAdapter {

  void onDeleteItem(int position);

  void onMoveItem(int from, int to);

}
