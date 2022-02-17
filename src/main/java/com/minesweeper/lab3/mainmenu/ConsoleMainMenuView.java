package com.minesweeper.lab3.mainmenu;

import com.minesweeper.lab3.mainmenu.observer.MainMenuObservable;

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class ConsoleMainMenuView implements MainMenuView {

    public ConsoleMainMenuView(MainMenuObservable observable, MainMenuController controller){
        writer = new PrintWriter(System.out, true);
        reader = new Scanner(System.in);
        this.controller = controller;
        this.observable = observable;
        observable.registerObserver(this);
    }

    private String menuOptionsToString(MenuOptions option) {
        return switch (option) {
            case NEW_GAME -> "New game";
            case SETTINGS -> "Settings";
            case EXIT -> "Exit";
            case HIGH_SCORES -> "High scores";
        };
    }

    private void showMenu(List<MenuOptions> options){
        writer.println("\t\tMinesweeper\t\t");
        for(int i = 0; i < options.size(); i++){
            writer.println((i+1) + ". " + menuOptionsToString(options.get(i)));
        }
    }

    private void handleInput(List<MenuOptions> options){
        int numOption;
        do {
            writer.println("Choose 1-" + options.size() + ": ");
            numOption = reader.nextInt();
        } while (numOption <= 0 || numOption > options.size());
        controller.goTo(options.get(numOption - 1));
    }

    private final PrintWriter writer;
    private final Scanner reader;
    private final MainMenuObservable observable;
    private final MainMenuController controller;


    @Override
    public void update() {
        List<MenuOptions> options = observable.getOptions();
        showMenu(options);
        handleInput(options);
    }
}
