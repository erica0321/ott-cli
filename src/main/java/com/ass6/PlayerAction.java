package com.ass6;

import com.ass6.medias.*;
import com.ass6.member.*;

import java.util.List;
import java.util.Scanner;

import static com.ass6.Main.*;
import static com.ass6.PrintBanner.printLine;


//로그인 이후 시청하기 / 시청기록보기 활동 안내
public class PlayerAction {
  public static void showPlayerAction(Player player) {
    printLine();
    System.out.print("| 🫧 무엇을 하시겠습니까? (1: 시청하기, 2: 시청기록 보기, 0: 프로그램 종료): ");
    Scanner input = new Scanner(System.in);
    int actionType = input.nextInt();

    if (actionType == 0) {
      exitSystem();
    }

    boolean again = false;
    if (actionType == 1) {
      do {
        List<? extends Media> targetMedias = showMediaType();
        String isAgain = showMedia(targetMedias, player);

        if (isAgain.equals("Y")) {
          again = true;
        } else {
          again = false;
          exitSystem();
        }
      } while (again);
    }

    if (actionType == 2) {
      showWatchedList(player); // player를 인자로 전달
    }
  }

  private static List<? extends Media> showMediaType() {
    printLine();
    System.out.println("| 📢 시청하기를 선택하셨습니다.다음은 영상 타입입니다.");
    printMediaType();
    printLine();
    System.out.print("| 🫧 시청할 영상 타입 번호를 입력해주세요: ");

    Scanner input = new Scanner(System.in);

    int mediaType = input.nextInt();

    if (mediaType == 0) {
      exitSystem();
    }

    if (mediaType < 0 || mediaType > 9) {
      System.out.println("| ⚠️ 올바르지 않은 영상 타입입니다.");
      exitSystem();
    }

    List<? extends Media> targetMedias = checkActions(mediaType);
    return targetMedias;
  }

  private static void showWatchedList(Player player) {
    List<? extends Media> watchedMedias = player.getWatched();
    printLine();
    System.out.println("| 📢 시청기록 보기를 선택하셨습니다. 다음은 시청 기록입니다.");
    int index = 1;
    if (watchedMedias == null) {
      System.out.println("| ⚠️ 시청 기록이 없습니다.");
      exitSystem();
    }
    for (Media media : watchedMedias) {
      System.out.println("| " + (index++) + ". " + media.toString());
    }
    printLine();
  }

  private static String showMedia(List<? extends Media> medias, Player player) {
    int index = 1;
    printLine();
    System.out.println("| 📢 선택하신 타입의 영상 목록입니다.");
    for (Media media : medias) {
      if (media != null) {
        System.out.println("| " + (index++) + ". " + media.toString());
      }
    }
    printLine();
    System.out.print("| 🫧 시청하실 영상의 번호를 입력해주세요: ");
    Scanner input = new Scanner(System.in);
    int mediaNum = input.nextInt();
    printLine();

    Media targetMedia = medias.get(mediaNum - 1);

    System.out.println("| 🍿 '" + medias.get(mediaNum - 1) + "'을 시청중입니다.");
    player.addWatched(targetMedia);

    try {
      // 5초 대기
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // 5초 후 메시지 출력
    System.out.print("| ⚠️ 영상이 끝났습니다. 다른 영상을 보시겠습니까? (Y: 예, N: 아니오): ");
    return input.next();
  }

  private static List<? extends Media> checkActions(int type) {
    switch (type) {
      case 1:
        return medias;
      case 2:
        return entertainments;
      case 3:
        return dramas;
      case 4:
        return crimeDramas;
      case 5:
        return romanticDramas;
      case 6:
        return historicalDramas;
      case 7:
        return movies;
      case 8:
        return sadMovies;
      case 9:
        return actionMovies;
      default:
        return null;
    }
  }
}
