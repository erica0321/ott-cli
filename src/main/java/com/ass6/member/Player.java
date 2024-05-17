package com.ass6.member;

import com.ass6.medias.Media;

import java.util.ArrayList;
import java.util.List;

public class Player extends User{
  private List<Media> watched = new ArrayList<>();
  private String action;
  private int selectMedia;

  public Player() {
  }

  public Player(String id, String password, List<Media> watched, String action, int selectMedia) {
    super(id, password);
    this.watched = watched;
    this.action = action;
    this.selectMedia = selectMedia;
  }

  public List<Media> getWatched() {
    return watched;
  }

  public void addWatched(Media media) {
    watched.add(media);
  }

  public void setWatched(List<Media> watched) {
    this.watched = watched;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public int getSelectMedia() {
    return selectMedia;
  }

  public void setSelectMedia(int selectMedia) {
    this.selectMedia = selectMedia;
  }
}


