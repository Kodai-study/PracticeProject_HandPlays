import console.ArrayKeys;
import console.InputType;

public class InputController {

    private int[] input_history = new int[4];
    private int history_index = 0;
    private static int HISTORY_SIZE = 4;
    private ArrayKeys array_input = null;

    public void regist_input(int key_code) {
        input_history[history_index] = key_code;
        history_index = (history_index + 1) % HISTORY_SIZE;
    }

    public InputType get_input_type() {
        ArrayKeys key_input = get_array_input();
        if (key_input != null) {
            array_input = key_input;
            return InputType.ArrayKey;
        }
        array_input = null;
        int last_input = get_previous_input(1);
        if (last_input >= 48 && last_input <= 57) {
            return InputType.Number;
        }
        if (last_input < 65)
            return InputType.Other;
        if (last_input < 90 || last_input > 97)
            return InputType.Other;
        if (last_input > 122)
            return InputType.Other;
        return InputType.Char;
    }

    public int get_number_input() {
        return get_previous_input(1) - 48;
    }

    public ArrayKeys get_array_input_key() {
        return array_input;
    }

    private ArrayKeys get_array_input() {
        if (get_previous_input(3) != 27) {
            return null;
        }
        if (get_previous_input(2) != 79) {
            return null;
        }
        return switch (get_previous_input(1)) {
            case 65 -> ArrayKeys.Up;
            case 66 -> ArrayKeys.Down;
            case 67 -> ArrayKeys.Right;
            case 68 -> ArrayKeys.Left;
            default -> null;
        };
    }

    private int get_previous_input(int previous_number) {
        int index = history_index - previous_number;
        if (index < 0) {
            index += HISTORY_SIZE;
        }
        return input_history[index];
    }

    public int input_number() {
        System.out.println("Input number");
        return 1;
    }
}
