package main.console;

import java.util.List;

import main.game.Option;

public class Selector<T> {
    private List<Option<T>> options;
    private int selectedIndex = 0;
    ITerminalManager terminalManager;

    public Selector(List<Option<T>> options, ITerminalManager terminalManager) {
        this.options = options;
        this.terminalManager = terminalManager;
    }

    public void selectUp() {
        terminalManager.clearScreen();
        selectedIndex = (selectedIndex - 1 + options.size()) % options.size();
        viewOptions();
    }

    public void selectDown() {
        terminalManager.clearScreen();
        selectedIndex = (selectedIndex + 1) % options.size();
        viewOptions();
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void viewOptions() {
        for (int i = 0; i < options.size(); i++) {
            StringBuffer line = new StringBuffer("");
            if (i == selectedIndex) {
                line.append(" > ");
            } else {
                line.append("   ");
            }
            line.append(options.get(i).getOptionName());
            terminalManager.printLine(line.toString());
        }
    }
}
