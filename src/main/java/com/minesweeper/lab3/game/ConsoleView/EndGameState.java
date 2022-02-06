package com.minesweeper.lab3.game.ConsoleView;

import com.minesweeper.lab3.game.Cells;

import java.util.ArrayList;
import java.util.List;

public class EndGameState extends ConsoleGameViewState {
    EndGameState(ConsoleGameView view){
        super(view);
    }

    @Override
    public void drawUI(List<Cells> field) {
        drawField(field);
        waitingStep();
    }

    private void waitingStep(){
        view.writer.print("Waiting \"Enter\" for exit to main menu: ");
        view.reader.nextLine();
    }
}
