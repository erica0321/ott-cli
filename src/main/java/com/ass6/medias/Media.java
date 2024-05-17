package com.ass6.medias;

public class Media {
  private String title;
  private int duration;

  public Media(String title, int duration) {
    this.title = title;
    this.duration = duration;
  }

  public String getTitle() {
    return title;
  }

  public int getDuration() {
    return duration;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public String toString() {
    return title + " (" + duration + "분)";
  }
}
