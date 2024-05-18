package com.ass6;

import com.ass6.medias.*;
import com.ass6.member.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.ass6.Main.*;
import static com.ass6.PrintBanner.printLine;


//로그인 이후 시청하기 / 시청기록보기 활동 안내
public class PlayerAction {

  private static final int VIEW_MEDIA = 1;
  private static final int VIEW_HISTORY = 2;
  private static final int LOGOUT = 3;
  private static final int EXIT = 0;
  private static final int MIN_MEDIA_TYPE = 1;
  private static final int MAX_MEDIA_TYPE = 9;

  public static void showPlayerAction(Player player) {
    printLine();
    Scanner input = new Scanner(System.in);

    //액션 입력
    while (true) {
      int actionType = getUserInput("| 🫧 무엇을 하시겠습니까? (1: 시청하기, 2: 시청기록 보기, 3: 로그아웃, 0: 프로그램 종료): ", 0, 3);

      switch (actionType) {
        case EXIT:
          exitSystem();
          return;
        case VIEW_MEDIA:
          List<? extends Media> targetMedias = showMediaType();
          boolean isAgain = showMedia(targetMedias, player);
          printLine();
          if (isAgain) continue;
          else exitSystem();
          break;
        case VIEW_HISTORY:
          isAgain = showWatchedList(player);
          printLine();
          if (!isAgain) exitSystem();
          break;
        case LOGOUT:
          printLogOut();
          return;
      }
    }
  }


  //시청하기 시, 영상 타입 보여주기
  private static List<? extends Media> showMediaType() {
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
  private static boolean showMedia(List<? extends Media> medias, Player player) {
    showMediaList(medias);

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

  //시청 기록 보기
  private static boolean showWatchedList(Player player) {
    Scanner input = new Scanner(System.in);

    List<? extends Media> watchedMedias = player.getWatched();
    printLine();
    System.out.println("| 📢 시청기록 보기를 선택하셨습니다. 다음은 시청 기록입니다.");

    if (watchedMedias == null || watchedMedias.isEmpty()) {
      return getUserInput("| ⚠️ 시청 기록이 없습니다. 프로그램을 종료하시겠습니까? (0: 종료, 1: 다른 활동하기): ", 0, 1) == 1;
    }

    int index = 1;
    for (Media media : watchedMedias) {
      if (media != null) {
        System.out.println("| " + (index++) + ". " + media.toString());
      }
    }

    printLine();
    return getUserInput("| ⚠️ 시청 기록이 더 이상 없습니다. 프로그램을 종료하시겠습니까? (0: 종료, 1: 다른 활동하기): ", 0, 1) == 1;
  }
}
