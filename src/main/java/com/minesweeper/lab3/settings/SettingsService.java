package com.minesweeper.lab3.settings;

import com.minesweeper.lab3.MinesweeperLauncher;
import com.minesweeper.lab3.Service;

public class SettingsService implements Service {
    private final MinesweeperLauncher launcher;
    private final SettingsModel model;
    private final SettingsController controller;
    private SettingsView view;

    public SettingsService(MinesweeperLauncher launcher, UI type){
        this.launcher = launcher;
        model = new SettingsModel();
        controller = new SettingsController(this, model);
        buildUI(type);
    }

    private void buildUI(UI type){
        view = new ConsoleSettingsView(model, controller);
        //TODO change UI
    }

    @Override
    public void start() {
        model.downloadSettings();
        view.show();
    }

    public void goToMainMenu() {
        view.hide();
        launcher.toMainMenu();
    }
}
