package com.ass6.medias;

import com.ass6.factory.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.ass6.Main.*;
import static com.ass6.medias.Media.printMediaType;
import static com.ass6.PrintBanner.printLine;

public class AddMedia {
  public static void addMedia() {
    printLine();

    while (true) {
      System.out.println("| 📢 영상 등록을 선택하셨습니다. 다음은 영상 타입입니다.");
      printMediaType();
      printLine();

      int mediaType = getUserInput("| 🫧 등록할 영상 타입 번호를 입력해주세요 : ", 1, 9);

      switch (mediaType) {
        case 1 -> makeMedia(new MediaFactoryImpl());
        case 2 -> makeMedia(new EntertainmentFactory());
        case 3 -> makeMedia(new DramaFactory());
        case 4 -> makeMedia(new CrimeDramaFactory());
        case 5 -> makeMedia(new RomanticDramaFactory());
        case 6 -> makeMedia(new HistoricalDramaFactory());
        case 7 -> makeMedia(new MovieFactory());
        case 8 -> makeMedia(new SadMovieFactory());
        case 9 -> makeMedia(new ActionMovieFactory());
      }

      int keepAdd = getUserInput("| ⚠️ 계속 등록하시겠습니까? (0: 예, 1: 아니오): ", 0, 1);
      if (keepAdd == 1) {
        return;
      }
      printLine();
    }
  }

  private static void makeMedia(MediaFactory factory) {
    Scanner input = new Scanner(System.in);
    printLine();

    while (true) {
      try {
        Media media = factory.createMedia(input);
        addMediaToCollection(media);
        printLine();
        System.out.println("| 📢 등록이 완료됐습니다. 등록된 내용은 다음과 같습니다.");
        System.out.println("| " + media.toString());
        printLine();
        break;
      } catch (InputMismatchException e) {
        printInputError();
        input.next();
      }
    }
  }

  private static void addMediaToCollection(Media media) {
    if (media instanceof Entertainment) {
      entertainments.add((Entertainment) media);
    } else if (media instanceof CrimeDrama) {
      crimeDramas.add((CrimeDrama) media);
    } else if (media instanceof RomanticDrama) {
      romanticDramas.add((RomanticDrama) media);
    } else if (media instanceof HistoricalDrama) {
      historicalDramas.add((HistoricalDrama) media);
    } else if (media instanceof SadMovie) {
      sadMovies.add((SadMovie) media);
    } else if (media instanceof ActionMovie) {
      actionMovies.add((ActionMovie) media);
    } else if (media instanceof Drama) {
      dramas.add((Drama) media);
    } else if (media instanceof Movie) {
      movies.add((Movie) media);
    } else {
      medias.add(media);
    }
  }
}
