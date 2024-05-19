package com.ass6.medias;

public class Drama extends Media {
  private int episodes;
  private double rating;

  public Drama(String title, int duration, int episodes, double rating) {
    super(title, duration);
    this.episodes = episodes;
    this.rating = rating;
  }

  public int getEpisodes() {
    return episodes;
  }

  public double getRating() {
    return rating;
  }

  @Override
  public String toString() {
    return super.getTitle() + " (" + super.getDuration() + "분, 총 " + getEpisodes() + "회, 평점 " + getRating() + ")";
  }
}
