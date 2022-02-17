package com.minesweeper.lab3;

import com.minesweeper.lab3.game.GameService;
import com.minesweeper.lab3.mainmenu.MainMenuService;

public class Minesweeper {
    Minesweeper(Service.UI type){
        this.uiType = type;
    }

    public void startNewGame() {
        curService = new GameService(this, uiType);
        curService.start();
    }


    public void showHighScores() {
        
    }

    public void showSettings() {

    }

    public void toMainMenu() {
        curService = new MainMenuService(this, uiType);
        curService.start();
    }

    public void exit() {

    }

    private Service curService;
    private Service.UI uiType;
}
