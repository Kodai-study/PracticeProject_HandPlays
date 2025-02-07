package main.console;

public class Selector {
    private String[] options;
    private int selectedIndex = 0;
    ITerminalManager terminalManager;

    public Selector(String[] options, ITerminalManager terminalManager) {
        this.options = options;
        this.terminalManager = terminalManager;
    }

    public void selectUp() {
        terminalManager.clearScreen();
        selectedIndex = (selectedIndex - 1 + options.length) % options.length;
        viewOptions();
    }

    public void selectDown() {
        terminalManager.clearScreen();
        selectedIndex = (selectedIndex + 1) % options.length;
        viewOptions();
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void viewOptions() {
        terminalManager.clearScreen();
        for (int i = 0; i < options.length; i++) {
            StringBuffer line = new StringBuffer("");
            if (i == selectedIndex) {
                line.append(" > ");
            } else {
                line.append("   ");
            }
            terminalManager.printLine(line.append(options[i]).toString());
        }
    }
}
