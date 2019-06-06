package com.example.jevodan.lesson3.model;

public abstract class Unit {

  public  String type = "Нейтрал";
  public  String color = "#FFFFFFFF";
  String picture;
  String name;
  int hp;
  int attack;

  public Unit(String picture, String name, int hp, int attack) {
    this.picture = picture;
    this.name = name;
    this.hp = hp;
    this.attack = attack;
  }

  public String getType() {
    return type;
  }

  public String getColor() {
    return color;
  }

  public int getHp() {
    return hp;
  }

  public int getAttack() {
    return attack;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void createUnit(String name){

  }
}
