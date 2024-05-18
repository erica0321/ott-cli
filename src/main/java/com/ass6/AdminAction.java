package com.ass6;

import com.ass6.member.Admin;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.ass6.Main.*;
import static com.ass6.PrintBanner.printLine;
import static com.ass6.medias.AddMedia.addMedia;
import static com.ass6.medias.EraseMedia.eraseMedia;

public class AdminAction {

  private static final int ADD_MEDIA = 1;
  private static final int ERASE_MEDIA = 2;
  private static final int LOGOUT = 3;
  private static final int EXIT = 0;

  static void showAdminAction(Admin admin) {
    Scanner input = new Scanner(System.in);
    while (true) {
      printLine();
      int actionType = getUserInput("| 🫧 무엇을 하시겠습니까? (1: 영상 등록, 2: 영상 삭제, 3: 로그아웃, 0: 프로그램 종료): ", 0, 3);

      switch (actionType) {
        case EXIT:
          exitSystem();
          return;
        case ADD_MEDIA:
          addMedia();
          break;
        case ERASE_MEDIA:
          eraseMedia();
          break;
        case LOGOUT:
          printLogOut();
          return;
      }
    }
  }
}
