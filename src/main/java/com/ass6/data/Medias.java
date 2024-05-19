package com.ass6.data;

import com.ass6.media.*;
import com.ass6.utils.AlreadyExistException;

import java.util.ArrayList;
import java.util.List;

public class Medias {
  public static List<Media> medias = new ArrayList<>(10);
  public static List<Entertainment> entertainments = new ArrayList<>(10);
  public static List<Drama> dramas = new ArrayList<>(10);
  public static List<RomanticDrama> romanticDramas = new ArrayList<>(10);
  public static List<CrimeDrama> crimeDramas = new ArrayList<>(10);
  public static List<HistoricalDrama> historicalDramas = new ArrayList<>(10);
  public static List<Movie> movies = new ArrayList<>(10);
  public static List<SadMovie> sadMovies = new ArrayList<>(10);
  public static List<ActionMovie> actionMovies = new ArrayList<>(10);

  static {
    medias.add(new Media("KBS 9시 뉴스", 60));

    entertainments.add(new Entertainment("신서유기", 90, "tvN"));
    entertainments.add(new Entertainment("환승연애", 120, "tvN"));
    entertainments.add(new Entertainment("런닝맨", 100, "SBS"));
    entertainments.add(new Entertainment("무한도전", 90, "MBC"));

    dramas.add(new Drama("더 글로리", 60, 16, 8.5));
    dramas.add(new Drama("재벌집 막내아들", 70, 16, 8.2));
    dramas.add(new Drama("이상한 변호사 우영우", 60, 16, 9.1));
    dramas.add(new Drama("환혼", 70, 20, 8.8));
    dramas.add(new Drama("스물다섯 스물하나", 75, 16, 8.7));

    crimeDramas.add(new CrimeDrama("시그널", 60, 16, 9.1, "미해결 사건"));
    crimeDramas.add(new CrimeDrama("악의 꽃", 70, 16, 8.8, "연쇄 살인"));
    crimeDramas.add(new CrimeDrama("괴물", 65, 16, 8.7, "살인"));
    crimeDramas.add(new CrimeDrama("빈센조", 80, 20, 8.5, "조직 범죄"));
    crimeDramas.add(new CrimeDrama("비밀의 숲", 60, 16, 9.0, "부정부패"));

    historicalDramas.add(new HistoricalDrama("미스터 션샤인", 70, 24, 9.1, "조선 말기"));
    historicalDramas.add(new HistoricalDrama("해를 품은 달", 60, 20, 8.5, "조선 시대"));
    historicalDramas.add(new HistoricalDrama("동이", 60, 60, 8.2, "조선 시대"));
    historicalDramas.add(new HistoricalDrama("육룡이 나르샤", 70, 50, 8.9, "조선 건국기"));
    historicalDramas.add(new HistoricalDrama("왕이 된 남자", 60, 16, 8.7, "조선 중기"));

    romanticDramas.add(new RomanticDrama("사랑의 불시착", 70, 16, 8.9, "손예진", "현빈"));
    romanticDramas.add(new RomanticDrama("그 해 우리는", 60, 16, 8.5, "김다미", "최우식"));
    romanticDramas.add(new RomanticDrama("선재 업고 튀어", 80, 16, 8.3, "김혜윤", "변우석"));
    romanticDramas.add(new RomanticDrama("눈물의 여왕", 90, 16, 9.0, "김지원", "김수현"));
    romanticDramas.add(new RomanticDrama("꽃보다 남자", 70, 25, 8.8, "구혜선", "이민호"));

    movies.add(new Movie("기생충", 132, 10000000, false));
    movies.add(new Movie("부산행", 118, 11500000, false));
    movies.add(new Movie("밀정", 140, 7500000, false));

    sadMovies.add(new SadMovie("비와 당신의 이야기", 117, 350000, true, "이루어질 수 없는 사랑"));
    sadMovies.add(new SadMovie("너의 결혼식", 110, 600000, true, "첫사랑의 실패"));

    actionMovies.add(new ActionMovie("부산행", 118, 11500000, true, "Next Entertainment World"));
    actionMovies.add(new ActionMovie("베테랑", 123, 13400000, true, "CJ Entertainment"));
    actionMovies.add(new ActionMovie("암살", 140, 12700000, true, "Showbox"));
    actionMovies.add(new ActionMovie("매드맥스: Fury Road", 120, 10000000, true, "Warner Bros."));
    actionMovies.add(new ActionMovie("존 윅", 101, 5000000, true, "Summit Entertainment"));
  }

  public List<Media> getMedias() {
    return medias;
  }

  public List<Entertainment> getEntertainments() {
    return entertainments;
  }

  public List<Drama> getDramas() {
    return dramas;
  }

  public List<RomanticDrama> getRomanticDramas() {
    return romanticDramas;
  }

  public List<CrimeDrama> getCrimeDramas() {
    return crimeDramas;
  }

  public List<HistoricalDrama> getHistoricalDramas() {
    return historicalDramas;
  }

  public List<Movie> getMovies() {
    return movies;
  }

  public List<SadMovie> getSadMovies() {
    return sadMovies;
  }

  public List<ActionMovie> getActionMovies() {
    return actionMovies;
  }

  public void addMedia(Media media) throws AlreadyExistException {
    for( Media mediaInstance : medias) {
      String old = mediaInstance.toString().replaceAll(" ",  "");
      String newOne = media.toString().replaceAll(" ", "");
      if(old.equals(newOne)) {
        throw new AlreadyExistException();
      }
    }
    medias.add(media);
  }

  public void addEntertainment(Entertainment media) throws AlreadyExistException {
    for( Entertainment mediaInstance : entertainments) {
      String old = mediaInstance.toString().replaceAll(" ",  "");
      String newOne = media.toString().replaceAll(" ", "");
      if(old.equals(newOne)) {
        throw new AlreadyExistException();
      }
    }
    entertainments.add(media);
  }

  public void addDrama(Drama media) throws AlreadyExistException {
    for( Drama mediaInstance : dramas) {
      String old = mediaInstance.toString().replaceAll(" ",  "");
      String newOne = media.toString().replaceAll(" ", "");
      if(old.equals(newOne)) {
        throw new AlreadyExistException();
      }
    }
    dramas.add(media);
  }

  public void addCrimeDrama(CrimeDrama media) throws AlreadyExistException {
    for( CrimeDrama mediaInstance : crimeDramas) {
      String old = mediaInstance.toString().replaceAll(" ",  "");
      String newOne = media.toString().replaceAll(" ", "");
      if(old.equals(newOne)) {
        throw new AlreadyExistException();
      }
    }
    crimeDramas.add(media);
  }

  public void addRomanticDrama(RomanticDrama media) throws AlreadyExistException {
    for( RomanticDrama mediaInstance : romanticDramas) {
      String old = mediaInstance.toString().replaceAll(" ",  "");
      String newOne = media.toString().replaceAll(" ", "");
      if(old.equals(newOne)) {
        throw new AlreadyExistException();
      }
    }
    romanticDramas.add(media);
  }

  public void addHistoricalDrama(HistoricalDrama media) throws AlreadyExistException {
    for( HistoricalDrama mediaInstance : historicalDramas) {
      String old = mediaInstance.toString().replaceAll(" ",  "");
      String newOne = media.toString().replaceAll(" ", "");
      if(old.equals(newOne)) {
        throw new AlreadyExistException();
      }
    }
    historicalDramas.add(media);
  }

  public void addMovie(Movie media) throws AlreadyExistException {
    for( Movie mediaInstance : movies) {
      String old = mediaInstance.toString().replaceAll(" ",  "");
      String newOne = media.toString().replaceAll(" ", "");
      if(old.equals(newOne)) {
        throw new AlreadyExistException();
      }
    }
    movies.add(media);
  }

  public void addSadMovie(SadMovie media) throws AlreadyExistException {
    for( SadMovie mediaInstance : sadMovies) {
      String old = mediaInstance.toString().replaceAll(" ",  "");
      String newOne = media.toString().replaceAll(" ", "");
      if(old.equals(newOne)) {
        throw new AlreadyExistException();
      }
    }
    sadMovies.add(media);
  }

  public void addActionMovie(ActionMovie media) throws AlreadyExistException {
    for( ActionMovie mediaInstance : actionMovies) {
      String old = mediaInstance.toString().replaceAll(" ",  "");
      String newOne = media.toString().replaceAll(" ", "");
      if(old.equals(newOne)) {
        throw new AlreadyExistException();
      }
    }
    actionMovies.add(media);
  }
}
