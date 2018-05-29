package service;

import table.Table;
import table.entity.wrapper.TableSize;
import user.input.asker.ConfigurationAsker;
import user.io.wrapper.IOEntity;

public class ConfigurationService {
  
  public static Table configureGame(IOEntity ioEntity) {
    ConfigurationAsker configurationAsker = new ConfigurationAsker(ioEntity);
    
    TableSize tableSize = configurationAsker.askForTableSizes();
    
    int howMuchSignsToWin = configurationAsker.askForHowMuchSignsToWin();
    
    return Table.of(tableSize, howMuchSignsToWin);
  }
}