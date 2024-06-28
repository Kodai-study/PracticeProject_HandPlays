package console;

import java.util.ArrayList;
import java.util.List;

public class SelectorOutputTester implements ITerminalManager {

    private List<String> output;

    public SelectorOutputTester() {
        output = new ArrayList<String>();
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOneCharInput'");
    }

}
