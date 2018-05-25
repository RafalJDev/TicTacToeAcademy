package table.wrapper;

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
}