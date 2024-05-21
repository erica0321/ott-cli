package com.ass6.media;

public class HistoricalDrama extends Drama {
  private String generation;

  public HistoricalDrama(String title, int duration, int episodes, double rating, String generation) {
    super(title, duration, episodes, rating);
    this.generation = generation;
  }

  public String getGeneration() {
    return generation;
  }

  @Override
  public String toString() {
    return super.toString() + " - " + this.generation;
  }
}
