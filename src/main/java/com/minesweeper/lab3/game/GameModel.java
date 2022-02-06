package com.minesweeper.lab3.game;

import com.minesweeper.lab3.game.field.BackgroundField;
import com.minesweeper.lab3.game.field.ForegroundField;
import com.minesweeper.lab3.game.observer.GameObservable;
import com.minesweeper.lab3.game.observer.GameObserver;

import java.util.List;

public class GameModel extends GameObservable {
    GameModel(int sizeX, int sizeY, int numBomb) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.numBomb = numBomb;
    }

    public void newGame() {
        foregroundField = new ForegroundField(sizeX, sizeY);
        foregroundField.generateField();

        backgroundField = new BackgroundField(sizeX, sizeY, numBomb);
        backgroundField.generateField();
    }

    public void setStep(int x, int y) {
        if(foregroundField.isUnknownCell(x, y)) {
            Cells openingCell = backgroundField.getCell(x, y);
            if (openingCell == Cells.BOMB) {
                foregroundField.copyField(backgroundField);
                endGame();
            } else {
                foregroundField.setCell(x, y, openingCell);
            }
        }
    }

    public void setFlag(int x, int y) {
        if(foregroundField.isUnknownCell(x, y)) {
            foregroundField.setCell(x, y, Cells.FLAG);
        }
    }

    public void deleteFlag(int x, int y){
        if(foregroundField.getCell(x, y) == Cells.FLAG) {
            foregroundField.setCell(x, y, Cells.UNKNOWN);
        }
    }

    public void endGame() {
        //TODO endgame
    }

    @Override
    public List<Cells> getField(){
        return foregroundField.getField();
    }

    private final int sizeX;
    private final int sizeY;
    private final int numBomb;
    private BackgroundField backgroundField;
    private ForegroundField foregroundField;
}
