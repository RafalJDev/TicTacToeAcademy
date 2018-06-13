package table.entity.wrapper;

public final class TableData {
  
  private final TableConfiguration tableConfiguration;
  
  private int filledCells = 0;
  
  public TableData(TableConfiguration tableConfiguration) {
    this.tableConfiguration = tableConfiguration;
    this.filledCells = 0;
  }
  
  public int getTableSizeOnX() {
    return tableConfiguration.getTableSizeOnX();
  }
  
  public int getTableSizeOnY() {
    return tableConfiguration.getTableSizeOnY();
  }
  
  public int getHowMuchSignsToWin() {
    return tableConfiguration.getHowMuchSignsToWin();
  }
  
  public void incrementFilledCells() {
    filledCells++;
  }
  
  public int getFilledCells() {
    return filledCells;
  }
  
  public boolean isTableFilled() {
    return getFilledCells() >= getCountOfSigns();
  }
  
  public int getCountOfSigns() {
    return getTableSizeOnX() * getTableSizeOnY();
  }
  
}