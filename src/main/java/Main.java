import messages.MessagePrinter;
import messages.Messages;

import javax.print.DocFlavor;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
  
  public static void main(String[] args) {
  
    Supplier<String> input = () -> new Scanner(System.in).nextLine();
  
    MessagePrinter.printMessage(Messages.FAREWALL);
    }
}
