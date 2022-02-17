package com.minesweeper.lab3.game;

import com.minesweeper.lab3.game.field.BackgroundField;
import com.minesweeper.lab3.game.field.ForegroundField;
import com.minesweeper.lab3.game.observer.GameObservable;

import java.util.List;

public class GameModel extends GameObservable {
    GameModel() {
    }

    public void newGame() {
        foregroundField = new ForegroundField(sizeX, sizeY);
        foregroundField.generateField();

        backgroundField = new BackgroundField(sizeX, sizeY, numBomb);
        backgroundField.generateField();

        curState = State.GAME;
        notifyObservers();
    }

    public void setStep(int x, int y) {
        if(foregroundField.isUnknownCell(x, y)) {
            Cells openingCell = backgroundField.getCell(x, y);
            if (openingCell == Cells.BOMB) {
                foregroundField.copyField(backgroundField);
                lostGame();
                return;
            } else {
                foregroundField.setCell(x, y, openingCell);
                if(isWinGame()){
                    winGame();
                    return;
                }
            }
        }
        notifyObservers();
    }

    public void setFlag(int x, int y) {
        if(foregroundField.isUnknownCell(x, y)) {
            foregroundField.setCell(x, y, Cells.FLAG);
        }
        notifyObservers();
    }

    public void deleteFlag(int x, int y){
        if(foregroundField.getCell(x, y) == Cells.FLAG) {
            foregroundField.setCell(x, y, Cells.UNKNOWN);
        }
        notifyObservers();
    }

    public void lostGame() {
        curState = State.LOST_GAME;
        notifyObservers();
    }

    public void winGame() {
        curState = State.WIN_GAME;
        notifyObservers();
    }

    public boolean isWinGame() {
        for(int x = 0; x < sizeX; x++){
            for(int y = 0; y < sizeY; y++){
                if(foregroundField.isUnknownCell(x, y)
                        && backgroundField.getCell(x, y) != Cells.BOMB){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public List<Cells> getField(){
        return foregroundField.getField();
    }

    @Override
    public State getState() {
        return curState;
    }

    @Override
    public int getSizeX() {
        return sizeX;
    }

    @Override
    public int getSizeY() {
        return sizeY;
    }


    private final int sizeX = 9;
    private final int sizeY = 9;
    private final int numBomb = 10;
    private State curState;
    private BackgroundField backgroundField;
    private ForegroundField foregroundField;
}
