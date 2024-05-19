package com.ass6.medias;

public class SadMovie extends Movie {
  private String reason;

  public SadMovie(String title, int duration, int view, boolean release, String reason) {
    super(title, duration, view, release);
    this.reason = reason;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  @Override
  public String toString() {
    return super.toString() + " - " + getReason() ;
  }
}
