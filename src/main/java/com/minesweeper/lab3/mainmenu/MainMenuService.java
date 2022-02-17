package com.minesweeper.lab3.mainmenu;

import com.minesweeper.lab3.Minesweeper;
import com.minesweeper.lab3.Service;
import com.minesweeper.lab3.game.ConsoleView.ConsoleGameView;
import com.minesweeper.lab3.game.GameController;
import com.minesweeper.lab3.game.GameModel;
import com.minesweeper.lab3.game.GameView;

public class MainMenuService implements Service {
    public MainMenuService(Minesweeper minesweeper, UI type){
        this.minesweeper = minesweeper;
        model = new MainMenuModel();
        controller = new MainMenuController(this, model);
        buildUI(type);
    }

    private void buildUI(UI type){
        view = new ConsoleMainMenuView(model, controller);
        //TODO change UI
    }

    public void goTo(MenuOptions options){
        switch (options){
            case NEW_GAME -> minesweeper.startNewGame();
            case HIGH_SCORES -> minesweeper.showHighScores();
            case SETTINGS -> minesweeper.showSettings();
            case EXIT -> minesweeper.exit();
        }
    }


    @Override
    public void start() {
        model.startMainMenu();
    }


    private final MainMenuModel model;
    private final MainMenuController controller;
    private final Minesweeper minesweeper;
    private  ConsoleMainMenuView view;
}
