package com.minesweeper.lab3.game.ConsoleView;

import com.minesweeper.lab3.game.Cells;

import java.util.List;

public class LostGameState extends ConsoleGameViewState {
    LostGameState(ConsoleGameView view){
        super(view);
    }

    @Override
    public void drawUI(List<Cells> field) {
        drawField(field);
        waitingStep();
    }

    private void waitingStep(){
        view.writer.println("You lost!");
        view.writer.println("Waiting \"Enter\" for exit to main menu: ");
        view.reader.nextLine();
        view.controller.closeGame();
    }
}
