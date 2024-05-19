package com.ass6.media;

public class CrimeDrama extends Drama {
  private String crimeType;

  public CrimeDrama(String title, int duration, int episodes, double rating, String crimeType) {
    super(title, duration, episodes, rating);
    this.crimeType = crimeType;
  }

  public String getCrimeType() {
    return crimeType;
  }

  @Override
  public String toString() {
    return super.toString() + " - " + getCrimeType();
  }
}
