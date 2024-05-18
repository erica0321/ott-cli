package com.ass6.factory;

import com.ass6.medias.Media;
import com.ass6.medias.SadMovie;

import java.util.Scanner;

public class SadMovieFactory implements MediaFactory {
  @Override
  public Media createMedia(Scanner input) {
    System.out.println("| 📢 슬픈 영화를 등록합니다.");
    System.out.print("| 🫧 제목을 입력해주세요: ");
    String title = input.next();
    System.out.print("| 🫧 영상 시간을 입력해주세요 (단위: 분) : ");
    int duration = input.nextInt();
    System.out.print("| 🫧 관객수를 입력해주세요: ");
    int view = input.nextInt();
    System.out.print("| 🫧 현재 상영 여부를 입력해주세요( true, false ): ");
    boolean release = input.nextBoolean();
    System.out.print("| 🫧 슬픔을 유발하는 사건을 단어로 입력해주세요: ");
    String reason = input.next();

    return new SadMovie(title, duration, view, release, reason);
  }
}
