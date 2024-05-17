package com.ass6.medias;

import java.util.Scanner;

import static com.ass6.Main.*;
import static com.ass6.PrintBanner.printLine;

public class AddMovie {

  public  static void addMedia() {
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
        makeMedia();
        return;
      case 2:
        makeEntertainment();
        return;
      case 3:
        makeDrama();
        return;
      case 4:
        makeCrimeDrama();
        return;
      case 5:
        makeRomanticDrama();
        return;
      case 6:
        makeHistoricalDrama();
        return;
      case 7:
        makeMovie();
        return;
      case 8:
        makeSadMovie();
        return;
      case 9:
        makeActionMovie();
        return;
    }
  }

  public static void makeMedia() {
    Scanner input = new Scanner(System.in);
    printLine();
    System.out.println("| 📢 일반 TV 쇼를 등록합니다.");
    System.out.print("| 🫧 제목을 입력해주세요: ");
    String title = input.nextLine();
    System.out.print("| 🫧 영상 시간을 입력해주세요: ");
    int duration = input.nextInt();
    Media media = new Media(title, duration);
    medias.add(media);

    printLine();
    System.out.println("| 📢 등록이 완료됐습니다. 등록된 내용은 다음과 같습니다.");
    System.out.println(media.toString());
    input.close();
  }

  public static void makeEntertainment() {
    Scanner input = new Scanner(System.in);
    printLine();
    System.out.println("| 📢 일반 TV 쇼를 등록합니다.");
    System.out.print("| 🫧 제목을 입력해주세요: ");
    String title = input.nextLine();
    System.out.print("| 🫧 영상 시간을 입력해주세요: ");
    int duration = input.nextInt();
    System.out.print("| 🫧 방송 채널을 입력해주세요: ");
    String channel = input.next();

    Entertainment entertainment = new Entertainment(title, duration, channel);
    entertainments.add(entertainment);

    printLine();
    System.out.println("| 📢 등록이 완료됐습니다. 등록된 내용은 다음과 같습니다.");
    System.out.println(entertainment.toString());
    printLine();
    input.close();
  }

  public static void makeDrama() {
    Scanner input = new Scanner(System.in);
    printLine();
    System.out.println("| 📢 일반 드라마를 등록합니다.");
    System.out.print("| 🫧 제목을 입력해주세요: ");
    String title = input.nextLine();
    System.out.print("| 🫧 영상 시간을 입력해주세요: ");
    int duration = input.nextInt();;
    System.out.print("| 🫧 몇부작인지 입력해주세요: ");
    int episodes = input.nextInt();
    System.out.print("| 🫧 평점이 몇점인지 입력해주세요: ");
    double rating = input.nextDouble();

    Drama drama = new Drama(title, duration, episodes, rating);
    dramas.add(drama);

    printLine();
    System.out.println("| 📢 등록이 완료됐습니다. 등록된 내용은 다음과 같습니다.");
    System.out.println(drama.toString());
    printLine();
    input.close();
  }

  public static void makeCrimeDrama() {
    Scanner input = new Scanner(System.in);
    printLine();
    System.out.println("| 📢 범죄 드라마를 등록합니다.");
    System.out.print("| 🫧 제목을 입력해주세요: ");
    String title = input.nextLine();
    System.out.print("| 🫧 영상 시간을 입력해주세요: ");
    int duration = input.nextInt();
    System.out.print("| 🫧 몇부작인지 입력해주세요: ");
    int episodes = input.nextInt();
    System.out.print("| 🫧 평점이 몇점인지 입력해주세요: ");
    double rating = input.nextDouble();
    System.out.print("| 🫧 범죄 종류를 입력해주세요: ");
    String crimeType = input.next();

    CrimeDrama crimeDrama = new CrimeDrama(title, duration, episodes, rating, crimeType);
    crimeDramas.add(crimeDrama);

    printLine();
    System.out.println("| 📢 등록이 완료됐습니다. 등록된 내용은 다음과 같습니다.");
    System.out.println(crimeDrama.toString());
    printLine();
    input.close();
  }

  public static void makeRomanticDrama() {
    Scanner input = new Scanner(System.in);
    printLine();
    System.out.println("| 📢 로맨스 드라마를 등록합니다.");
    System.out.print("| 🫧 제목을 입력해주세요: ");
    String title = input.nextLine();
    System.out.print("| 🫧 영상 시간을 입력해주세요: ");
    int duration = input.nextInt();;
    System.out.print("| 🫧 몇부작인지 입력해주세요: ");
    int episodes = input.nextInt();
    System.out.print("| 🫧 평점이 몇점인지 입력해주세요: ");
    double rating = input.nextDouble();
    System.out.print("| 🫧 여자주인공을 입력해주세요: ");
    String actorF = input.nextLine();
    System.out.print("| 🫧 남자주인공을 입력해주세요: ");
    String actorM = input.next();

    RomanticDrama romanticDrama = new RomanticDrama(title, duration, episodes, rating, actorF, actorM);
    romanticDramas.add(romanticDrama);

    printLine();
    System.out.println("| 📢 등록이 완료됐습니다. 등록된 내용은 다음과 같습니다.");
    System.out.println(romanticDrama.toString());
    printLine();
    input.close();

  }

  public static void makeHistoricalDrama() {
    Scanner input = new Scanner(System.in);
    printLine();
    System.out.println("| 📢 역사 드라마를 등록합니다.");
    System.out.print("| 🫧 제목을 입력해주세요: ");
    String title = input.nextLine();
    System.out.print("| 🫧 영상 시간을 입력해주세요: ");
    int duration = input.nextInt();;
    System.out.print("| 🫧 몇부작인지 입력해주세요: ");
    int episodes = input.nextInt();
    System.out.print("| 🫧 평점이 몇점인지 입력해주세요: ");
    double rating = input.nextDouble();
    System.out.print("| 🫧 시대배경을 입력해주세요: ");
    String generation = input.next();

    HistoricalDrama historicalDrama = new HistoricalDrama(title, duration, episodes, rating, generation);
    historicalDramas.add(historicalDrama);

    printLine();
    System.out.println("| 📢 등록이 완료됐습니다. 등록된 내용은 다음과 같습니다.");
    System.out.println(historicalDrama.toString());
    printLine();
    input.close();
  }

  public static void makeMovie() {
    Scanner input = new Scanner(System.in);
    printLine();
    System.out.println("| 📢 일반 영화를 등록합니다.");
    System.out.print("| 🫧 제목을 입력해주세요: ");
    String title = input.nextLine();
    System.out.print("| 🫧 영상 시간을 입력해주세요: ");
    int duration = input.nextInt();
    System.out.print("| 🫧 관객수를 입력해주세요: ");
    int view = input.nextInt();
    System.out.print("| 🫧 현재 상영 여부를 입력해주세요: ");
    boolean release = input.nextBoolean();
    System.out.print("| 🫧 영화사를 입력해주세요: ");
    String film = input.next();

    ActionMovie actionMovie = new ActionMovie(title, duration, view, release, film);
    actionMovies.add(actionMovie);

    printLine();
    System.out.println("| 📢 등록이 완료됐습니다. 등록된 내용은 다음과 같습니다.");
    System.out.println(actionMovie.toString());
    printLine();
    input.close();

  }

  public static void makeSadMovie() {
    Scanner input = new Scanner(System.in);
    printLine();
    System.out.println("| 📢 슬픈 영화를 등록합니다.");
    System.out.print("| 🫧 제목을 입력해주세요: ");
    String title = input.nextLine();
    System.out.print("| 🫧 영상 시간을 입력해주세요: ");
    int duration = input.nextInt();
    System.out.print("| 🫧 관객수를 입력해주세요: ");
    int view = input.nextInt();
    System.out.print("| 🫧 현재 상영 여부를 입력해주세요: ");
    boolean release = input.nextBoolean();

    Movie movie = new Movie(title, duration, view, release);
    movies.add(movie);

    printLine();
    System.out.println("| 📢 등록이 완료됐습니다. 등록된 내용은 다음과 같습니다.");
    System.out.println(movie.toString());
    printLine();
    input.close();
  }

  public static void makeActionMovie() {
    Scanner input = new Scanner(System.in);
    printLine();
    System.out.println("| 📢 액션 영화를 등록합니다.");
    System.out.print("| 🫧 제목을 입력해주세요: ");
    String title = input.nextLine();
    System.out.print("| 🫧 영상 시간을 입력해주세요: ");
    int duration = input.nextInt();
    System.out.print("| 🫧 관객수를 입력해주세요: ");
    int view = input.nextInt();
    System.out.print("| 🫧 현재 상영 여부를 입력해주세요: ");
    boolean release = input.nextBoolean();
    System.out.print("| 🫧 영화사를 입력해주세요: ");
    String film = input.next();

    ActionMovie actionMovie = new ActionMovie(title, duration, view, release, film);
    actionMovies.add(actionMovie);

    printLine();
    System.out.println("| 📢 등록이 완료됐습니다. 등록된 내용은 다음과 같습니다.");
    System.out.println(actionMovie.toString());
    printLine();
    input.close();
  }
}
