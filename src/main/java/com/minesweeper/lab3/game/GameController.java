package com.minesweeper.lab3.game;

public class GameController {
    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void setStep(int x, int y){
        model.setStep(x, y);
    }

    public void setFlag(int x, int y){
        model.setFlag(x,y);
    }

    public void deleteFlag(int x, int y){
        model.deleteFlag(x, y);
    }

    public void endGame(){
        //TODO endGame
    }

    private GameModel model;
    private GameView view;
}
