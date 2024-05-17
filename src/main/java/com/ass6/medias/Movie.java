package com.ass6.medias;

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

  public void setView(int view) {
    this.view = view;
  }

  public boolean isRelease() {
    return release;
  }

  public void setRelease(boolean release) {
    this.release = release;
  }

  @Override
  public String toString() {
    return super.getTitle() + " (" + super.getDuration() + "분, " + view + "명, " + (release ? "상영중" : "상영중 아님") + ")";
  }
}
