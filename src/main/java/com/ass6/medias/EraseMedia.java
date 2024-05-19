package com.ass6.medias;

import java.util.List;
import java.util.Scanner;

import static com.ass6.Main.*;
import static com.ass6.PrintBanner.printLine;
import static com.ass6.medias.Media.*;

public class EraseMedia {
  public static void eraseMedia() {
    printLine();
    Scanner input = new Scanner(System.in);

    while (true) {
      System.out.println("| 📢 영상 삭제를 선택하셨습니다. 다음은 영상 타입입니다.");
      printMediaType();
      printLine();

      // 영상 삭제
      deleteMedia();

      int keepDelete = getUserInput("| ⚠️ 계속 삭제하시겠습니까? (0: 예, 1: 아니오): ", 0, 1);
      if (keepDelete == 1) {
        return;
      }
      printLine();
    }
  }

  private static void deleteMedia() {
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
