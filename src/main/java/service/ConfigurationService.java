package service;

import player.Player;
import table.Table;
import table.entity.wrapper.TableSize;
import user.io.input.asker.ConfigurationAsker;
import user.io.wrapper.IOEntity;

public class ConfigurationService {
  
  IOEntity ioEntity;
  ConfigurationAsker configurationAsker;
  
  public ConfigurationService(IOEntity ioEntity) {
    this.ioEntity = ioEntity;
    configurationAsker = new ConfigurationAsker(ioEntity);
  }
  
  public Table configureTable() {
    TableSize tableSize = configurationAsker.askForTableSizes();
    int howMuchSignsToWin = configurationAsker.askForHowMuchSignsToWin(tableSize);
    
    return Table.of(tableSize, howMuchSignsToWin);
  }
  
  public Player configurePlayerName() {
    return configurationAsker.askForPlayersName();
  }
}