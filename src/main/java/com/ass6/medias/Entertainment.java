package com.ass6.medias;

public class Entertainment extends Media {
  private String channel;

  public Entertainment(String title, int duration, String channel) {
    super(title, duration);
    this.channel = channel;
  }

  @Override
  public String toString() {
    return "제목: " + super.getTitle() + " (" + super.getDuration() + "분, " + channel + ")";
  }

}

