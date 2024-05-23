package com.ass6.media;

import com.ass6.advertisement.AdTask;
import com.ass6.user.Player;

import java.util.List;

import static com.ass6.data.Medias.*;
import static com.ass6.utils.PlayerActionConstant.*;
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

  public Media() { }

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
    return getMedias(mediaType);
  }

  //영상 목록 속 영상들 보여주기 및 시청
  public static boolean showMedia(List<? extends Media> medias) {
    if (medias == null || medias.isEmpty()) {
      return getUserInput("| ⚠️ 영상이 없습니다. 프로그램을 종료하시겠습니까? (0: 종료, 1: 다른 활동하기): ", 0, 1) == 1;
    }

    printMediaList(medias);

    int mediaNum = getUserInput("| 🫧 시청하실 영상의 번호를 입력해주세요: ", 1, medias.size());
    Media targetMedia = medias.get(mediaNum - 1);
    System.out.println("| 🍿 '" + targetMedia + "'을 시청중입니다.");
    ((Player) logInUser).addWatched(targetMedia);

    //광고 스레드 실행
    AdTask adTask = new AdTask();
    adTask.start();

    // 5초 대기
    try {
      adTask.join();
      System.out.println("| 💡 광고 시청이 종료되었습니다.");
      printLine();
      System.out.println("| 🍿 '" + targetMedia + "'을 계속 시청중입니다.");
      Thread.sleep(5000);
    } catch (
        InterruptedException e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    }

    printLine();
    return

        getUserInput("| ⚠️ 영상이 끝났습니다. 프로그램을 종료하시겠습니까? (0: 종료, 1: 다른 활동하기): ", 0, 1) == 1;
  }
}
