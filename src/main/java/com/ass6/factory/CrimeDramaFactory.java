package com.ass6.factory;

import com.ass6.medias.CrimeDrama;
import com.ass6.medias.Media;

import java.util.Scanner;

public class CrimeDramaFactory implements MediaFactory{
  @Override
  public Media createMedia(Scanner input) {
    System.out.println("| 📢 범죄 드라마를 등록합니다.");
    System.out.print("| 🫧 제목을 입력해주세요: ");
    String title = input.next();
    System.out.print("| 🫧 영상 시간을 입력해주세요 (단위: 분) : ");
    int duration = input.nextInt();
    System.out.print("| 🫧 몇부작인지 입력해주세요: ");
    int episodes = input.nextInt();
    System.out.print("| 🫧 평점이 몇점인지 입력해주세요: ");
    double rating = input.nextDouble();
    System.out.print("| 🫧 범죄 종류를 입력해주세요: ");
    String crimeType = input.next();
    return new CrimeDrama(title, duration, episodes, rating, crimeType);
  }
}
