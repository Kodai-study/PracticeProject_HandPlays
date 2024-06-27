import console.InputType;

public class InputController {

    private int[] input_history = new int[4];
    private int history_index = 0;
    private static int HISTORY_SIZE = 4;

    public void regist_input(int key_code) {
        input_history[history_index] = key_code;
        history_index = (history_index + 1) % HISTORY_SIZE;
    }

    public InputType get_input_type() {
        return null;
    }

    public int input_number() {
        System.out.println("Input number");
        return 1;
    }
}
