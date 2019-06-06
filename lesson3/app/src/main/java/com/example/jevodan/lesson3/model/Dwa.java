package com.example.jevodan.lesson3.model;

public class Dwa extends Unit {

  public String type = "Гномы";
  public String color = "#646262";

  public Dwa(String picture, String name, int hp, int attack) {
    super(picture, name, hp, attack);
  }

  @Override
  public String getColor() {
    return color;
  }
}
