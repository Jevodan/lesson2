package com.example.jevodan.lesson3.model;

public class Nec extends Unit {

  public String type = "Нежить";
  public String color = "#19772A";

  public Nec(String picture, String name, int hp, int attack) {
    super(picture, name, hp, attack);
  }

  @Override
  public String getColor() {
    return color;
  }
}
