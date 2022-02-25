package com.minesweeper.lab3.consoleview.utility;

import java.io.PrintWriter;
import java.util.Scanner;

public class ConsoleView {
    private boolean hasShow = false;
    private boolean inNeedUpdate = false;
    protected PrintWriter writer;
    protected Scanner reader;

    public ConsoleView(){
        writer = new PrintWriter(System.out, true);
        reader = new Scanner(System.in);
    }

    synchronized public void redraw(){
        inNeedUpdate = true;
    }

    synchronized public void show(){
        if(!hasShow) {
            hasShow = true;
            Thread showThread = new Thread(() -> {
                System.out.println("Thread start: "+ Thread.currentThread().getName());
                while (hasShow) {
                    if(inNeedUpdate) {
                        draw(writer);
                        read(reader);
                    }
                }
            });
            showThread.start();
        }
    }

    synchronized public void draw(PrintWriter writer){

    }

    synchronized public void read(Scanner reader){

    }


    synchronized public void hide() {
        hasShow = false;
    }
}