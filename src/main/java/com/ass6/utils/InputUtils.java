package com.ass6.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.ass6.utils.PrintUtils.printInputError;

public class InputUtils {
  //유저 input 받기
  public static int getUserInput(String message, int min, int max) {
    Scanner input = new Scanner(System.in);
    int result;

    while (true) {
      System.out.print(message);
      try {
        result = input.nextInt();
        if (result < min || result > max) {
          throw new InvalidInputException();
        }
        break;
      } catch (InputMismatchException e) {
        printInputError();
        input.next();
      } catch (InvalidInputException e) {
        printInputError();
      }
    }
    return result;
  }
}
