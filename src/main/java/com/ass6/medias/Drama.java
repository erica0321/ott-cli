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

  public void setEpisodes(int episodes) {
    this.episodes = episodes;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  @Override
  public String toString() {
    return super.getTitle() + " (" + super.getDuration() + "분, 총 " + episodes + "회, 평점 " + rating + ")";
  }
}
