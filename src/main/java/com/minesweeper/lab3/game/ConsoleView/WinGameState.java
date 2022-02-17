package com.minesweeper.lab3.game.ConsoleView;

import com.minesweeper.lab3.game.Cells;

import java.util.List;

public class WinGameState extends ConsoleGameViewState{
    WinGameState(ConsoleGameView view) {
        super(view);
    }

    @Override
    public void drawUI(List<Cells> field) {
        view.writer.println("You win!");
        view.writer.println("Waiting \"Enter\" for exit to main menu: ");
        view.reader.nextLine();
        view.controller.closeGame();
    }
}
