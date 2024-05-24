package com.ass6.thread;

import static com.ass6.media.Media.lock;
import static com.ass6.media.Media.adFinished;
import static com.ass6.utils.InputUtils.getUserInput;
import static com.ass6.utils.PrintUtils.printLine;

public class AdThread extends Thread{
  @Override
  public void run() {
    try {
      //로딩 시작 후 2초뒤
      Thread.sleep(2000);
      printLine();
      System.out.println("| 💡 (광고): 이번 주 최다 시청수를 기록한 영상을 놓치지 마세요!");
      //광고 출력 후 2초 뒤 광거 건너뛰기 문구 출력
      Thread.sleep(2000);

      //사용자가 0을 입력하면 광고가 종료되고
      int keepWatchAd = getUserInput("| 💡 광고를 건너뛰겠습니까? (0: 광고 건너뛰기, 1: 계속 시청): ", 0, 1);

      if (keepWatchAd == 0) {
        System.out.println("| 💡 광고 건너뛰기 완료됐습니다.");
      }

      if (keepWatchAd == 1) {
        System.out.println("| 💡 추가 광고 시청 중...");
        Thread.sleep(3000); // 추가 광고 시간
        System.out.println("| 💡 광고가 끝났습니다.");
      }

      synchronized (lock) {
        adFinished = true;
        lock.notifyAll(); // 광고가 끝났음을 알림
      }

    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      System.out.println("| ⚠️ 광고가 중단되었습니다. ");
    }
  }
}

