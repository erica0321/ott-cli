package com.ass6.data;

import com.ass6.user.Admin;
import com.ass6.user.Player;
import com.ass6.user.User;

import java.util.ArrayList;
import java.util.Scanner;

import static com.ass6.Main.exitSystem;

public class Users {
  private static ArrayList<User> users = new ArrayList<>();

  static {
    users.add(new Player("player1", "Qwer123!", new ArrayList<>()));
    users.add(new Admin("admin1", "Qwer123!", "top"));
  }


  public static User logIn() {
    System.out.println("| 📢 로그인을 선택하셨습니다. ");
    Scanner input = new Scanner(System.in);
    System.out.print("| 🫧 아이디를 입력해주세요: ");
    String inputId = input.nextLine();
    System.out.print("| 🫧 비밀번호를 입력해주세요: ");
    String inputPassword = input.nextLine();

    for (User user : users) {
      if (user.getId().equals(inputId) && user.getPassword().equals(inputPassword)) {
        return user;
      }
    }

    System.out.println("| ⚠️ 입력하신 아이디와 비밀번호에 해당하는 사용자가 없습니다.");
    input.close();
    exitSystem();
    return null;
  }
}
