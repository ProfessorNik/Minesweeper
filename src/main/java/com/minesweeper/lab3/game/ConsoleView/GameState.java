package com.minesweeper.lab3.game.ConsoleView;

import com.minesweeper.lab3.game.Cells;
import com.minesweeper.lab3.game.GameController;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameState extends ConsoleGameViewState {
    private final List<InputToAction> actions;

    GameState(ConsoleGameView view){
        super(view);
        actions = new ArrayList<>();
        actions.add(new InputToStep(view.controller));
        actions.add(new InputToAddFlag(view.controller));
        actions.add(new InputToDelFlag(view.controller));
        actions.add(new InputToExit(view.controller));
    }

    @Override
    public void drawUI(List<Cells> field) {
        drawField(field);
        waitingStep();
    }

    private void waitingStep(){
        String userInput;
        do {
            userInput = view.reader.nextLine();
        } while(!parseUserInput(userInput));
    }

    private boolean parseUserInput(String userInput){
        for(InputToAction action : actions){
            if(action.isValidInput(userInput)) {
                action.doAction(userInput);
                return true;
            }
        }
        return false;
    }
}


abstract class InputToAction {
    InputToAction(Pattern pattern, GameController controller){
        this.pattern = pattern;
        this.controller = controller;
    }

    public boolean isValidInput(String input) {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    abstract void doAction(String input);

    protected final Pattern pattern;
    protected final Pattern word = Pattern.compile("\\w+");
    protected final GameController controller;
}

class InputToStep extends InputToAction{
    InputToStep(GameController controller){
        super(Pattern.compile("\\s*\\d+\\s+\\d+\\s*"), controller);
    }
    @Override
    public void doAction(String input) {
        Matcher wordMatcher = word.matcher(input);
        wordMatcher.find();
        int x = Integer.parseInt(wordMatcher.group());
        wordMatcher.find();
        int y = Integer.parseInt(wordMatcher.group());
        controller.setStep(x, y);
    }
}

class InputToAddFlag extends InputToAction{
    InputToAddFlag(GameController controller){
        super(Pattern.compile("\\s*f\\s+\\d+\\s+\\d+\\s*"), controller);
    }

    @Override
    public void doAction(String input) {
        Matcher wordMatcher = word.matcher(input);
        wordMatcher.find();
        wordMatcher.group();
        wordMatcher.find();
        int x = Integer.parseInt(wordMatcher.group());
        wordMatcher.find();
        int y = Integer.parseInt(wordMatcher.group());
        controller.setFlag(x, y);
    }
}

class InputToDelFlag extends InputToAction{
    InputToDelFlag(GameController controller){
        super(Pattern.compile("\\s*df\\s+\\d+\\s+\\d+\\s*"), controller);
    }
    @Override
    public void doAction(String input) {
        Matcher wordMatcher = word.matcher(input);
        wordMatcher.find();
        wordMatcher.group();
        wordMatcher.find();
        int x = Integer.parseInt(wordMatcher.group());
        wordMatcher.find();
        int y = Integer.parseInt(wordMatcher.group());
        controller.deleteFlag(x, y);
    }
}

class InputToExit extends InputToAction{
    InputToExit(GameController controller){
        super(Pattern.compile("\\s*q\\s*"), controller);
    }
    @Override
    public void doAction(String input) {
        controller.closeGame();
    }
}

