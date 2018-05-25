package table.wrapper;

public final class TableConfiguration {
  
  private final TableSize tableSize;
  private final int howMuchSignsToWin;
  
  public TableConfiguration(TableSize tableSize, int howMuchSignsToWin) {
    this.tableSize = tableSize;
    this.howMuchSignsToWin = howMuchSignsToWin;
  }
  
  public int getTableSizeOnX() {
    return tableSize.getTableSizeOnX();
  }
  
  public int getTableSizeOnY() {
    return tableSize.getTableSizeOnY();
  }
  
  public int getHowMuchSignsToWin() {
    return howMuchSignsToWin;
  }
}
