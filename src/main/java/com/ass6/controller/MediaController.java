package com.ass6.controller;

import com.ass6.data.Medias;
import com.ass6.mediaFactory.*;
import com.ass6.media.*;
import com.ass6.utils.AlreadyExistException;

import java.util.*;

import static com.ass6.media.Media.*;
import static com.ass6.utils.InputUtils.getUserInput;
import static com.ass6.utils.PrintUtils.*;

public class MediaController {

  private static Medias medias = new Medias();

  public static void addMedia() {
    printLine();

    boolean keepAdding = true;

    while (keepAdding) {
      System.out.println("| 📢 영상 등록을 선택하셨습니다. 다음은 영상 타입입니다.");
      printMediaType();
      printLine();

      int mediaType = getUserInput("| 🫧 등록할 영상 타입 번호를 입력해주세요 : ", 1, 9);
      switch (mediaType) {
        case 1 -> addMediaFactory(new MediaFactoryImpl());
        case 2 -> addMediaFactory(new EntertainmentFactory());
        case 3 -> addMediaFactory(new DramaFactory());
        case 4 -> addMediaFactory(new CrimeDramaFactory());
        case 5 -> addMediaFactory(new RomanticDramaFactory());
        case 6 -> addMediaFactory(new HistoricalDramaFactory());
        case 7 -> addMediaFactory(new MovieFactory());
        case 8 -> addMediaFactory(new SadMovieFactory());
        case 9 -> addMediaFactory(new ActionMovieFactory());
      }

      int keepAdd = getUserInput("| ⚠️ 계속 등록하시겠습니까? (0: 예, 1: 아니오): ", 0, 1);
      if (keepAdd == 1) {
        keepAdding = false;
      }
      printLine();
    }
  }

  public static void deleteMedia() {
    printLine();
    boolean keepDeleting = true;

    while (keepDeleting) {
      System.out.println("| 📢 영상 삭제를 선택하셨습니다. 다음은 영상 타입입니다.");
      printMediaType();
      printLine();

      // 영상 삭제
      deleteMediaDetail();

      int keepDelete = getUserInput("| ⚠️ 계속 삭제하시겠습니까? (0: 예, 1: 아니오): ", 0, 1);
      if (keepDelete == 1) {
        keepDeleting = false;
      }
      printLine();
    }
  }

  private static void addMediaFactory(MediaFactory factory) {
    Scanner input = new Scanner(System.in);
    printLine();

    Media media;
    boolean isValidInput = false;
    while (!isValidInput) {
      try {
        media = factory.createMedia(input);
        addMediaToCollection(media);
        isValidInput = true;

        printLine();
        System.out.println("| 📢 등록이 완료됐습니다. 등록된 내용은 다음과 같습니다.");
        System.out.println("| " + media.toString());
        printLine();
        break;
      } catch (InputMismatchException e) {
        printInputError();
        input.nextLine();
      } catch (AlreadyExistException e) {
        isValidInput = true;
        printAlreadyExist();
      }
    }
  }

  private static void addMediaToCollection(Media media) throws AlreadyExistException {
    if (media instanceof Entertainment) medias.addEntertainment((Entertainment) media);
    else if (media instanceof CrimeDrama) medias.addCrimeDrama((CrimeDrama) media);
    else if (media instanceof RomanticDrama) medias.addRomanticDrama((RomanticDrama) media);
    else if (media instanceof HistoricalDrama) medias.addHistoricalDrama((HistoricalDrama) media);
    else if (media instanceof SadMovie) medias.addSadMovie((SadMovie) media);
    else if (media instanceof ActionMovie) medias.addActionMovie((ActionMovie) media);
    else if (media instanceof Drama) medias.addDrama((Drama) media);
    else if (media instanceof Movie) medias.addMovie((Movie) media);
    else medias.addMedia(media);
  }

  private static void deleteMediaDetail() {
    int mediaType = getUserInput("| 🫧 삭제할 영상 타입 번호를 입력해주세요: ", 1, 9);
    List<? extends Media> targetMedias = checkActions(mediaType);

    if (targetMedias.isEmpty()) {
      System.out.println("| ⚠️ 영상이 없습니다.");
      printLine();
      return;
    }

    // 영상 목록 보여주기
    printMediaList(targetMedias);

    int mediaNum = getUserInput("| 🫧 삭제하실 영상의 번호를 입력해주세요: ", 1, targetMedias.size()) - 1;

    try {
      targetMedias.remove(mediaNum);
      System.out.println("| 📢 영상이 삭제되었습니다.");
      printLine();
    } catch (IndexOutOfBoundsException e) {
      printInputError();
    }
  }

}
