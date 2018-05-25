import service.game.TicTacToe;
import user.io.wrapper.IOEntity;

import java.util.Scanner;

class Main {
  
  public static void main(String[] args) {
  
    TicTacToe ticTacToe = new TicTacToe();
    ticTacToe.letsPlay(IOEntity.of(new Scanner(System.in)::nextLine, System.out::println));
    
//    System.out.println(13 / 4);
//    System.out.println(13 % 4);
//
//    System.out.println();
//    System.out.println((13 - 1) / 4);
//    System.out.println((13 - 1) % 4);
//    System.out.println();
//
//    System.out.println(16 / 4);
//    System.out.println(16 % 4);
//
//    System.out.println();
//    System.out.println((16 - 1) / 4);
//    System.out.println((16 - 1) % 4);
//    System.out.println();
//
//    System.out.println();
//    System.out.println((16 - 1) / 5);
//    System.out.println((16 - 1) % 5);
//    System.out.println();
//
//    System.out.println();
//    System.out.println((3 - 1) / 3);
//    System.out.println((3 - 1) % 3);
//    System.out.println();
//
//    System.out.println();
//    System.out.println((5 - 1) / 3);
//    System.out.println((5 - 1) % 3);
//    System.out.println();
  }
}