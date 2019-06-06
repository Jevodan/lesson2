package com.example.jevodan.lesson3.model;

public class Leg extends Unit {

  public String type = "Легионы";
  public String color = "#F50E0E";

  public Leg(String picture, String name, int hp, int attack) {
    super(picture, name, hp, attack);
  }

  @Override
  public String getColor() {
    return color;
  }
}
