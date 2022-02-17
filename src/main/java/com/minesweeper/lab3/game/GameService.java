package com.minesweeper.lab3.game;

import com.minesweeper.lab3.Minesweeper;
import com.minesweeper.lab3.Service;
import com.minesweeper.lab3.game.ConsoleView.ConsoleGameView;

public class GameService implements Service {
    public GameService(Minesweeper minesweeper, UI type){
        this.minesweeper = minesweeper;
        model = new GameModel();
        controller = new GameController(this, model);
        buildUI(type);
    }

    public void start(){
        model.newGame();
    }

    private void buildUI(UI type){
        view = new ConsoleGameView(model, controller);
        //TODO change UI
    }

    public void exitToMainMenu() {
        minesweeper.toMainMenu();
    }

    private final GameModel model;
    private final GameController controller;
    private final Minesweeper minesweeper;
    private GameView view;
}
