package main.console;

public interface ITerminalManager {
    public void clearScreen();

    public void printLine(String line);

    public void print(String str);

    public int getOneCharInput();
}
