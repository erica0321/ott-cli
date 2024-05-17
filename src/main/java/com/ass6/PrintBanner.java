package com.ass6;

public class PrintBanner {
  private static int boxWidth = 0;
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
