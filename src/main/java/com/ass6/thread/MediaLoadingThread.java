package com.ass6.thread;

import com.ass6.media.Media;

import static com.ass6.media.Media.adFinished;
import static com.ass6.media.Media.lock;
import static com.ass6.utils.PrintUtils.printLine;

public class MediaLoadingThread extends Thread {
  private Media media;

  public MediaLoadingThread(Media media) {
    this.media = media;
  }

  @Override
  public void run() {
    synchronized (lock) {
      System.out.println("| 🎬 '" + media.getTitle() + "'을 로딩 중입니다...");

      try {
        //2초 동안 로딩
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("| ⚠️ 미디어 로딩이 중단되었습니다. ");
        return;
      }

      // 광고가 끝날 때까지 대기
      while (!adFinished) {
        try {
          //광고가 안끝나면 lock 반환
          lock.wait();
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          System.out.println("| ⚠️ 미디어 로딩이 중단되었습니다. ");
          return;
        }
      }
    }
    printLine();
    System.out.println("| 🎬 '" + media.getTitle() + "' 로딩이 완료되었습니다.");
    printLine();
  }
}