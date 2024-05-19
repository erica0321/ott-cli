package com.ass6.utils;

import com.ass6.media.Media;

import java.util.List;

public class PrintUtils {
  private static int boxWidth = 0;

  public static void printInputError() {
    System.out.println("| ⚠️ 올바르지 않은 입력입니다. 다시 입력해주세요.");
    printLine();
  }

  public static void printLogOut() {
    printLine();
    System.out.println("| ⚠️ 로그아웃되었습니다.");
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
  }

  public static void printMediaList(List<? extends Media> medias) {
    int index = 1;
    printLine();
    System.out.println("| 📢 선택하신 타입의 영상 목록입니다.");
    for (Media media : medias) {
      if (media != null) {
        System.out.println("| " + (index++) + ". " + media.toString());
      }
    }
    printLine();
  }

  public static void printInBox(String banner, String message) {
    String[] bannerLines = banner.split("\n");
    int maxLineLength = 0;
    for (String line : bannerLines) {
      int length = line.length();
      if (length > maxLineLength) {
        maxLineLength = length;
      }
    }

    int messageLength = getDisplayWidth(message);
    boxWidth = Math.max(maxLineLength, messageLength) + 4;

    printLine();  // 상단 경계선
    for (String line : bannerLines) {
      System.out.println("| " + padRight(line, maxLineLength) + " |");
    }
    printLine();  // 경계선
    System.out.println("| " + padRight(message, boxWidth - 13) + " |");  // 메시지 출력
    printLine();  // 하단 경계선
  }

  public static void printLine() {
    for (int i = 0; i < boxWidth; i++) {
      System.out.print("-");
    }
    System.out.println();
  }

  private static String padRight(String s, int n) {
    return String.format("%-" + n + "s", s);
  }

  private static int getDisplayWidth(String s) {
    int width = 0;
    for (char c : s.toCharArray()) {
      if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HANGUL_SYLLABLES ||
          Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HANGUL_JAMO ||
          Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO) {
        width += 2;  // 한글 문자는 두 칸으로 계산
      } else {
        width += 1;  // 기타 문자는 한 칸으로 계산
      }
    }
    return width;
  }
}
