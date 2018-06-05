package user.io.input.asker;

import user.io.input.InputReader;
import user.io.wrapper.IOEntity;

public abstract class Asker {
  
  protected final IOEntity localIO;
  
  public Asker(IOEntity localIO) {
    this.localIO = localIO;
  }
  
  protected int readLineToInt() {
    String s = InputReader.readLine(localIO);
    return Integer.parseInt(s);
  }
  
  protected String readLineToString() {
    return localIO.getInput();
  }
}
