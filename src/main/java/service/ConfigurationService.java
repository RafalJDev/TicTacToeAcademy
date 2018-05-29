package service;

import table.TableArray;
import table.wrapper.TableSize;
import user.input.asker.ConfigurationAsker;
import user.io.wrapper.IOEntity;

public class ConfigurationService {
  
  public static TableArray configureGame(IOEntity ioEntity) {
    ConfigurationAsker configurationAsker = new ConfigurationAsker(ioEntity);
    
    TableSize tableSize = configurationAsker.askForTableSizes();
    
    int howMuchSignsToWin = configurationAsker.askForHowMuchSignsToWin();
    
    return TableArray.of(tableSize, howMuchSignsToWin);
  }
}