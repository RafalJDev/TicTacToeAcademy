package user.input.asker;

import user.input.InputReader;
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
}
