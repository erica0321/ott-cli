package com.ass6.user;

import java.util.Scanner;

import static com.ass6.Main.*;
import static com.ass6.utils.AdminActionConstant.*;
import static com.ass6.controller.MediaController.addMedia;
import static com.ass6.controller.MediaController.deleteMedia;
import static com.ass6.utils.InputUtils.getUserInput;
import static com.ass6.utils.PrintUtils.printLine;
import static com.ass6.utils.PrintUtils.printLogOut;

public class Admin extends User implements Actionable{
  private String role;

  public Admin(String id, String password, String role) {
    super(id, password);
    this.role = role;
  }

  @Override
  public void showAction() {
    boolean keepAdminAction = true;
    while (keepAdminAction) {
      printLine();
      int actionType = getUserInput("| 🫧 무엇을 하시겠습니까? (1: 영상 등록, 2: 영상 삭제, 3: 로그아웃, 0: 프로그램 종료): ", 0, 3);

      switch (actionType) {
        case EXIT:
          keepAdminAction = false;
          exitSystem();
          break;
        case ADD_MEDIA:
          addMedia();
          break;
        case ERASE_MEDIA:
          deleteMedia();
          break;
        case LOGOUT:
          keepAdminAction = false;
          printLogOut();
          break;
        default:
          break;
      }
    }
  }

}
