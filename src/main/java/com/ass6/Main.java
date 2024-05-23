package com.ass6;

import com.ass6.user.Admin;
import com.ass6.user.Player;
import com.ass6.user.User;

import static com.ass6.data.Users.logIn;
import static com.ass6.utils.PrintUtils.*;

public class Main {
  public static User logInUser;
  public static boolean keepRunning = true;

  public static void main(String[] args) {

    while (keepRunning) {
      String banner = "  _  __   ____    _____       _____    _______   _______ \n" +
          " | |/ /  / __ \\  |  ___|     /  _  \\  |__   __| |__   __|\n" +
          " | ' /  | |  |_| | |___     | |   | |    | |       | |   \n" +
          " |  <   | |      |___  |    | |   | |    | |       | |   \n" +
          " | . \\  | |__|¯|  ___| |    | | _ | |    | |       | |   \n" +
          " |_|\\_\\  \\____/  |_____|     \\_____/     |_|       |_|   \n";

      String message = "예능, 드라마, 영화 스트리밍 하세요!";
      printInBox(banner, message);

      Thread loginThread = new Thread(() -> {
        logInUser = logIn(); // 별도의 스레드에서 로그인 처리
        postLogin(logInUser);
      });

      loginThread.start();

      try {
        loginThread.join(); // 메인 스레드는 로그인 스레드가 완료될 때까지 기다립니다.
      } catch (InterruptedException e) {
        System.out.println("로그인 스레드가 중단되었습니다.");
      }

    }
  }

  public static void postLogin(User user) {
    if (logInUser instanceof Player) {
      System.out.println("| 🤗 " + logInUser.getId() + " 님 환영합니다.");
      ((Player) logInUser).showAction(); // 캐스팅
    } else if (logInUser instanceof Admin) {
      System.out.println("| 🤗 관리자님 환영합니다.");
      ((Admin) logInUser).showAction();
    }
  }

  public static void exitSystem() {
    keepRunning = true;
    System.out.println("| ⚠️ KCS OTT를 종료합니다. 이용해주셔서 감사합니다.");
    printLine();
    System.exit(0);
  }
}
