package com.ass6.medias;

import com.ass6.member.Player;

import java.util.List;

import static com.ass6.PlayerActionConstants.*;
import static com.ass6.Main.*;
import static com.ass6.Main.getUserInput;
import static com.ass6.PrintBanner.printLine;

public class Media {
  private String title;
  private int duration;

  public Media(String title, int duration) {
    this.title = title;
    this.duration = duration;
  }

  public String getTitle() {
    return title;
  }

  public int getDuration() {
    return duration;
  }

  public String toString() {
    return getTitle() + " (" + getDuration() + "분)";
  }

  public static void printMediaType() {
    System.out.println("| 1. 일반 TV 쇼");
    System.out.println("| 2. 예능");
    System.out.println("| 3. 일반 드라마");
    System.out.println("| 4. 범죄 드라마");
    System.out.println("| 5. 로맨스 드라마");
    System.out.println("| 6. 역사 드라마");
    System.out.println("| 7. 일반 영화");
    System.out.println("| 8. 슬픈 영화");
    System.out.println("| 9. 액션 영화");
  }

  //시청하기 시, 영상 타입 보여주기
  public static List<? extends Media> showMediaType() {
    printLine();
    System.out.println("| 📢 시청하기를 선택하셨습니다.다음은 영상 타입입니다.");
    printMediaType();
    printLine();

    //시청할 영상 타입 번호 입력
    int mediaType = getUserInput("| 🫧 시청할 영상 타입 번호를 입력해주세요: ", MIN_MEDIA_TYPE, MAX_MEDIA_TYPE);
    return checkActions(mediaType);
  }

  //영상 타입에 따른 영상 목록 전달
  public static List<? extends Media> checkActions(int type) {
    return switch (type) {
      case 1 -> medias;
      case 2 -> entertainments;
      case 3 -> dramas;
      case 4 -> crimeDramas;
      case 5 -> romanticDramas;
      case 6 -> historicalDramas;
      case 7 -> movies;
      case 8 -> sadMovies;
      case 9 -> actionMovies;
      default -> null;
    };
  }

  //영상 목록 속 영상들 보여주기 및 시청
  public static boolean showMedia(List<? extends Media> medias, Player player) {
    printMediaList(medias);

    int mediaNum = getUserInput("| 🫧 시청하실 영상의 번호를 입력해주세요: ", 1, medias.size());
    Media targetMedia = medias.get(mediaNum - 1);
    System.out.println("| 🍿 '" + targetMedia + "'을 시청중입니다.");
    player.addWatched(targetMedia);

    // 5초 대기
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    printLine();
    return getUserInput("| ⚠️ 영상이 끝났습니다. 프로그램을 종료하시겠습니까? (0: 종료, 1: 다른 활동하기): ", 0, 1) == 1;
  }

  public static void printMediaList(List<? extends Media> medias) {
    int index = 1;
    printLine();
    System.out.println("| 📢 선택하신 타입의 영상 목록입니다.");
    for (Media media : medias) {
      if (media != null) {
        System.out.println("| " + (index++) + ". " + media.toString());
      }
    }
    printLine();
  }

}
