package com.ass6.member;

public class User {
  private String id;
  private String password;

  public User() {
  }

  public User(String id, String password) {
    this.id = id;
    this.password = password;
  }

  public String getId() {
    return id;
  }

  public String getPassword() {
    return password;
  }

  public String toString() {
    return "User: " + id;
  }
}
