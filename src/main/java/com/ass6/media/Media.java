package com.ass6.media;

import com.ass6.thread.AdThread;
import com.ass6.thread.MediaLoadingThread;
import com.ass6.user.Player;

import java.util.List;

import static com.ass6.data.Medias.*;
import static com.ass6.utils.PlayerActionConstant.*;
import static com.ass6.utils.InputUtils.getUserInput;
import static com.ass6.utils.PrintUtils.*;

public class Media {
  private String title;
  private int duration;

  // 광고 완료 플래그
  public static volatile boolean adFinished = false;
  // 동기화 객체
  public static final Object lock = new Object();

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

    //영상 로딩 스레드 실행
    adFinished = false;

    MediaLoadingThread mediaLoadingThread = new MediaLoadingThread(targetMedia);
    mediaLoadingThread.start();

    //광고 스레드 실행
    AdThread adThread = new AdThread();
    adThread.start();

    //광고 종료 대기
    try {
      adThread.join();
    } catch (
        InterruptedException e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    }

    // 영상 시청 대기
    try {
      mediaLoadingThread.join();
      System.out.println("| 🍿 '" + targetMedia + "'을 시청중입니다.");
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    }

    printLine();
    return getUserInput("| ⚠️ 영상이 끝났습니다. 프로그램을 종료하시겠습니까? (0: 종료, 1: 다른 활동하기): ", 0, 1) == 1;
  }
}
