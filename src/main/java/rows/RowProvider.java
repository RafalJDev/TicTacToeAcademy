package rows;

import coordinates.Coordinates;
import table.Table;

public abstract class RowProvider {
  
  public abstract String getRowToString(Table table, Coordinates currentCoordinates);
}
