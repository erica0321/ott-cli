package com.ass6.member;

import com.ass6.medias.Media;

import java.util.ArrayList;
import java.util.List;

public class Player extends User{
  private List<Media> watched;

  public Player(String id, String password, List<Media> watched) {
    super(id, password);
    this.watched = watched;
  }

  public List<Media> getWatched() {
    return watched;
  }

  public void addWatched(Media media) {
    watched.add(0, media);
  }

  public void setWatched(List<Media> watched) {
    this.watched = watched;
  }
}


