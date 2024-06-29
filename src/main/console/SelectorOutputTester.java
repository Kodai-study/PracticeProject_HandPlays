package main.console;

import java.util.ArrayList;
import java.util.List;

public class SelectorOutputTester implements ITerminalManager {

    private List<String> output;

    private List<Integer> input = new ArrayList<>();

    public SelectorOutputTester() {
        output = new ArrayList<String>();
    }

    public void addInputKeyCodes(int... keyCodes) {
        for (int keyCode : keyCodes) {
            input.add(keyCode);
        }
    }

    public String[] getOutput() {
        return output.toArray(new String[0]);
    }

    @Override
    public void clearScreen() {
        output.clear();
    }

    @Override
    public void printLine(String line) {
        output.add(line);
    }

    @Override
    public void print(String str) {
        str.lines().forEach((strLine) -> output.add(strLine));
    }

    @Override
    public int getOneCharInput() {
        if (input.isEmpty()) {
            return 13;
        }
        return input.removeFirst();
    }

}
