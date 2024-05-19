package com.ass6.mediaFactory;

import com.ass6.media.ActionMovie;
import com.ass6.media.Media;

import java.util.Scanner;

public class ActionMovieFactory implements MediaFactory{
  @Override
  public Media createMedia(Scanner input) {
    System.out.println("| 📢 액션 영화를 등록합니다.");
    System.out.print("| 🫧 제목을 입력해주세요: ");
    String title = input.next();
    System.out.print("| 🫧 영상 시간을 입력해주세요 (단위: 분) : ");
    int duration = input.nextInt();
    System.out.print("| 🫧 관객수를 입력해주세요: ");
    int view = input.nextInt();
    System.out.print("| 🫧 현재 상영 여부를 입력해주세요( true, false ): ");
    boolean release = input.nextBoolean();
    System.out.print("| 🫧 영화사를 입력해주세요: ");
    String film = input.next();
    return new ActionMovie(title, duration, view, release, film);
  }
}
