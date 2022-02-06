package com.minesweeper.lab3.game.observer;

import com.minesweeper.lab3.game.Cells;

import java.util.ArrayList;
import java.util.List;

public abstract class GameObservable {
    public GameObservable(){
        listeners = new ArrayList<>();
    }

    public void registerObserver(GameObserver listener){
        listeners.add(listener);
    }

    public void removeObserver(GameObserver listener){
        listeners.remove(listener);
    }

    public void notifyObservers(){
        for (GameObserver listener: listeners) {
            listener.update();
        }
    }

    abstract public List<Cells> getField();

    private List<GameObserver> listeners;
}
