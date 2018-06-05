import service.game.TicTacToe;
import user.io.wrapper.IOEntity;

import java.util.Scanner;

class Main {
  
  public static void main(String[] args) {
  
    TicTacToe ticTacToe = new TicTacToe();
    ticTacToe.letsPlay(IOEntity.of(new Scanner(System.in)::nextLine, System.out::println));
  }
}