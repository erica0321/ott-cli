package com.ass6.media;

public class Entertainment extends Media {
  private String channel;

  public Entertainment(String title, int duration, String channel) {
    super(title, duration);
    this.channel = channel;
  }

  public String getChannel() {
    return channel;
  }

  @Override
  public String toString() {
    return super.getTitle() + " (" + super.getDuration() + "분, " + this.channel + ")";
  }
}

