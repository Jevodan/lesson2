package com.example.jevodan.lesson3.model;

public class Imp extends Unit {

  public String type = "Империя";
  public String color = "#0905E9";

  public Imp(String picture, String name, int hp, int attack) {
    super(picture, name, hp, attack);
  }

  @Override
  public String getColor() {
    return color;
  }
}
