package main.game;

import java.util.ArrayList;
import java.util.List;
import main.console.ITerminalManager;
import main.console.OptionSelectManager;
import main.console.Selector;

public class PlayerHandSelector<T> implements IHandSelector<T> {

    private List<Option<T>> options;
    Selector<T> choiseSelector;
    ITerminalManager terminalManager;

    public PlayerHandSelector(List<Option<T>> options, Selector<T> choiseSelector, ITerminalManager terminalManager) {
        this.options = options;
        this.choiseSelector = choiseSelector;
        this.terminalManager = terminalManager;
    }

    private T selectOptionNumber(List<Option<T>> options) {
        while (true) {
            int selectedNumber = OptionSelectManager.getSelectedIndex(choiseSelector, terminalManager);
            for (Option<T> option : options) {
                if (option.getSelectNumber() == selectedNumber) {
                    return option.getOption();
                }
            }
            terminalManager.printLine("正しい数字を選択してください。");
        }
    }

    @Override
    public T selectOption() {
        return selectOptionNumber(this.options);
    }

    @Override
    public T selectOptionLimited(T[] options) {
        List<Option<T>> optionalList = new ArrayList<Option<T>>();
        for (Option<T> option : this.options) {
            for (T opt : options) {
                if (option.getOption().equals(opt)) {
                    optionalList.add(option);
                }
            }
        }
        return selectOptionNumber(optionalList);
    }

    @Override
    public T selectOptionLimited(int[] optionIndexes) {
        List<Option<T>> optionalList = new ArrayList<>();
        for (Option<T> option : this.options) {
            for (int index : optionIndexes) {
                if (option.getSelectNumber() == index) {
                    optionalList.add(option);
                }
            }
        }
        return selectOptionNumber(optionalList);
    }

}
