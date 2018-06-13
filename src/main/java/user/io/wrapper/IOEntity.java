package user.io.wrapper;

import user.io.output.message.Messages;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class IOEntity {
  
  private Supplier<String> supplier;
  private Consumer<String> consumer;
  
  private IOEntity(Supplier<String> supplier, Consumer<String> consumer) {
    this.supplier = supplier;
    this.consumer = consumer;
  }
  
  public static IOEntity of(Supplier<String> supplier, Consumer<String> consumer) {
    return new IOEntity(supplier, consumer);
  }
  
  public String getInput() {
    return supplier.get();
  }
  
  public void acceptOutput(String toConsume) {
    consumer.accept(toConsume);
  }
  
  public void acceptOutput(Messages toConsume) {
    consumer.accept(toConsume.toString());
  }
}