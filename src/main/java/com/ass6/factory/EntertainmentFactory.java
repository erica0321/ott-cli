package com.ass6.factory;

import com.ass6.medias.Entertainment;
import com.ass6.medias.Media;

import java.util.Scanner;

public class EntertainmentFactory implements MediaFactory{
  @Override
  public Media createMedia(Scanner input) {
    System.out.println("| 📢 예능을 등록합니다.");
    System.out.print("| 🫧 제목을 입력해주세요: ");
    String title = input.nextLine();
    System.out.print("| 🫧 영상 시간을 입력해주세요 (단위: 분) : ");
    int duration = input.nextInt();
    System.out.print("| 🫧 방송 채널을 입력해주세요: ");
    String channel = input.next();
    return new Entertainment(title, duration, channel);
  }
}
