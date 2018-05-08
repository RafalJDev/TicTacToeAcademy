package user.io.entity;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class IOEntity {
  
  private Supplier supplier;
  private Consumer consumer;
  
  private IOEntity(Supplier supplier, Consumer consumer) {
    this.supplier = supplier;
    this.consumer = consumer;
  }
  
  public static IOEntity of(Supplier supplier, Consumer consumer) {
    return new IOEntity(supplier, consumer);
  }
  
  public Supplier getSupplier() {
    return supplier;
  }
  
  public Object getInput() {
    return supplier.get();
  }
  
  public Consumer getConsumer() {
    return consumer;
  }
  
  public void acceptOutput(Object toConsume) {
    consumer.accept(toConsume);
  }
  
  
}