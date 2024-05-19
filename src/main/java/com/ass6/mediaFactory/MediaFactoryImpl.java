package com.ass6.mediaFactory;

import com.ass6.media.Media;

import java.util.Scanner;

public class MediaFactoryImpl implements MediaFactory {
  @Override
  public Media createMedia(Scanner input) {
    System.out.println("| 📢 일반 TV 쇼를 등록합니다.");
    System.out.print("| 🫧 제목을 입력해주세요: ");
    String title = input.nextLine();
    System.out.print("| 🫧 영상 시간을 입력해주세요 (단위: 분) : ");
    int duration = input.nextInt();
    return new Media(title, duration);
  }
}
