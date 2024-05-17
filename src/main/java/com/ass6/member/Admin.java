package com.ass6.member;

public class Admin extends User{
  private String role;

  public Admin() {
  }

  public Admin(String id, String password, String role) {
    super(id, password);
    this.role = role;
  }
}
