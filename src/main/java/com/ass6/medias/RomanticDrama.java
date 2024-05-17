package com.ass6.medias;

public class RomanticDrama extends Drama {
  private String actorF;
  private String actorM;

  public RomanticDrama(String title, int duration, int episodes, double rating, String actorF, String actorM) {
    super(title, duration, episodes, rating);
    this.actorF = actorF;
    this.actorM = actorM;
  }

  public String getActorF() {
    return actorF;
  }

  public void setActorF(String actorF) {
    this.actorF = actorF;
  }

  public String getActorM() {
    return actorM;
  }

  public void setActorM(String actorM) {
    this.actorM = actorM;
  }

  @Override
  public String toString() {
    return super.toString() + " - 여자 주인공: " + actorF + ", 남자 주인공: " + actorM;
  }
}