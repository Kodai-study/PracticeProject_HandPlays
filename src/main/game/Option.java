package main.game;

public class Option<T> {
    private int selectNumber;
    private T option;
    private String optionName;

    public int getSelectNumber() {
        return selectNumber;
    }

    public T getOption() {
        return option;
    }

    public String getOptionName() {
        return optionName;
    }

    public Option(int selectNumber, T option, String optionName) {
        this.selectNumber = selectNumber;
        this.option = option;
        this.optionName = optionName;
    }
}
