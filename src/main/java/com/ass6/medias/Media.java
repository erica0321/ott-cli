package com.ass6.medias;

import com.ass6.member.Player;

import java.util.List;

import static com.ass6.constant.PlayerActionConstant.*;
import static com.ass6.Main.*;
import static com.ass6.utils.InputUtils.getUserInput;
import static com.ass6.utils.PrintUtils.*;

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
}
