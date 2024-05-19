package com.ass6.media;

public class ActionMovie extends Movie {
  private String film;

  public ActionMovie(String title, int duration, int view, boolean release, String film) {
    super(title, duration, view, release);
    this.film = film;
  }

  public String getFilm() {
    return film;
  }

  @Override
  public String toString() {
    return super.toString() + " - " + getFilm();
  }
}
