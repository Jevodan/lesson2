package com.example.jevodan.lesson3.model;

public class Elf extends Unit {

  public String type = "Эльфы";
  public String color = "#EE641D";

  public Elf(String picture, String name, int hp, int attack) {
    super(picture, name, hp, attack);
  }

  @Override
  public String getColor() {
    return color;
  }
}
