package main.game;

public interface IHandSelector<T> {
    public T selectOption();

    public T selectOptionLimited(T[] options);

    public T selectOptionLimited(int[] optionIndexes);
}
