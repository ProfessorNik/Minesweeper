package com.minesweeper.lab3.settings;

import com.minesweeper.lab3.consoleview.utility.ConsoleView;
import com.minesweeper.lab3.db.Settings;
import com.minesweeper.lab3.settings.observer.SettingsObservable;

import java.io.PrintWriter;
import java.util.Scanner;

public class ConsoleSettingsView extends ConsoleView implements SettingsView {
    private final SettingsObservable observable;
    private Settings settings;
    private final SettingsController controller;

    public ConsoleSettingsView(SettingsObservable observable, SettingsController controller){
        this.observable = observable;
        this.controller = controller;
    }

    @Override
    public synchronized void draw(PrintWriter writer) {
        writer.println("Field size: " + settings.getSizeX() + " x "
                + settings.getSizeY() + " number bomb: " + settings.getNumBomb());
        writer.println("Will change settings or quit: ");
    }

    @Override
    public synchronized void read(Scanner reader) {

    }

    @Override
    public void update() {
        this.settings = observable.getSettings();
        redraw();
    }
}
