package com.minesweeper.lab3.db;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSettingsData extends SettingsData {
    @Override
    public void downloadData() {
        try(Scanner scanner = new Scanner(new FileReader(fileName))){
            settings.userName = scanner.nextLine();
            settings.sizeX = scanner.nextInt();
            settings.sizeY = scanner.nextInt();
            settings.numBomb = scanner.nextInt();
        }catch (IOException e){
            super.setStandardSettings();
        }
    }

    @Override
    public void saveData() {
        try(FileWriter writer = new FileWriter(fileName)){
            writer.write(settings.userName + "\n");
            writer.write(settings.sizeX);
            writer.write(" ");
            writer.write(settings.sizeY);
            writer.write(" ");
            writer.write(settings.numBomb);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public final String fileName = "data/settings.csv";
}
