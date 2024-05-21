package com.ass6.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.ass6.utils.PrintUtils.printInputError;

public class InputUtils {
  //유저 input 받기
  public static int getUserInput(String message, int min, int max) {
    Scanner input = new Scanner(System.in);
    int result = 0;
    boolean validInput = false;

    while (!validInput) {
      System.out.print(message);
      try {
        result = input.nextInt();
        if (result < min || result > max) {
          throw new InvalidInputException();
        }
        validInput = true;  // 유효한 입력을 받으면 루프 종료
      } catch (InputMismatchException e) {
        printInputError();
        input.next(); // 잘못된 입력을 버퍼에서 제거
      } catch (InvalidInputException e) {
        printInputError();
      }
    }
    return result;
  }
}
