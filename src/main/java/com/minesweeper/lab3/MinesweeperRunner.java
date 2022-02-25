package com.minesweeper.lab3;

import java.io.PrintWriter;
import java.util.Scanner;

public class MinesweeperRunner {
    public static void main(String args[]){
        System.out.println("Main thread: " + Thread.currentThread().getName());
        MinesweeperLauncher launcher = new MinesweeperLauncher(Service.UI.Console);
        launcher.toMainMenu();
    }
}

