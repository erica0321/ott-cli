package com.ass6;

import com.ass6.medias.*;
import com.ass6.member.Admin;
import com.ass6.member.Player;
import com.ass6.member.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import static com.ass6.PlayerAction.showPlayerAction;
import static com.ass6.PrintBanner.printInBox;
import static com.ass6.PrintBanner.printLine;

public class Main {
  public static List<Media> medias = new ArrayList<Media>(10);
  public static List<Entertainment> entertainments = new ArrayList<Entertainment>(10);
  public static List<Drama> dramas = new ArrayList<Drama>(10);
  public static List<RomanticDrama> romanticDramas = new ArrayList<RomanticDrama>(10);
  public static List<CrimeDrama> crimeDramas = new ArrayList<CrimeDrama>(10);
  public static List<HistoricalDrama> historicalDramas = new ArrayList<HistoricalDrama>(10);
  public static List<Movie> movies = new ArrayList<Movie>(10);
  public static List<SadMovie> sadMovies = new ArrayList<SadMovie>(10);
  public static List<ActionMovie> actionMovies = new ArrayList<ActionMovie>(10);

  private static List<User> users = new ArrayList<User>();
  private static User logInUser; // User 타입으로 변경


  public static void main(String[] args) {
    String banner = "  _  __   ____    _____       _____    _______   _______ \n" +
        " | |/ /  / __ \\  |  ___|     /  _  \\  |__   __| |__   __|\n" +
        " | ' /  | |  |_| | |___     | |   | |    | |       | |   \n" +
        " |  <   | |      |___  |    | |   | |    | |       | |   \n" +
        " | . \\  | |__|¯|  ___| |    | | _ | |    | |       | |   \n" +
        " |_|\\_\\  \\____/  |_____|     \\_____/     |_|       |_|   \n";

    String message = "예능, 드라마, 영화 스트리밍 하세요!";
    printInBox(banner, message);

    boolean goBack = false;

    //영상 목록 불러오기
    loadingMedias();
    //유저 목록 불러오기
    loadingUsers();

    //로그인 하기
    User logInUser = logIn();

    if (logInUser instanceof Player) {
      System.out.println("| 🤗 " + logInUser.getId() + " 님 환영합니다.");
      showPlayerAction((Player) logInUser); // 캐스팅
    } else if (logInUser instanceof Admin) {
      System.out.println("| 🤗 관리자님 환영합니다.");
      showAdminAction((Admin) logInUser );
    }

  }

  // 정보 불러오기
  private static void loadingMedias() {
    medias.add(new Media("KBS 9시 뉴스", 60));

    entertainments.add(new Entertainment("신서유기", 90, "tvN"));
    entertainments.add(new Entertainment("환승연애", 120, "tvN"));
    entertainments.add(new Entertainment("런닝맨", 100, "SBS"));
    entertainments.add(new Entertainment("무한도전", 90, "MBC"));

    dramas.add(new Drama("더 글로리", 60, 16, 8.5));
    dramas.add(new Drama("재벌집 막내아들", 70, 16, 8.2));
    dramas.add(new Drama("이상한 변호사 우영우", 60, 16, 9.1));
    dramas.add(new Drama("환혼", 70, 20, 8.8));
    dramas.add(new Drama("스물다섯 스물하나", 75, 16, 8.7));

    crimeDramas.add(new CrimeDrama("시그널", 60, 16, 9.1, "미해결 사건"));
    crimeDramas.add(new CrimeDrama("악의 꽃", 70, 16, 8.8, "연쇄 살인"));
    crimeDramas.add(new CrimeDrama("괴물", 65, 16, 8.7, "살인"));
    crimeDramas.add(new CrimeDrama("빈센조", 80, 20, 8.5, "조직 범죄"));
    crimeDramas.add(new CrimeDrama("비밀의 숲", 60, 16, 9.0, "부정부패"));

    historicalDramas.add(new HistoricalDrama("미스터 션샤인", 70, 24, 9.1, "조선 말기"));
    historicalDramas.add(new HistoricalDrama("해를 품은 달", 60, 20, 8.5, "조선 시대"));
    historicalDramas.add(new HistoricalDrama("동이", 60, 60, 8.2, "조선 시대"));
    historicalDramas.add(new HistoricalDrama("육룡이 나르샤", 70, 50, 8.9, "조선 건국기"));
    historicalDramas.add(new HistoricalDrama("왕이 된 남자", 60, 16, 8.7, "조선 중기"));

    romanticDramas.add(new RomanticDrama("사랑의 불시착", 70, 16, 8.9, "손예진", "현빈"));
    romanticDramas.add(new RomanticDrama("그 해 우리는", 60, 16, 8.5, "김다미", "최우식"));
    romanticDramas.add(new RomanticDrama("선재 업고 튀어", 80, 16, 8.3, "김혜윤", "변우석"));
    romanticDramas.add(new RomanticDrama("눈물의 여왕", 90, 16, 9.0, "김지원", "김수현"));
    romanticDramas.add(new RomanticDrama("꽃보다 남자", 70, 25, 8.8, "구혜선", "이민호"));

    movies.add(new Movie("기생충", 132, 10000000, false));
    movies.add(new Movie("부산행", 118, 11500000, false));
    movies.add(new Movie("밀정", 140, 7500000, false));

    sadMovies.add(new SadMovie("비와 당신의 이야기", 117, 350000, true, "이루어질 수 없는 사랑"));
    sadMovies.add(new SadMovie("너의 결혼식", 110, 600000, true, "첫사랑의 실패"));

    actionMovies.add(new ActionMovie("부산행", 118, 11500000, true, "Next Entertainment World"));
    actionMovies.add(new ActionMovie("베테랑", 123, 13400000, true, "CJ Entertainment"));
    actionMovies.add(new ActionMovie("암살", 140, 12700000, true, "Showbox"));
    actionMovies.add(new ActionMovie("매드맥스: Fury Road", 120, 10000000, true, "Warner Bros."));
    actionMovies.add(new ActionMovie("존 윅", 101, 5000000, true, "Summit Entertainment"));
  }

  private static void loadingUsers() {
    users.add(new Player("player1", "Qwer123!", null, "", 0));
    users.add(new Admin("admin1", "Qwer123!", "top"));
  }

  // 로그인 로직
  private static User logIn() {
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

  private static void showAdminAction(Admin admin) {
    boolean again = false;
    do {
      printLine();
      System.out.print("| 🫧 무엇을 하시겠습니까? (1: 영상 등록, 2: 영상 삭제, 0: 프로그램 종료): ");
      Scanner input = new Scanner(System.in);
      int actionType = input.nextInt();

      if (actionType == 0) {
        exitSystem();
      }

      if (actionType == 1) {
        addMedia();
      }

    } while (again);
  }

  public static void printMediaType() {
    System.out.println("| 1. 일반 TV 쇼");
    System.out.println("| 2. 예능");
    System.out.println("| 3. 일반 드라마");
    System.out.println("| 4. 범죄 드라마");
    System.out.println("| 5. 로맨스 드라마");
    System.out.println("| 6. 역사 드라마");
    System.out.println("| 7. 일반 영화");
    System.out.println("| 8. 슬픈 영화");
    System.out.println("| 9. 액션 영화");
    System.out.println("| 0. 프로그램 종료");

  }

  private static void addMedia() {
    printLine();
    System.out.println("| 📢 영상 등록하기를 선택하셨습니다. 다음은 영상 타입입니다.");
    printMediaType();
    printLine();
    System.out.print("| 🫧 등록할 영상 타입 번호를 입력해주세요: ");

    Scanner input = new Scanner(System.in);
    int mediaType = input.nextInt();

    switch(mediaType) {
      case 0:
        exitSystem();
        return;
      case 1:
        makeEntertainment();
        return;
      case 2:
        makeDrama();
        return;
      case 3:
        makeCrimeDrama();
        return;
      case 4:
        makeRomanticDrama();
        return;
      case 5:
        makeHistoricalDrama();
        return;
      case 6:
        makeMovie();
        return;
      case 7:
        makeSadMovie();
        return;
      case 8:
        makeActionMovie();
        return;
    }
  }

  public static void exitSystem() {
    System.out.println("| ⚠️ KCS OTT를 종료합니다. 이용해주셔서 감사합니다.");
    printLine();
    System.exit(0);
  }
}