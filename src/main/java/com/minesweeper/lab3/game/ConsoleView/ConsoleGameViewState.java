package com.minesweeper.lab3.game.ConsoleView;

import com.minesweeper.lab3.game.Cells;
import com.minesweeper.lab3.game.State;

import java.util.List;

public abstract class ConsoleGameViewState {

    protected final ConsoleGameView view;

    public static ConsoleGameViewState changeState(State state, ConsoleGameView view) {
        if(state == State.GAME){
            return new GameState(view);
        }
        return new LostGameState(view);
    }

    ConsoleGameViewState(ConsoleGameView view){
        this.view = view;
    }

    abstract public void drawUI(List<Cells> field);

    protected void drawField(List<Cells> field) {
        view.writer.print("  ");
        for(int x = 0; x < view.sizeX; x++)
            view.writer.print(x + " ");
        view.writer.println();
        for(int y = 0; y < view.sizeY; y++){
            view.writer.print(y + " ");
            for(int x = 0; x < view.sizeX; x++){
                view.writer.print(view.cellsToChar(field.get(x + y * view.sizeX)) + " ");
            }
            view.writer.println();
        }
        view.writer.println();
    }
}
