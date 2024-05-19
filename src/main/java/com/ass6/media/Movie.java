package com.ass6.media;

public class
Movie extends Media {
  private int view;
  private boolean release;

  public Movie(String title, int duration, int view, boolean release) {
    super(title, duration);
    this.view = view;
    this.release = release;
  }

  public int getView() {
    return view;
  }

  public boolean getRelease() {
    return release;
  }

  @Override
  public String toString() {
    return super.getTitle() + " (" + super.getDuration() + "분, " + getView() + "명, " + (getRelease() ? "상영중" : "상영중 아님") + ")";
  }
}
