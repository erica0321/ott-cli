package com.ass6.mediaFactory;

import com.ass6.media.Media;
import com.ass6.media.RomanticDrama;

import java.util.Scanner;

public class RomanticDramaFactory implements MediaFactory{
  @Override
  public Media createMedia(Scanner input) {
    System.out.println("| 📢 로맨스 드라마를 등록합니다.");
    System.out.print("| 🫧 제목을 입력해주세요: ");
    String title = input.next();
    System.out.print("| 🫧 영상 시간을 입력해주세요 (단위: 분) : ");
    int duration = input.nextInt();
    System.out.print("| 🫧 몇부작인지 입력해주세요: ");
    int episodes = input.nextInt();
    System.out.print("| 🫧 평점이 몇점인지 입력해주세요: ");
    double rating = input.nextDouble();
    System.out.print("| 🫧 여자주인공을 입력해주세요: ");
    String actorF = input.next();
    System.out.print("| 🫧 남자주인공을 입력해주세요: ");
    String actorM = input.next();
    return new RomanticDrama(title, duration, episodes, rating, actorF, actorM);
  }
}
