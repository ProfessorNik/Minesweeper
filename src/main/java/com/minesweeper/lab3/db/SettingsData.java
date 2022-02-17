package com.minesweeper.lab3.db;

public abstract class SettingsData {
    protected Settings settings;

    public void setStandardSettings(){
        settings.userName = "player";
        settings.sizeX = settings.sizeY = 9;
        settings.numBomb = 10;
    }
    abstract public void downloadData();
    abstract public void saveData();
}
