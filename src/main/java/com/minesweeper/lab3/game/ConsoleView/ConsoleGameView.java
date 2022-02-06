package com.minesweeper.lab3.game.ConsoleView;

import com.minesweeper.lab3.game.Cells;
import com.minesweeper.lab3.game.GameController;
import com.minesweeper.lab3.game.GameView;
import com.minesweeper.lab3.game.observer.GameObservable;

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleGameView implements GameView {
    ConsoleGameView(GameObservable observable, GameController controller) {
        this.observable = observable;
        writer = new PrintWriter(System.out, true);
        reader = new Scanner(System.in);
    }

    char cellsToChar(Cells cell) {
        return switch (cell) {
            case EMPTY -> '0';
            case ONE -> '1';
            case TWO -> '2';
            case THREE -> '3';
            case FOUR -> '4';
            case FIVE -> '5';
            case SIX ->  '6';
            case SEVEN -> '7';
            case EIGHT -> '8';
            case BOMB -> '*';
            case UNKNOWN -> '#';
            case FLAG -> '$';
        };
    }

    protected void drawUserCapabilities() {
        writer.println("Write: \"x y\" ,for open cell");
        writer.println("Write: \"f x y\", to place the flag ");
        writer.println("Write: \"q\", for exit");
    }

    @Override
    public void update() {
        //TODO clear console
        //TODO change state
        state.drawUI(observable.getField());
    }

    protected int sizeX;
    protected int sizeY;

    protected PrintWriter writer;
    protected Scanner reader;
    protected GameController controller;
    private GameObservable observable;
    private GameState state;
}
