package com.ass6.factory;

import com.ass6.media.Media;

import java.util.Scanner;

public interface MediaFactory {
  Media createMedia(Scanner input);
}
