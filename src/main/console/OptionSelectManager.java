package main.console;

public class OptionSelectManager {
    static public int getSelectedIndex(Selector selector, ITerminalManager terminalManager) {
        InputController inputController = new InputController();
        while (true) {
            int i = terminalManager.getOneCharInput();
            // System.out.println(i);
            inputController.regist_input(i);
            InputType inputType = inputController.get_input_type();
            if (inputType.equals(InputType.Enter)) {
                return selector.getSelectedIndex() + 1;
            }
            if (inputType.equals(InputType.Number)) {
                int number = inputController.get_number_input();
                return number;
            }
            if (inputType.equals(InputType.ArrayKey)) {
                ArrayKeys arrayKeys = inputController.get_array_input_key();
                switch (arrayKeys) {
                    case Up:
                        selector.selectUp();
                        break;
                    case Down:
                        selector.selectDown();
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
