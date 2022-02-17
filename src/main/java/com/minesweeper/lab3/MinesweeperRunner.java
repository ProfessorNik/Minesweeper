package com.minesweeper.lab3;

import com.minesweeper.lab3.game.GameService;

public class MinesweeperRunner {
    public static void main(String args[]){
        Minesweeper minesweeper = new Minesweeper(Service.UI.Console);
        minesweeper.toMainMenu();
    }
}
