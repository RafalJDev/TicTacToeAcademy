package table.entity.wrapper;

public final class TableSize {
  
  private final int tableSizeOnX;
  private final int tableSizeOnY;
  
  public TableSize(int tableSizeOnX, int tableSizeOnY) {
    this.tableSizeOnX = tableSizeOnX;
    this.tableSizeOnY = tableSizeOnY;
  }
  
  public int getTableSizeOnX() {
    return tableSizeOnX;
  }
  
  public int getTableSizeOnY() {
    return tableSizeOnY;
  }
  
  public boolean checkIfNumberIsMoreThanSizeOnX(int number) {
    return number > tableSizeOnX;
  }
  
  public boolean checkIfNumberIsMoreThanSizeOnY(int number) {
    return number > tableSizeOnY;
  }
  
  public boolean checkIfNumberIsMoreThanSize(int number) {
    return checkIfNumberIsMoreThanSizeOnX(number)
        && checkIfNumberIsMoreThanSizeOnY(number);
  }
  
  public String sayToMeHowBigYouAre() {
    return "Table is wide as: "
        + tableSizeOnX
        + " and tall as: "
        + tableSizeOnY
        + ".";
  }
}