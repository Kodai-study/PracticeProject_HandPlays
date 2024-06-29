package main.game;

import java.util.Random;

public class RandomSelectEnemy<T> implements IHandSelector<T> {

    private T[] options;
    private int numberOfChoices;
    private Random random = new Random();

    public RandomSelectEnemy(T[] options) {
        this.options = options;
        this.numberOfChoices = options.length;
    }

    @Override
    public T selectOption() {
        int selectedIndex = random.nextInt(numberOfChoices);
        return options[selectedIndex];
    }

    @Override
    public T selectOptionLimited(T[] options) {
        int selectedIndex = random.nextInt(options.length);
        return options[selectedIndex];
    }

    @Override
    public T selectOptionLimited(int[] optionIndexes) {
        int selectedIndex = random.nextInt(optionIndexes.length);
        return options[optionIndexes[selectedIndex]];
    }

}
