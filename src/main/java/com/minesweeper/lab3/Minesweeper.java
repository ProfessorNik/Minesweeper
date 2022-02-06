package com.minesweeper.lab3;

import com.minesweeper.lab3.game.field.BackgroundField;
import com.minesweeper.lab3.game.Cells;

import java.util.List;

public class Minesweeper {
    public static void main(String args[]){
        BackgroundField field = new BackgroundField(9, 9, 10);
        field.generateField();
        List<Cells> list = field.getField();
        int i = 0;
        for(Cells sell : list){
            if (i < 8) {
                System.out.print(sell + " ");
                i++;
            }
            else{
                System.out.println(sell);
                i = 0;
            }
        }
    }
}
