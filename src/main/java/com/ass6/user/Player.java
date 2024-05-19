package com.ass6.user;

import com.ass6.media.Media;

import java.util.List;

import static com.ass6.utils.PlayerActionConstant.*;
import static com.ass6.Main.*;
import static com.ass6.media.Media.showMedia;
import static com.ass6.media.Media.showMediaType;
import static com.ass6.utils.InputUtils.getUserInput;
import static com.ass6.utils.PrintUtils.printLine;
import static com.ass6.utils.PrintUtils.printLogOut;

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

  public void showPlayerAction() {
    printLine();

    //액션 입력
    while (true) {
      int actionType = getUserInput("| 🫧 무엇을 하시겠습니까? (1: 시청하기, 2: 시청기록 보기, 3: 로그아웃, 0: 프로그램 종료): ", 0, 3);

      switch (actionType) {
        case EXIT:
          exitSystem();
          return;
        case VIEW_MEDIA:
          List<? extends Media> targetMedias = showMediaType();
          boolean isAgain = showMedia(targetMedias);
          printLine();
          if (isAgain) continue;
          else exitSystem();
          break;
        case VIEW_HISTORY:
          isAgain = showWatchedList();
          printLine();
          if (!isAgain) exitSystem();
          break;
        case LOGOUT:
          printLogOut();
          return;
      }
    }
  }

  //시청 기록 보기
  private boolean showWatchedList() {
    List<? extends Media> watchedMedias = getWatched();
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


