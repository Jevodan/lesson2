package com.example.jevodan.lesson3.model;

public class Unit {

  public Unit(String picture, String name) {
    this.picture = picture;
    this.name = name;
  }

  String picture;
  String name;

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
}
